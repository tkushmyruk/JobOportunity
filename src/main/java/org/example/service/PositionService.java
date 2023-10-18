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
import org.example.dto.search.FilterItemDTO;
import org.example.dto.search.PositionRequestDTO;
import org.example.dto.search.SearchDto;
import org.example.dto.search.ValueDTO;
import org.example.dto.staffing.StaffingResponse;
import org.example.filters.CreationDateFilter;
import org.example.repository.MailAddressRepository;
import org.example.util.CookieUtil;
import org.jsoup.Jsoup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
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
    private ObjectMapper mapper;
    @Autowired
    private EmailServiceImpl emailService;
    @Autowired
    StaffingService staffingService;
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
                PositionRequestDTO req = PositionRequestDTO.builder().searchDto(searchDto).build();
                PositionRequestDTO searchRequestDto = changeCreationDateRequest(req);

                String search = mapper.writeValueAsString(searchRequestDto);

                ResponseDTO responseDTO = positionClient.getPositions(cookie, search);
                List<PositionDTO> filteredPositions = CreationDateFilter.filterPositionByTime(responseDTO);

                if (filteredPositions.isEmpty()) {
                    log.info("There is no new positions");
                    return;
                }

                List<PositionDTO> positionsDTO = staffingService.setStaffingInformation(filteredPositions, cookie);
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

    public boolean isEnabled() {
        return isJobEnabled;
    }

    public boolean enableJob() {
        isJobEnabled = !isJobEnabled;
        log.info("Job new status {}", isJobEnabled);

        return isJobEnabled;
    }

    private PositionRequestDTO changeCreationDateRequest(PositionRequestDTO requestDTO) {
        List<FilterItemDTO> itemsWithoutCreationFilter = requestDTO.getSearchDto().getData().getFilters().getItems().stream()
                .filter(item -> !item.getName().equals("creationDate"))
                .collect(Collectors.toList());
        ValueDTO sinceValue = ValueDTO.builder().displayName("Today")
                .quantity(0)
                .sinceOrTill("since")
                .tense(0)
                .type("Day")
                .operator(2)
                .build();

        ValueDTO tillValue = ValueDTO.builder().displayName("Today")
                .quantity(0)
                .sinceOrTill("till")
                .tense(0)
                .type("Day")
                .operator(3)
                .build();


        FilterItemDTO creationDateFilter = FilterItemDTO.builder().disabled(false)
                .name("creationDate")
                .values(List.of(sinceValue, tillValue))
                .mode(1)
                .settings(new HashMap<String, Object>())
                .build();

        itemsWithoutCreationFilter.add(creationDateFilter);

        requestDTO.getSearchDto().getData().getFilters().setItems(itemsWithoutCreationFilter);

        return requestDTO;
    }



}
