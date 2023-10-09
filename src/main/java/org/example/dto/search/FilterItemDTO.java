package org.example.dto.search;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;
import java.util.Map;

@Data
@ToString
@Builder
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class FilterItemDTO {
    @JsonProperty("disabled")
    private boolean disabled;

    @JsonProperty("name")
    private String name;

    @JsonProperty("values")
    private List<ValueDTO> values;

    @JsonProperty("settings")
    private Map<String, Object> settings;

    @JsonProperty("mode")
    private int mode;

    @JsonProperty("preference")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String preference;

    @JsonProperty(value = "staffingStatusType")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String staffingStatusType;
}
