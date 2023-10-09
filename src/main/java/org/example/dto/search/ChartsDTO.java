package org.example.dto.search;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;


@Data
@ToString
@Builder
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class ChartsDTO {
    @JsonProperty("loading")
    @JsonIgnore
    private boolean loading;

    @JsonProperty("loadingSubgroups")
    @JsonIgnore
    private boolean loadingSubgroups;

    @JsonProperty("loadingAfterClearAllSelectedFields")
    @JsonIgnore
    private boolean loadingAfterClearAllSelectedFields;

    @JsonProperty("isLoading")
    private boolean isLoading;

    @JsonProperty("isLoadingSubgroups")
    private boolean isLoadingSubgroups;

    @JsonProperty("error")
    private boolean error;

    @JsonProperty("data")
    private ChartsDataDTO data;

    @JsonProperty("selectedFromLegendData")
    private String selectedFromLegendData;

    @JsonProperty("selectedLegendFields")
    private List<String> selectedLegendFields;

    @JsonProperty("selectedFacets")
    private List<ChartFacetDTO> selectedFacets;

    @JsonProperty("selection")
    private List<List<String>> selection;

    @JsonProperty("placementModeId")
    private String placementModeId;

    @JsonProperty("minBarViewOption")
    private String minBarViewOption;

    @JsonProperty("drawModesIds")
    private List<Integer> drawModesIds;

    @JsonProperty("percentageViewOption")
    private String percentageViewOption;

    @JsonProperty("valuesWithinChartOption")
    private String valuesWithinChartOption;

    @JsonProperty("medianLineViewOption")
    private String medianLineViewOption;

    @JsonProperty("latestGlobalOffset")
    private ChartGlobalOffsetDTO latestGlobalOffset;

    @JsonProperty("isLoadingAfterClearAllSelectedFields")
    private boolean isLoadingAfterClearAllSelectedFields;

}

