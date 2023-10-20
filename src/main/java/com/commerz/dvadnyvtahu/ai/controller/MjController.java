package com.commerz.dvadnyvtahu.ai.controller;

import com.commerz.dvadnyvtahu.ai.client.midjourney.ImageRequest;
import com.commerz.dvadnyvtahu.ai.client.midjourney.Response;
import com.commerz.dvadnyvtahu.ai.service.SomethingService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/mj")
public class MjController {
    private final SomethingService somethingService;

    public MjController(SomethingService somethingService) {
        this.somethingService = somethingService;
    }

    @GetMapping("/imagine")
    public Response initImagine() {
        return somethingService.testMj();
    }

    @PostMapping("/imagine")
    public Response withPrompt(@RequestBody ImageRequest ir) {
        return somethingService.callMidJourney(ir);
    }
}