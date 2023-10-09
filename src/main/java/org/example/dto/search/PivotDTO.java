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
public class PivotDTO {
    @JsonProperty("error")
    private boolean error;

    @JsonProperty("isLoading")
    private boolean isLoading;

    @JsonProperty("totalCount")
    private int totalCount;

    @JsonProperty("percentagesView")
    private String percentagesView;

    @JsonProperty("colorVisualizationView")
    private String colorVisualizationView;

    @JsonProperty("dataBarsRangeView")
    private String dataBarsRangeView;

    @JsonProperty("cellNumberingView")
    private String cellNumberingView;

    @JsonProperty("sortByPercentages")
    private String sortByPercentages;

    @JsonProperty("columnFacets")
    private List<Object> columnFacets;

    @JsonProperty("rowFacets")
    private List<Object> rowFacets;

    @JsonProperty("isPivotCollapsed")
    private boolean isPivotCollapsed;
}
