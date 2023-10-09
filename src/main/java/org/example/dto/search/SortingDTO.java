package org.example.dto.search;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.*;


@Data
@ToString
@Builder
@Value
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class SortingDTO {
    @JsonProperty("by")
    private String by;

    @JsonProperty("order")
    private String order;

    @JsonProperty("default")
    private boolean isDefault;

    @JsonProperty("level")
    private int level;
}
