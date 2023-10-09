package org.example.dto.search;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Data
@ToString
@Builder
@Value
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class TreeMapFacetDTO {
    @JsonProperty("range")
    @JsonIgnore
    private boolean range;

    @JsonProperty("sortBy")
    private String sortBy;

    @JsonProperty("sortOrder")
    private String sortOrder;

    @JsonProperty("levels")
    private List<String> levels;

    @JsonProperty("sortings")
    private List<TreeMapSortingDTO> sortings;

    @JsonProperty("isRange")
    private boolean isRange;

    @JsonProperty("text")
    private String text;

    @JsonProperty("filterValue")
    private String filterValue;

    @JsonProperty("top")
    private int top;

    @JsonProperty("value")
    private String value;
}
