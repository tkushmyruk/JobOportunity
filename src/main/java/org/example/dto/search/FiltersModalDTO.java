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
public class FiltersModalDTO {
    @JsonProperty("isOpen")
    private boolean isOpen;

    @JsonProperty("items")
    private List<Object> items;

    @JsonProperty("displayItems")
    private List<Object> displayItems;

    @JsonProperty("selected")
    private List<Object> selected;

    @JsonProperty("settings")
    private List<Object> settings;

    @JsonProperty("sortOrder")
    private int sortOrder;

    @JsonProperty("filtersViewMode")
    private int filtersViewMode;

    @JsonProperty("categories")
    private List<Object> categories;
}
