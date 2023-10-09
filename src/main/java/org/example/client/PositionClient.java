package org.example.client;

import feign.Param;
import org.example.dto.position.PositionDTO;
import org.example.dto.position.ResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

@FeignClient(name = "postFiegn", url = "${client.post.anotherUrl}")
public interface PositionClient {

    @PostMapping(value = "/", consumes = "application/json", produces = "application/json")
    ResponseDTO getPositions(@RequestHeader("Cookie") String cookie, @Param String searchDto);

}
