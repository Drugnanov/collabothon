package com.commerz.dvadnyvtahu.ai.controller;

import com.commerz.dvadnyvtahu.ai.client.midjourney.Message;
import com.commerz.dvadnyvtahu.ai.domain.Test;
import com.commerz.dvadnyvtahu.ai.service.SomethingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mj")
public class MjController {
    private final SomethingService somethingService;

    public MjController(SomethingService somethingService) {
        this.somethingService = somethingService;
    }

    @GetMapping("/imagine")
    public Message initImagine() {
        return somethingService.testMj();
    }
}