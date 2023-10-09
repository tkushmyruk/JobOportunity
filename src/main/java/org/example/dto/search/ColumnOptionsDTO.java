package org.example.dto.search;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@ToString
@Builder
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class ColumnOptionsDTO {
    @JsonProperty("cellOptions")
    private CellOptionsDTO cellOptions;

    @JsonProperty("tooltipOptions")
    private TooltipOptionsDTO tooltipOptions;
}
