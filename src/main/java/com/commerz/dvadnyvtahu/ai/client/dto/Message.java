package com.commerz.dvadnyvtahu.ai.client.dto;

// add Lombok annotations
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Message {
    private String role;
    private String content;
}