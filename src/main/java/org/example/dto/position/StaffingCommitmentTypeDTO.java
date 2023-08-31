package org.example.dto.position;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@ToString
@Builder
@Value
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class StaffingCommitmentTypeDTO {
    @JsonProperty("firstLevel")
    String type;
}
