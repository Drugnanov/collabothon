package com.commerz.dvadnyvtahu.ai.client.gcs;


import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;


@FeignClient(name = "GoogleCloudServicesClient", url = "https://storage.googleapis.com/upload/storage/v1/b/collabothon-dvadnyvtahu",
        configuration = FeignSupportConfig.class)
@Headers("Authorization: {token}")
public interface GoogleCloudServicesClient {
    @PostMapping(value= "/o?uploadType=media&name={fileName}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    String uploadImage(@RequestHeader("Authorization") String token, @PathVariable String fileName, @RequestPart(value = "file") MultipartFile file);

}
