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
public class ColumnDTO {
    @JsonProperty("sortBy")
    private String sortBy;

    @JsonProperty("sortOrder")
    private String sortOrder;

    @JsonProperty("levels")
    private List<Object> levels;

    @JsonProperty("sortings")
    private List<Object> sortings;

    @JsonProperty("isRange")
    private boolean isRange;

    @JsonProperty("top")
    private Integer top;

    @JsonProperty("filterValue")
    private String filterValue;

    @JsonProperty("text")
    private String text;

    @JsonProperty("value")
    private String value;
}
