package com.commerz.dvadnyvtahu.ai.controller;

import com.commerz.dvadnyvtahu.ai.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@RestController
@RequestMapping("/api/image")
public class ImageController {

    @Autowired
    private ImageService imageService;


    @PostMapping(value = "/upload", consumes = MediaType.IMAGE_JPEG_VALUE)
    public String uploadImage(@RequestPart(value = "file") MultipartFile file) {

        String resultLink = imageService.uploadImage(file);

        return resultLink;
    }
}
