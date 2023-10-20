package com.commerz.dvadnyvtahu.ai.controller;

import com.commerz.dvadnyvtahu.ai.client.midjourney.ImageRequest;
import com.commerz.dvadnyvtahu.ai.client.midjourney.Response;
import com.commerz.dvadnyvtahu.ai.service.SomethingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/mj")
public class MjController {
    private final SomethingService somethingService;

    public MjController(SomethingService somethingService) {
        this.somethingService = somethingService;
    }

    @GetMapping("/imagine/{what}")
    public Response initImagine(@PathVariable String what) {
        return somethingService.testMj(what);
    }

    @PostMapping("/imagine")
    public Response withPrompt(@RequestBody ImageRequest ir) {
        return somethingService.callMidJourney(ir);
    }
}