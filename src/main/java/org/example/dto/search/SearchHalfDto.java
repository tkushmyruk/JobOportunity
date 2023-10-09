package org.example.dto.search;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.example.dto.search.FiltersDTO;

@Data
@ToString
@Builder
@Value
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class SearchHalfDto {
    @JsonProperty
    private String id;
    @JsonProperty
    private String name;
    @JsonProperty
    private int type;
    @JsonProperty
    private String user;
    @JsonProperty
    private long userId;
    @JsonProperty
    private boolean shared;
    @JsonProperty
    private FiltersDTO filtersDto;
}
