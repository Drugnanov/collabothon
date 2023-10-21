package com.commerz.dvadnyvtahu.ai.controller;

import com.commerz.dvadnyvtahu.ai.client.midjourney.ImageRequest;
import com.commerz.dvadnyvtahu.ai.service.ImageService;
import com.commerz.dvadnyvtahu.ai.service.MidJourneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;


@RestController
@RequestMapping("/api/version1")
public class Version1Controller {

    @Autowired
    private ImageService imageService;

    @Autowired
    private MidJourneyService midJourneyService;

    @PostMapping(value = "/photo", consumes = MediaType.IMAGE_JPEG_VALUE)
    public String createPhoto(@RequestPart(value = "file") MultipartFile file,
                              @RequestParam("destination") String destination, @RequestParam("hobby") String hobby) {

        String fileName = "last.jpg";
        String photoLink = imageService.uploadImage(file);

        ImageRequest imageRequest = new ImageRequest();
        imageRequest.setMsg(photoLink + " on vacation at " + destination + " doing " + hobby);
        String mjPhotoLink = midJourneyService.callMidJourney(imageRequest).getImageUrl();

        return mjPhotoLink;
    }
}
