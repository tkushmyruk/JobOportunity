package org.example.service;

import org.example.dto.position.LocationDTO;
import org.example.dto.position.NoGoDTO;
import org.example.dto.position.PositionDTO;
import org.example.dto.teams.*;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class TeamsMessageService {
    private static final String CONTEXT = "http://schema.org/extensions";
    private static final String THEME_COLOUR = "#A1006B";
    private static final String STAFFING_URL = "https://staffing.epam.com/positions/";


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
                .activityTitle("Code|Stream: " +  positionDTO.getProjectCode())
                .facts(createFacts(positionDTO))
                .markdown(true)
                .build());

    }

    private List<Fact> createFacts(PositionDTO positionDTO) {
        List<Fact> listOfFacts = Arrays.asList(
                createSingleFact("Primary Role: ", positionDTO.getPrimaryRole()),
                createSingleFact("Primary Skill: ", positionDTO.getPrimarySkill().getPrimarySkill()),
                createSingleFact("Seniority: ", String.join(", ", positionDTO.getSeniorityLvl().getSeniorityLvl())),
                createSingleFact("Must Have Skills: ", mustHaveSkills(positionDTO)),
                createSingleFact("English level: ", positionDTO.getEnglishLvl()),
                createSingleFact("Position Locations: ", getLocationNameAsAList(positionDTO.getPositionLocations())),
                createSingleFact("No Go Locations: \n", getNoGoLocationAsAList(positionDTO.getNoGoDTOS())),
                createSingleFact("Position Billing Type: ", positionDTO.getPositionBillingType())
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


    private String getLocationNameAsAList(List<LocationDTO> objectList) {
        if(objectList.isEmpty()){
            return null;
        }
        return String.join(", \n", objectList.stream().map(object -> object.getDisplayName()).collect(Collectors.toList()));
    }

    private String getNoGoLocationAsAList(List<NoGoDTO> locations) {
        if(locations.isEmpty()){
            return null;
        }
        return String.join(", \n",locations.stream().flatMap(noGo -> noGo.getNoGoLocationList().stream())
                .map(location -> location.getFullName()).collect(Collectors.toList()));
    }

    private String mustHaveSkills(PositionDTO positionDTO) {
        List<String> mustHaveSkills = positionDTO.getSkills().stream()
                .filter(skillDTO -> skillDTO.isMustHave())
                .map(skillDTO -> skillDTO.getFullName())
                .collect(Collectors.toList());
        if(mustHaveSkills.isEmpty()){
            return null;
        }
        return String.join(", \n", mustHaveSkills);
    }

    private List<String> niceToHaveSkills(PositionDTO positionDTO) {
        return positionDTO.getSkills().stream()
                .filter(skillDTO -> !skillDTO.isMustHave())
                .map(skillDTO -> skillDTO.getFullName())
                .collect(Collectors.toList());

    }

    private List<PotentialAction> createPotentialActions(PositionDTO positionDTO){
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
