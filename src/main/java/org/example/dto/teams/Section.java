package org.example.dto.teams;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Data
@ToString
@Builder
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class Section {
    @JsonProperty("activityTitle")
    String activityTitle;
    @JsonProperty("markdown")
    boolean markdown;
    @JsonProperty("facts")
    List<Fact> facts;
}
