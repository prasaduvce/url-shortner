package com.example.urlshortner.dtos;

import lombok.Data;

@Data
public class TinyUrlResponse {
    private String longUrl;
    private String shortUrl;
}
