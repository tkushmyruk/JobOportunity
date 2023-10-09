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
public class PipelineDTO {
    @JsonProperty("isLoading")
    private boolean isLoading;

    @JsonProperty("pipelineGroups")
    private List<Object> pipelineGroups;

    @JsonProperty("columns")
    private List<PipelineColumnDTO> columns;

    @JsonProperty("selectedColumns")
    private List<PipelineColumnDTO> selectedColumns;

    @JsonProperty("searchString")
    private String searchString;

    @JsonProperty("error")
    private boolean error;

    @JsonProperty("data")
    private List<Object> data;

    @JsonProperty("mode")
    private int mode;

    @JsonProperty("groups")
    private List<Object> groups;
}
