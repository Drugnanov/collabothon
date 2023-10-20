package com.commerz.dvadnyvtahu.ai.client.filestore;

import com.commerz.dvadnyvtahu.ai.client.midjourney.FeignConfig;
import com.commerz.dvadnyvtahu.ai.client.midjourney.ImageRequest;
import com.commerz.dvadnyvtahu.ai.client.midjourney.Message;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

//PAID does not work
//@FeignClient(name = "FileIo", url = "https://file.io", configuration = FeignConfig.class)
public interface FileIo {
    @PostMapping("/")
    ImageUploadResponse uploadImage(ImageUpload request);
}
