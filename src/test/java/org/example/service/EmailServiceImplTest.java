package org.example.service;

import org.assertj.core.util.Arrays;
import org.example.dto.position.*;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.spring6.SpringTemplateEngine;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
class EmailServiceImplTest {

    @Autowired
    private EmailServiceImpl emailService;
    @Autowired
    private JavaMailSender sender;
    @Autowired
    private SpringTemplateEngine templateEngine;

    @Test
    void testMailTemplate() {
        LocationDTO location1 = new LocationDTO("Location 1");
        LocationDTO location2 = new LocationDTO("Location 2");
        LocationDTO location3 = new LocationDTO("Location 3");

        PrimarySkillDTO primarySkill = new PrimarySkillDTO("PHP");

        SeniorityDTO seniorityLvl = new SeniorityDTO(List.of("A2", "A3"));

        SkillDTO skill1 = new SkillDTO("PHP", true);
        SkillDTO skill2 = new SkillDTO("Amazon Web Services", true);
        SkillDTO skill3 = new SkillDTO("Go Language", false);

        StaffingCommitmentTypeDTO staffingCommitmentTypeDTO = new StaffingCommitmentTypeDTO("Type");

        PositionDTO positionDTO = PositionDTO.builder()
                .projectCode("ClGX")
                .primarySkill(primarySkill)
                .primaryRole("Developer")
                .seniorityLvl(seniorityLvl)
                .positionLocations(List.of(location1, location2, location3))
                .skills(List.of(skill1, skill2, skill3))
                .staffingCommitmentTypeDTO(staffingCommitmentTypeDTO)
                .positionBillingType("billing")
                .domain("domain")
                .build();


        PositionDTO positionDTO2 = PositionDTO.builder()
                .projectCode("ProjectManager")
                .primarySkill(primarySkill)
                .primaryRole("Developer")
                .seniorityLvl(seniorityLvl)
                .positionLocations(List.of(location1, location2, location3))
                .skills(List.of(skill1, skill2, skill3))
                .staffingCommitmentTypeDTO(staffingCommitmentTypeDTO)
                .positionBillingType("billing")
                .domain("domain")
                .build();

        List<PositionDTO> positionDTOs = List.of(positionDTO, positionDTO2);

        String[] addresses = Arrays.array("taras.kuhsmyruk@gmail.com");

        emailService.sendMail(addresses, "taras_kushmyruk@epam.com", "testEmailService", positionDTOs);

        System.out.println(emailService.createMailText(positionDTOs));


    }


}