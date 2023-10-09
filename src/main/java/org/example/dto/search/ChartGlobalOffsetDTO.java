package org.example.dto.search;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;


@Data
@ToString
@Builder
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class ChartGlobalOffsetDTO {
    @JsonProperty("left")
    private int left;

    @JsonProperty("bottom")
    private int bottom;

    @JsonProperty("right")
    private int right;

    @JsonProperty("leftHat")
    private int leftHat;
}
