package org.example.dto.teams;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@ToString
@Builder
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class Target {
    @JsonProperty("os")
    String os;
    @JsonProperty("uri")
    String uri;
}
