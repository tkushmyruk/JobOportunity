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
public class SortOptionDTO {
    @JsonProperty("text")
    private String text;

    @JsonProperty("selected")
    private boolean selected;

    @JsonProperty("value")
    private String value;
}
