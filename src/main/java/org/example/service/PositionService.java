package org.example.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
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
    private PostFeignClient client;
    @Autowired
    private PositionClient positionClient;
    @Autowired
    private StaffingClient staffingClient;
    @Autowired
    private ObjectMapper mapper;
    @Autowired
    private EmailServiceImpl emailService;
    @Autowired
    private TeamsService teamsService;
    @Autowired
    private MailAddressRepository repository;
    public boolean isJobEnabled;
    public String cookie;

    @Scheduled(initialDelay = 120000, fixedRate = 1800000)
    @Transactional
    public void callClient() {
        if (isJobEnabled) {
            try {
                log.info("Job started");
                SearchDto searchDto = client.getSearchDto(cookie);
                PositionRequestDTO reqw = PositionRequestDTO.builder().searchDto(searchDto).build();
                String search = mapper.writeValueAsString(reqw);

                ResponseDTO responseDTO = positionClient.getPositions(cookie, search);
                List<PositionDTO> filteredPositions = filterPositionByCreationDate(responseDTO);

                if(filteredPositions.isEmpty()){
                    log.info("There is no new positions");
                    return;
                }

                List<PositionDTO> positionsDTO = setupEnglishLvlForPosition(filteredPositions);
                log.info("{} positions was received", positionsDTO.size());

                teamsService.teamsMessageSend(positionsDTO);
                log.info("Messages was sent to Microsoft Teams");

                String[] allAddresses = repository.findAllAddresses();
                log.info("{} email addresses", allAddresses);
                emailService.sendMail(allAddresses, CookieUtil.FROM_EMAIL, CookieUtil.MAIL_SUBJECT, positionsDTO);
            } catch (Exception e) {
                log.error("Job was failed due to {}", e.getMessage());
            }

        } else {
            log.info("Job is disabled");
        }
    }

    public boolean isEnabled(){
        return isJobEnabled;
    }

    public boolean enableJob() {
        isJobEnabled = !isJobEnabled;
        log.info("Job new status {}", isJobEnabled);

        return isJobEnabled;
    }

    private List<PositionDTO> filterPositionByCreationDate(ResponseDTO responseDTO){
        return responseDTO.getPositions().stream()
                .filter(positionDTO -> (System.currentTimeMillis() - positionDTO.getCreationDate()) <= 1800000)
                .collect(Collectors.toList());
    }

    public List<PositionDTO> setupEnglishLvlForPosition(List<PositionDTO> positions) {
        return positions.stream().map(positionDTO -> {
            StaffingResponse englishLevel = staffingClient.getEnglishLevel(CookieUtil.cookieTest, positionDTO.getId());
            if(englishLevel != null && englishLevel.getSpeakingEnglishLevelDTO() != null) {
                positionDTO.setEnglishLvl(englishLevel.getSpeakingEnglishLevelDTO().getName());
            }
            return positionDTO;
        }).collect(Collectors.toList());

    }
}
