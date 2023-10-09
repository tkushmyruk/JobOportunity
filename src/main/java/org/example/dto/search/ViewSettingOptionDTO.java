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
public class ViewSettingOptionDTO {
    @JsonProperty("text")
    private String text;

    @JsonProperty("selected")
    private boolean selected;

    @JsonProperty("value")
    private String value;

    @JsonProperty("icon")
    private String icon; // If needed

    @JsonProperty("iconTitle")
    private String iconTitle; // If needed
}
