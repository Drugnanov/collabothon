package com.commerz.dvadnyvtahu.ai.client.filestore;

import lombok.Data;

@Data
public class ImageUpload {
    String file;
    String expires = "2023-10-20T10:21:44.683Z";
    int maxDownloads = 1;
    boolean autoDelete = true;
}
