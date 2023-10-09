package org.example.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.example.client.PositionClient;
import org.example.client.PostFeignClient;
import org.example.client.StaffingClient;
import org.example.dto.position.PositionDTO;
import org.example.dto.position.ResponseDTO;
import org.example.dto.search.PositionRequestDTO;
import org.example.dto.search.SearchDto;
import org.example.dto.staffing.StaffingResponse;
import org.example.repository.MailAddressRepository;
import org.example.util.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@Setter
public class PositionService {
    @Autowired
    public PostFeignClient client;
    @Autowired
    public PositionClient positionClient;
    @Autowired
    StaffingClient staffingClient;
    @Autowired
    public ObjectMapper mapper;
    @Autowired
    private EmailServiceImpl emailService;
    @Autowired
    private TeamsService teamsService;
    @Autowired
    private MailAddressRepository repository;
    public boolean isJobEnabled = true;
    public String cookie;

    @Scheduled(fixedRate = 150000)
    @Transactional
    public void callClient() {
        if (isJobEnabled) {
            try {
                log.info("Job started");
                SearchDto searchDto = client.getSearchDto(CookieUtil.cookieTest);
                PositionRequestDTO reqw = PositionRequestDTO.builder().searchDto(searchDto).build();
                String search = mapper.writeValueAsString(reqw);

                ResponseDTO responseDTO = positionClient.getPositions(CookieUtil.cookieTest, search);
                List<PositionDTO> positionsDTO = setupEnglishLvlForPosition(responseDTO);
                log.info("{} positions was received", positionsDTO.size());

                teamsService.teamsMessageSend(positionsDTO);
                log.info("Messages was sent to Microsoft Teams");

                String[] allAddresses = repository.findAllAddresses();
                log.info("{} email addresses", allAddresses);
//                emailService.sendMail(allAddresses, CookieUtil.FROM_EMAIL, CookieUtil.MAIL_SUBJECT, positionsDTO);
            } catch (Exception e) {
                log.error("Job was failed due to {}", e.getMessage());
            }

        } else {
            log.info("Job is disabled");
        }
    }

    public void enableJob() {
        isJobEnabled = !isJobEnabled;
        log.info("Job new status {}", isJobEnabled);
    }

    public List<PositionDTO> setupEnglishLvlForPosition(ResponseDTO responseDTO) {
        return responseDTO.getPositions().stream().map(positionDTO -> {
            StaffingResponse englishLevel = staffingClient.getEnglishLevel(CookieUtil.cookieTest, positionDTO.getId());
            if(englishLevel != null && englishLevel.getSpeakingEnglishLevelDTO() != null) {
                positionDTO.setEnglishLvl(englishLevel.getSpeakingEnglishLevelDTO().getName());
            }
            return positionDTO;
        }).collect(Collectors.toList());

    }
}
