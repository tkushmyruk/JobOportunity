package org.example.dto.search;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;


@Data
@ToString
@Builder
@Value
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class PositionRequestDTO {
    @JsonProperty("search")
    SearchDto searchDto;

}
