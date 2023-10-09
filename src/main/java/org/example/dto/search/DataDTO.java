package org.example.dto.search;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@ToString
@Builder
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class DataDTO {
    @JsonProperty("filters")
    private FiltersDTO filters;

    @JsonProperty("filteringMode")
    private String filteringMode;
}
