package com.commerz.dvadnyvtahu.ai.service;

import com.commerz.dvadnyvtahu.ai.client.chatgpt.ChatGptClient;
import com.commerz.dvadnyvtahu.ai.client.gcs.GoogleCloudServicesClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class ImageService {
    private Logger logger = LoggerFactory.getLogger(ImageService.class);

    @Autowired
    private GoogleCloudServicesClient googleCloudServicesClient;

    @Value("${google.cloud.storage.token}")
    private String token;

    public void uploadImage(File file) {

        googleCloudServicesClient.uploadImage(token, file);

        logger.info("Uploading image");

    }
}
