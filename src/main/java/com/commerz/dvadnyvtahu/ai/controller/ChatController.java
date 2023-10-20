package com.commerz.dvadnyvtahu.ai.controller;

import com.commerz.dvadnyvtahu.ai.client.dto.ChatMessage;
import com.commerz.dvadnyvtahu.ai.client.dto.ChatRequestDto;
import com.commerz.dvadnyvtahu.ai.client.dto.ChatResponseDto;
import com.commerz.dvadnyvtahu.ai.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/chat")
public class ChatController {

    @Autowired
    private ChatService chatService;

    @Value("${openai.model}")
    private String model;

    @GetMapping
    public ChatMessage chat(@RequestParam String prompt) {
        return chatService.prompt(prompt);
    }

    /*
           // create a request
        ChatRequestDto request = new ChatRequestDto(model, prompt);

        // call the API
        ChatResponseDto response = restTemplate.postForObject(apiUrl, request, ChatResponseDto.class);

        if (response == null || response.getChoices() == null || response.getChoices().isEmpty()) {
            return "No response";
        }

        // return the first response
        return response.getChoices().get(0).getMessage().getContent();
     */
}
