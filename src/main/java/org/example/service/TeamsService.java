package org.example.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.client.TeamsClient;
import org.example.dto.teams.TeamsMessage;
import org.example.dto.position.LocationDTO;
import org.example.dto.position.NoGoDTO;
import org.example.dto.position.PositionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeamsService {

    @Autowired
    public TeamsClient teamsClient;
    @Autowired
    public ObjectMapper mapper;
    @Autowired
    public TeamsMessageService teamsMessageService;

    public void teamsMessageSend(List<PositionDTO> positionsDTO) {
        positionsDTO.stream().forEach(positionDTO -> {
//            String message = createMessage(positionDTO);
            TeamsMessage teamsMessageDto = teamsMessageService.createTeamsMessage(positionDTO);
            try {
                String teamsMessage = mapper.writeValueAsString(teamsMessageDto);
                teamsClient.sendMessageToTeams(teamsMessage);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        });
    }



//    public String createMessage(PositionDTO positionDTO) {
//        StringBuilder message = new StringBuilder();
//
//        message.append("Job Details:\n\n");
//        message.append(createRow("Domain: ", positionDTO.getDomain()));
//        message.append("\n\n");
//        message.append("Final view for MS Teams: \n\n");
//        message.append(STAFFING_URL + positionDTO.getId() + "\n\n");
//        message.append(createRow("Code|Stream: ", positionDTO.getProjectCode()));
//        message.append(createRow("Primary Role: ", positionDTO.getPrimaryRole()));
//        message.append(createRow("Primary Skill: ", positionDTO.getPrimarySkill().getPrimarySkill()));
//        message.append(createRow("Seniority: ", String.join(", ", positionDTO.getSeniorityLvl().getSeniorityLvl())));
//        message.append(createRow("Must Have Skills:\n\n", String.join(", \n", mustHaveSkills(positionDTO))));
//        message.append(createRow("English level: ", positionDTO.getEnglishLvl()));
//        message.append(createRow("Position Locations: \n\n", String.join(", \n", getLocationNameAsAList(positionDTO.getPositionLocations()))));
//        message.append(createRow("No Go Locations: \n", String.join(", \n", getNoGoLocationAsAList(positionDTO.getNoGoDTOS()))));
//        message.append(createRow("Position Billing Type: ", positionDTO.getPositionBillingType()));
//
//
//        return message.toString();
//    }
//
//    public String createRow(String title, String body) {
//        if (body != null && !body.isEmpty() && !body.equals("null")) {
//            return title + body + "\n\n";
//        }
//        return "";
//    }

}
