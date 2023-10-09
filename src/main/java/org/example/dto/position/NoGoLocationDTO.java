package org.example.dto.position;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@ToString
@Builder
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class NoGoLocationDTO {
    @JsonProperty("fullName")
    String fullName;
}
