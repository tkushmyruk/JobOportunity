package org.example.dto.search;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;


@Data
@ToString
@Builder
@Value
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class ToolbarDTO {
    @JsonProperty("selectedGroupings")
    private List<SelectedGroupingDTO> selectedGroupings;

    @JsonProperty("sorting")
    private SortingDTO sorting;

    @JsonProperty("groupsSorting")
    private GroupsSortingDTO groupsSorting;

    @JsonProperty("sortingLevel")
    private int sortingLevel;

    @JsonProperty("searchIn")
    private List<Integer> searchIn;

    @JsonProperty("viewMode")
    private int viewMode;

    @JsonProperty("searchString")
    private String searchString;

    @JsonProperty("selectionMode")
    private int selectionMode;

    @JsonProperty("selectedModeDisabled")
    private boolean selectedModeDisabled;
}
