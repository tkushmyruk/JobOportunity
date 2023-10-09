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
public class TreemapDTO {
    @JsonProperty("selectedFacets")
    private List<TreeMapFacetDTO> selectedFacets;

    @JsonProperty("relativeView")
    private String relativeView;

}
