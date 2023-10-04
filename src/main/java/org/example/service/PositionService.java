package org.example.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.example.client.PositionClient;
import org.example.client.PostFeignClient;
import org.example.dto.position.PositionDTO;
import org.example.dto.search.PositionRequestDTO;
import org.example.dto.search.SearchDto;
import org.example.repository.MailAddressRepository;
import org.example.util.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class PositionService {
    @Autowired
    public PostFeignClient client;
    @Autowired
    public PositionClient positionClient;
    @Autowired
    public ObjectMapper mapper;
    @Autowired
    private EmailServiceImpl emailService;
    @Autowired
    private MailAddressRepository repository;
    public boolean isJobEnabled;

    @Scheduled(fixedRate = 36000000)
    public void callClient() {
        if(isJobEnabled) {
            try {
                log.info("Job started");
                SearchDto searchDto = client.getSearchDto(CookieUtil.cookieTest);
                PositionRequestDTO reqw = PositionRequestDTO.builder().searchDto(searchDto).build();
                String search = mapper.writeValueAsString(reqw);
                List<PositionDTO> positions = positionClient.getPositions(CookieUtil.cookieTest, search);
                log.info("{} positions was received", positions.size());
                String[] allAddresses = repository.findAllAddresses();
                log.info("{} email addresses", allAddresses);
                emailService.sendMail(allAddresses, CookieUtil.FROM_EMAIL, CookieUtil.MAIL_SUBJECT, positions);
            } catch (Exception e){
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
}
