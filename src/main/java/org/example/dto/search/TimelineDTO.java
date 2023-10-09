package org.example.dto.search;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.example.dto.search.ColumnDTO;
import org.example.dto.search.ColumnOptionsDTO;

import java.util.List;

@Data
@ToString
@Builder
@Value
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class TimelineDTO {
    @JsonProperty("column")
    private ColumnDTO column;

    @JsonProperty("columnOptions")
    private ColumnOptionsDTO columnOptions;

    @JsonProperty("error")
    private boolean error;

    @JsonProperty("isLoading")
    private boolean isLoading;

    @JsonProperty("openAssignedChartsView")
    private String openAssignedChartsView;

    @JsonProperty("secondLineInfo")
    private String secondLineInfo;

    @JsonProperty("thirdLineInfo")
    private String thirdLineInfo;

    @JsonProperty("fteMode")
    private boolean fteMode;

    @JsonProperty("rowFacets")
    private List<Object> rowFacets;

    @JsonProperty("totalCount")
    private int totalCount;
}
