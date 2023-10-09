package org.example.client;

import feign.Param;
import org.example.dto.search.RequestDto;
import org.example.dto.search.SearchDto;
import org.example.dto.search.SearchHalfDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "postFiegnClient", url = "${client.post.baseUrl}")
public interface PostFeignClient {
    @GetMapping(value = "/", consumes = "application/json")
    SearchDto getSearchDto(@RequestHeader("Cookie") String cookie);

    @PostMapping("/")
    SearchHalfDto postSearchDto(@RequestHeader("Cookie") String cookie, @Param RequestDto requestDto);

}
