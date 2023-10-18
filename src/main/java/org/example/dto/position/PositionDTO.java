package org.example.dto.position;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Data
@ToString
@Builder
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class PositionDTO {
    @JsonProperty("_id")
    String id;
    @JsonProperty("role")
    PrimaryRoleDTO primaryRole;
    @JsonProperty("primarySkill")
    PrimarySkillDTO primarySkill;
    @JsonProperty("seniority")
    SeniorityDTO seniorityLvl;
    @JsonProperty("niceOrMustSkills")
    List<SkillDTO> skills;
    @JsonProperty("billingType")
    String positionBillingType;
    @JsonProperty("staffingCommitmentType")
    StaffingCommitmentTypeDTO staffingCommitmentTypeDTO;
    @JsonProperty("containerDomain")
    String domain;
    @JsonProperty("containerCode")
    String projectCode;
    @JsonProperty("noGo")
    List<NoGoDTO> noGoDTOS;
    @JsonProperty("creationDate")
    long creationDate;
    String englishLvl;
    List<String> positionLocations;
    String description;
}
