package org.example.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.client.TeamsClient;
import org.example.dto.teams.*;
import org.example.dto.position.LocationDTO;
import org.example.dto.position.NoGoDTO;
import org.example.dto.position.PositionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class TeamsService {
    private static final String CONTEXT = "http://schema.org/extensions";
    private static final String THEME_COLOUR = "#A1006B";
    private static final String STAFFING_URL = "https://staffing.epam.com/positions/";

    @Autowired
    public TeamsClient teamsClient;
    @Autowired
    public ObjectMapper mapper;

    public void teamsMessageSend(List<PositionDTO> positionsDTO) {
        positionsDTO.stream().forEach(positionDTO -> {
            TeamsMessage teamsMessageDto = createTeamsMessage(positionDTO);
            try {
                String teamsMessage = mapper.writeValueAsString(teamsMessageDto);
                teamsClient.sendMessageToTeams(teamsMessage);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public TeamsMessage createTeamsMessage(PositionDTO positionDTO) {
        return TeamsMessage.builder()
                .context(CONTEXT)
                .type("message")
                .themeColour(THEME_COLOUR)
                .summary("Job Details")
                .sections(createSections(positionDTO))
                .potentialActions(createPotentialActions(positionDTO))
                .build();
    }

    private List<Section> createSections(PositionDTO positionDTO) {

        return Arrays.asList(Section.builder()
                .activityTitle("Code|Stream: " + positionDTO.getProjectCode())
                .facts(createFacts(positionDTO))
                .markdown(true)
                .build());

    }

    private List<Fact> createFacts(PositionDTO positionDTO) {
        List<Fact> listOfFacts = Arrays.asList(
                createSingleFact("Primary Role: ", positionDTO.getPrimaryRole().getName()),
                createSingleFact("Primary Skill: ", positionDTO.getPrimarySkill().getPrimarySkill()),
                createSingleFact("Seniority: ", String.join(", ", positionDTO.getSeniorityLvl().getSeniorityLvl())),
                createSingleFact("Must Have Skills: ", mustHaveSkills(positionDTO)),
                createSingleFact("Nice to Have Skills", niceToHaveSkills(positionDTO)),
                createSingleFact("English level: ", positionDTO.getEnglishLvl()),
                createSingleFact("Position Locations: ", String.join(", ", positionDTO.getPositionLocations())),
                createSingleFact("No Go Locations: \n", getNoGoLocationAsAList(positionDTO.getNoGoDTOS())),
                createSingleFact("Position Billing Type: ", positionDTO.getPositionBillingType()),
                createSingleFact("Description: ", positionDTO.getDescription())
        );
        return listOfFacts.stream().filter(Objects::nonNull).toList();
    }

    private Fact createSingleFact(String name, String value) {

        if (value == null || value.isEmpty() || value.equals("null")) {
            return null;
        }
        return Fact.builder()
                .name(name)
                .value(value)
                .build();
    }

    private String getNoGoLocationAsAList(List<NoGoDTO> locations) {
        if (locations.isEmpty()) {
            return null;
        }
        return String.join(", \n", locations.stream().flatMap(noGo -> noGo.getNoGoLocationList().stream())
                .map(location -> location.getFullName()).collect(Collectors.toList()));
    }

    private String mustHaveSkills(PositionDTO positionDTO) {
        List<String> mustHaveSkills = positionDTO.getSkills().stream()
                .filter(skillDTO -> skillDTO.isMustHave())
                .map(skillDTO -> skillDTO.getFullName())
                .collect(Collectors.toList());
        if (mustHaveSkills.isEmpty()) {
            return null;
        }
        return String.join(", \n", mustHaveSkills);
    }

    private String niceToHaveSkills(PositionDTO positionDTO) {
        List<String> niceToHaveSkills = positionDTO.getSkills().stream()
                .filter(skillDTO -> !skillDTO.isMustHave())
                .map(skillDTO -> skillDTO.getFullName())
                .collect(Collectors.toList());
        if (niceToHaveSkills.isEmpty()) {
            return null;
        }
        return String.join(", \n", niceToHaveSkills);

    }

    private List<PotentialAction> createPotentialActions(PositionDTO positionDTO) {
        return Arrays.asList(
                PotentialAction.builder()
                        .type("OpenUri")
                        .name("Details")
                        .targets(createTargets(positionDTO))
                        .build()
        );
    }

    private List<Target> createTargets(PositionDTO positionDTO) {
        return Arrays.asList(
                Target.builder()
                        .os("default")
                        .uri(STAFFING_URL + positionDTO.getId())
                        .build()
        );
    }

}
