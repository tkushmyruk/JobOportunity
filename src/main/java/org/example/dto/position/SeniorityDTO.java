package org.example.dto.position;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Data
@ToString
@Builder
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class SeniorityDTO {
    @JsonProperty("level")
    List<String> seniorityLvl;
}
