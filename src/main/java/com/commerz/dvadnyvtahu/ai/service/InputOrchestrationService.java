package com.commerz.dvadnyvtahu.ai.service;

import com.commerz.dvadnyvtahu.ai.domain.UserData;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class InputOrchestrationService {

    @Autowired
    private UserDataService userDataService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private PromptOrchestrationService promptOrchestrationService;

    public void processInput(String photoUrl, String userId) {
        if (StringUtils.isBlank(photoUrl) || StringUtils.isBlank(userId)) {
            throw new IllegalArgumentException("Mandatory parameters are empty or null");
        }
        UserData userData = fetchUserData(userId);
        String categoryPrompt = fetchCategoryPrompt();

        String promptToProcess = String.format("%s in %s", userData, categoryPrompt);
        promptOrchestrationService.generateImage(photoUrl, userData.getGender(), promptToProcess);
    }

    private String fetchCategoryPrompt() {
        return categoryService.fetchCategoryPrompt();
    }

    private UserData fetchUserData(String userId) {
        return userDataService.getUserDataForId(userId);
    }
}
