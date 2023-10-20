package com.commerz.dvadnyvtahu.ai.client.gcs;


import com.commerz.dvadnyvtahu.ai.client.filestore.ImageUpload;
import com.commerz.dvadnyvtahu.ai.client.filestore.ImageUploadResponse;
import com.commerz.dvadnyvtahu.ai.client.midjourney.FeignConfig;
import com.commerz.dvadnyvtahu.ai.client.midjourney.ImageRequest;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import java.io.File;

@FeignClient(name = "Google Cloud Services Client", url = "https://storage.googleapis.com/upload/storage/v1/b/", configuration = FeignConfig.class)
@Headers("Authorization: {token}")
public interface GoogleCloudServicesClient {
    @PostMapping("/upload")
    ImageUploadResponse uploadImage(@RequestHeader("Authorization") String token, File file);
}
