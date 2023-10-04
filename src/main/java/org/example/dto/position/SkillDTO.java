package org.example.dto.position;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@ToString
@Builder
@Value
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class SkillDTO {
    @JsonProperty("fullName")
    String fullName;
    @JsonProperty("isMustSkill")
    boolean isMustHave;
}
