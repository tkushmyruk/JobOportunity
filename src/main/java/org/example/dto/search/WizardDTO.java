package org.example.dto.search;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;

import java.util.List;

@Data
@ToString
@Builder
@Value
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class WizardDTO {
    @JsonProperty("isOpen")
    boolean isOpen;

    @JsonProperty("options")
    List<String> options;

    @JsonProperty("inEditFilter")
    String inEditFilter;
}
