package org.example.dto.teams;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Data
@ToString
@Builder
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class TeamsMessage {
    @JsonProperty("@type")
    String type;
    @JsonProperty("@context")
    String context;
    @JsonProperty("themeColour")
    String themeColour;
    @JsonProperty("summary")
    String summary;
    @JsonProperty("sections")
    List<Section> sections;
    @JsonProperty("potentialAction")
    List<PotentialAction> potentialActions;
}
