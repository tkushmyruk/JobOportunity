package org.example.dto.search;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;
import java.util.Map;

@Data
@ToString
@Builder
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class FiltersDTO {
    @JsonProperty("active")
    private String active;

    @JsonProperty("activeSettings")
    private Map<String, Object> activeSettings;

    @JsonProperty("categories")
    private List<String> categories;

    @JsonProperty("collapsed")
    private boolean collapsed;

    @JsonProperty("displaySettings")
    private Map<String, List<Integer>> displaySettings;

    @JsonProperty("items")
    private List<FilterItemDTO> items;

    @JsonProperty("sortOrders")
    private Map<String, Integer> sortOrders;

    @JsonProperty("viewModes")
    private Map<String, Object> viewModes;

}
