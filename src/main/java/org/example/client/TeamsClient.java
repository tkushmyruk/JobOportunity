package org.example.client;


import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "teamsClient", url = "${client.post.teamsUrl}")
public interface TeamsClient {

    @PostMapping("/")
    void sendMessageToTeams(@Param String message);
}
