package com.commerz.dvadnyvtahu.ai.service;

import com.commerz.dvadnyvtahu.ai.client.dto.ChatMessage;
import com.commerz.dvadnyvtahu.ai.repository.CategoryRepository;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ChatService chatService;

    public String fetchCategoryPrompt() {
        String instruction = categoryRepository.getCategoryPrompt();

        ChatMessage chatGptResponse = chatService.prompt(instruction);
        String content = chatGptResponse.getContent();

        if (StringUtils.isNotBlank(content)) {
            String[] parts = content.split("'");
            return parts[0];
//            int randomNum = ThreadLocalRandom.current().nextInt(1, 6);
//            return parts[randomNum];
        }

        return null;
    }
}
