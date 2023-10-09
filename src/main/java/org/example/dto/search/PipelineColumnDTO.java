package org.example.dto.search;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.example.dto.search.ColumnOptionsDTO;

import java.util.Map;

@Data
@ToString
@Builder
@Value
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class PipelineColumnDTO {
    @JsonProperty("name")
    private String name;

    @JsonProperty("displayName")
    private String displayName;

    @JsonProperty("selected")
    private boolean selected;

    @JsonProperty("width")
    private int width;

    @JsonProperty("minWidth")
    private int minWidth;

    @JsonProperty("locked")
    private boolean locked;

    @JsonProperty("options")
    private Map<String, ColumnOptionsDTO> options;
}
