package org.example.dto.search;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Data
@ToString
@Builder
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class CardsDTO {
    @JsonProperty("groups")
    private List<String> groups;

    @JsonProperty("data")
    private List<CardDataDTO> data;

    @JsonProperty("error")
    private boolean error;

    @JsonProperty("isLoading")
    private boolean isLoading;

    @JsonProperty("hasData")
    private boolean hasData;

    @JsonProperty("matchedCount")
    private int matchedCount;

    @JsonProperty("columns")
    private List<String> columns;
}
