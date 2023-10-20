package com.commerz.dvadnyvtahu.ai.service;

import com.commerz.dvadnyvtahu.ai.client.chatgpt.ChatGptClient;
import com.commerz.dvadnyvtahu.ai.client.gcs.GoogleCloudServicesClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Service
public class ImageService {
    private Logger logger = LoggerFactory.getLogger(ImageService.class);

    @Autowired
    private GoogleCloudServicesClient googleCloudServicesClient;

    @Value("${google.cloud.storage.token}")
    private String token;

    private String getToken() {
        return "Bearer " + token;
    }

    public void uploadImage(MultipartFile file, String fileName) {

        logger.info("Uploading image");

        googleCloudServicesClient.uploadImage(getToken(), fileName, file);

        // set all the images in the bucket to be public
        logger.info("Setting public access");
        googleCloudServicesClient.setPublicAccess(getToken(), "{\"bindings\":[{\"role\":\"roles/storage.objectViewer\",\"members\":[\"allUsers\"]}]}");

        logger.info("https://storage.googleapis.com/collabothon-dvadnyvtahu/" + fileName);

        logger.info("Uploading image completed");

    }
}
