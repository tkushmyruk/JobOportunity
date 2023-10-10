package org.example.dto.teams;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Data
@ToString
@Builder
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class PotentialAction {
    @JsonProperty("@type")
    String type;
    @JsonProperty("name")
    String name;
    @JsonProperty("targets")
    List<Target> targets;
}
