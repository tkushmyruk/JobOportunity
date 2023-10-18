package org.example.dto.staffing;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Data
@ToString
@Builder
@Value
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class StaffingResponse {
    @JsonProperty("id")
    long id;
    @JsonProperty("speakingEnglishLevel")
    SpeakingEnglishLevelDTO speakingEnglishLevelDTO;
    @JsonProperty("staffingLocationsWithRegions")
    List<StaffingLocationWithRegions> staffingLocationWithRegionsList;
    @JsonProperty("description")
    String description;
}
