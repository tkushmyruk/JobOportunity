package org.example.dto.staffing;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

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
}
