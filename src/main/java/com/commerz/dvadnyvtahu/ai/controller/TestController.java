package com.commerz.dvadnyvtahu.ai.controller;

import com.commerz.dvadnyvtahu.ai.domain.Test;
import com.commerz.dvadnyvtahu.ai.service.SomethingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TestController {
    private final SomethingService somethingService;

    public TestController(SomethingService somethingService) {
        this.somethingService = somethingService;
    }

    @GetMapping("/test")
    public List<Test> getAllTests() {
        return somethingService.findAll();
    }

    @PostMapping("/tests")
    public Test createTutorial(@RequestBody Test test) {
        return somethingService.save(test);
    }
}