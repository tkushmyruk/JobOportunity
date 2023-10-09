package org.example.dto.search;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Data
@ToString
@Builder
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class ConnectionsDTO {
    @JsonProperty("isLoading")
    private boolean isLoading;

    @JsonProperty("error")
    private boolean error;

    @JsonProperty("data")
    private List<Object> data;

    @JsonProperty("selectedFacets")
    private List<ChartFacetDTO> selectedFacets;

    @JsonProperty("selection")
    private List<List<Object>> selection;

    @JsonProperty("facets")
    private List<Object> facets;
}
