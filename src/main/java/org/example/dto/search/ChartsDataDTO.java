package org.example.dto.search;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Data
@ToString
@Builder
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class ChartsDataDTO {
    @JsonProperty("groups")
    private List<String> groups;

    @JsonProperty("nodes")
    private List<String> nodes;

    @JsonProperty("links")
    private List<String> links;

    @JsonProperty("legend")
    private ChartLegendDTO legend;
}
