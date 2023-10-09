package org.example.client;


import org.example.dto.staffing.StaffingResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "staffingFeignClient", url = "${client.post.staffingUrl}")
public interface StaffingClient {
    @GetMapping("/{id}?fetchTask=true")
    StaffingResponse getEnglishLevel(@RequestHeader("Cookie") String cookie, @PathVariable("id") String id);

}
