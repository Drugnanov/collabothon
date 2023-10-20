package com.commerz.dvadnyvtahu.ai.client.midjourney;

import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "MidJourneyClient", url = "https://api.thenextleg.io/v2", configuration = FeignConfig.class)
@Headers("Authorization: {token}")
public interface MidJourneyClient {
    @GetMapping("/imagine")
    Message executePrompt(@RequestHeader("Authorization") String token, ImageRequest request);

}
