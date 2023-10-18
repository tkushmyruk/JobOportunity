package org.example.service;

import org.example.client.StaffingClient;
import org.example.dto.position.PositionDTO;
import org.example.dto.staffing.StaffingResponse;
import org.example.util.CookieUtil;
import org.jsoup.Jsoup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StaffingService {
    @Autowired
    private StaffingClient staffingClient;

    public List<PositionDTO> setStaffingInformation(List<PositionDTO> positions) {
        return positions.stream().map(positionDTO -> {
            StaffingResponse staffingResponse = staffingClient.getEnglishLevel(CookieUtil.cookieTest, positionDTO.getId());
            positionDTO.setEnglishLvl(setEnglishLevel(staffingResponse));
            positionDTO.setPositionLocations(getPositionLocations(staffingResponse));
            positionDTO.setDescription(setDescription(staffingResponse));

            return positionDTO;
        }).collect(Collectors.toList());
    }

    private String setDescription(StaffingResponse staffingResponse){
        return Jsoup.parse(staffingResponse.getDescription()).text();
    }

    private String setEnglishLevel(StaffingResponse staffingResponse) {
        if (staffingResponse != null && staffingResponse.getSpeakingEnglishLevelDTO() != null) {
            return staffingResponse.getSpeakingEnglishLevelDTO().getName();
        }
        return null;
    }

    private List<String> getPositionLocations(StaffingResponse staffingResponse) {
        if (staffingResponse.getStaffingLocationWithRegionsList() == null) {
            return null;
        }
        return staffingResponse.getStaffingLocationWithRegionsList().stream()
                .map(location -> {
                    if (location.getType().equals("Country")) {
                        return location.getName();
                    }
                    return null;
                }).collect(Collectors.toList());
    }


}
