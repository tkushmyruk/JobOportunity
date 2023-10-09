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
public class SearchDto {
    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("type")
    private int type;

    @JsonProperty("user")
    private String user;

    @JsonProperty("userId")
    private String userId;

    @JsonProperty("shared")
    private boolean shared;

    @JsonProperty("snapshot")
    private boolean snapshot;

    @JsonProperty("autosave")
    private boolean autosave;

    @JsonProperty("pinned")
    private boolean pinned;

    @JsonProperty("data")
    private DataDTO data;

    @JsonProperty("settings")
    private SettingsDTO settings;

    @JsonProperty("datasets")
    private List<String> datasets;

    @JsonProperty("labels")
    private List<String> labels;

    @JsonProperty("sharingDate")
    private String sharingDate;

    @JsonProperty("lastEvolutionStepCompleted")
    private int lastEvolutionStepCompleted;


}
