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
public class ChartFacetDTO {
    @JsonProperty("range")
    @JsonIgnore
    private boolean range;

    @JsonProperty("text")
    private String text;

    @JsonProperty("filterValue")
    private String filterValue;

    @JsonProperty("value")
    private String value;

    @JsonProperty("sortBy")
    private String sortBy;

    @JsonProperty("sortOrder")
    private String sortOrder;

    @JsonProperty("top")
    private int top;

    @JsonProperty("levels")
    private List<String> levels;

    @JsonProperty("sortings")
    private List<SortOptionDTO> sortings;

    @JsonProperty("isRange")
    private boolean isRange;
}
