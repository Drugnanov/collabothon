package com.commerz.dvadnyvtahu.ai.client.filestore;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ImageUploadResponse {
    boolean success;
    int status;
    String id;
    String key;
    String name;
    String link;
}
