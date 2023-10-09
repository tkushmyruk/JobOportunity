package org.example.dto.search;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Data
@ToString
@Builder
@Value
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class ViewSettingDTO {
    @JsonProperty("id")
    private String id;

    @JsonProperty("title")
    private String title;

    @JsonProperty("mode")
    private String mode;

    @JsonProperty("options")
    private List<ViewSettingOptionDTO> options;

    @JsonProperty("selected")
    private boolean selected;
}
