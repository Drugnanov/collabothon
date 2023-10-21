package com.commerz.dvadnyvtahu.ai.client.gcs;


import com.commerz.dvadnyvtahu.ai.configuration.FeignSupportConfig;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;


@FeignClient(name = "GoogleCloudServicesClient", url = "https://storage.googleapis.com/",
        configuration = FeignSupportConfig.class)
@Headers("Authorization: {token}")
public interface GoogleCloudServicesClient {
    @PostMapping(value= "/upload/storage/v1/b/collabothon-dvadnyvtahu/o?uploadType=media&name={fileName}", consumes = MediaType.IMAGE_JPEG_VALUE)
    @Headers("Content-Type: image/jpeg")
    String uploadImage(@RequestHeader("Authorization") String token, @PathVariable String fileName, @RequestBody File file);

    @PutMapping(value = "/storage/v1/b/collabothon-dvadnyvtahu/iam", consumes = MediaType.APPLICATION_JSON_VALUE)
    String setPublicAccess(@RequestHeader("Authorization") String token, @RequestBody String body);

}
