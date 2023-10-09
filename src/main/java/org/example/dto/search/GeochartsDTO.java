package org.example.dto.search;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Data
@ToString
@Builder
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class GeochartsDTO {
    @JsonProperty("data")
    private Object data;

    @JsonProperty("error")
    private boolean error;

    @JsonProperty("isLoading")
    private boolean isLoading;

    @JsonProperty("selectedFacets")
    private List<ChartFacetDTO> selectedFacets;

    @JsonProperty("mapViewBounds")
    private Object mapViewBounds;

    @JsonProperty("mapZoomLevel")
    private Object mapZoomLevel;
}
