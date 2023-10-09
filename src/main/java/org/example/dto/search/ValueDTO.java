package org.example.dto.search;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;
import org.example.serializers.ValueDtoSerializer;

@Data
@ToString
@Builder
@Value
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@AllArgsConstructor
@JsonSerialize(using = ValueDtoSerializer.class)
public class ValueDTO {

    private String name;

    private String displayName;

    private int quantity;

    private String sinceOrTill;

    private int tense;

    private String type;

    private int operator;

}

