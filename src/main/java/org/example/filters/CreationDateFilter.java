package org.example.filters;

import org.example.dto.position.PositionDTO;
import org.example.dto.position.ResponseDTO;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


public class CreationDateFilter {
    public static List<PositionDTO> filterPositionByTime(ResponseDTO responseDto) {
        if (responseDto != null) {
            List<PositionDTO> filteredPosition = responseDto.getPositions().stream()
                    .filter(position -> System.currentTimeMillis() - position.getCreationDate() < 600000)
                    .collect(Collectors.toList());
            return filteredPosition;
        }
        return Collections.emptyList();
    }

}
