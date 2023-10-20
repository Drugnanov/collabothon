package com.commerz.dvadnyvtahu.ai.controller;

import com.commerz.dvadnyvtahu.ai.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@RestController
@RequestMapping("/api/image")
public class ImageController {

    @Autowired
    private ImageService imageService;


    @PostMapping("/upload")
    public String uploadImage(@RequestParam("imageFile") File file) {

        imageService.uploadImage(file);

        return "Image uploaded";
    }
}
