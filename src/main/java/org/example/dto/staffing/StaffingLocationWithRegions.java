package org.example.dto.staffing;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@ToString
@Builder
@Value
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class StaffingLocationWithRegions {
    @JsonProperty("name")
    String name;
    @JsonProperty("type")
    String type;
}
