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
public class SelectedGridColumnDTO {
    @JsonProperty("name")
    private String name;

    @JsonProperty("isDefault")
    private boolean isDefault;

    @JsonProperty("width")
    private int width;

    @JsonProperty("minWidth")
    private int minWidth;

    @JsonProperty("sortOptions")
    private List<SortOptionDTO> sortOptions;

    @JsonProperty("viewSettings")
    private List<ViewSettingDTO> viewSettings;

    @JsonProperty("displayName")
    private String displayName;

    @JsonProperty("extendedName")
    private String extendedName;

    @JsonProperty("locked")
    private boolean locked;

    @JsonProperty("selected")
    private boolean selected;
}
