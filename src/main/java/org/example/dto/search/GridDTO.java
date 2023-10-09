package org.example.dto.search;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Data
@ToString
@Builder
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class GridDTO {
    @JsonProperty("isLoading")
    private boolean isLoading;

    @JsonProperty("groups")
    private List<Object> groups; // You can replace 'Object' with the appropriate class if needed

    @JsonProperty("data")
    private List<Object> data; // You can replace 'Object' with the appropriate class if needed

    @JsonProperty("error")
    private boolean error;

    @JsonProperty("mode")
    private int mode;

    @JsonProperty("columns")
    private List<GridColumnDTO> columns;

    @JsonProperty("selectedColumns")
    private List<SelectedGridColumnDTO> selectedColumns;

    @JsonProperty("searchString")
    private String searchString;

    @JsonProperty("pageSize")
    private int pageSize;

    @JsonProperty("childEntityFlags")
    private Object childEntityFlags; // You can replace 'Object' with the appropriate class if needed

    @JsonProperty("batchItems")
    private List<Object> batchItems; // You can replace 'Object' with the appropriate class if needed

    @JsonProperty("isAllBatched")
    private boolean isAllBatched;

    @JsonProperty("isSomeBatched")
    private boolean isSomeBatched;

    @JsonProperty("matchedCount")
    private int matchedCount;

    @JsonProperty("selectedOnTop")
    private boolean selectedOnTop;

    @JsonProperty("sdtData")
    private Object sdtData;
}
