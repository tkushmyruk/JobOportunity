package org.example.dto.search;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;

import java.util.List;

@Data
@ToString
@Builder
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class ChartLegendDTO {
    @JsonProperty("firstLevel")
    private List<String> firstLevel;

    @JsonProperty("secondLevel")
    private List<String> secondLevel;

    @JsonProperty("thirdLevel")
    private List<String> thirdLevel;
}
