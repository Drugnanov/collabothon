package com.commerz.dvadnyvtahu.ai.client.filestore;

import org.springframework.web.bind.annotation.PostMapping;

//PAID does not work
//@FeignClient(name = "FileIo", url = "https://file.io", configuration = FeignConfig.class)
public interface FileIo {
    @PostMapping("/")
    ImageUploadResponse uploadImage(ImageUpload request);
}
