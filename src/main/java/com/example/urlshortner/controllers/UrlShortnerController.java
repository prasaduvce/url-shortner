package com.example.urlshortner.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UrlShortnerController {

    private static final String BASE_URL_SHORT = "http://shorturl-demo.com/";

    @RequestMapping(method = RequestMethod.POST, value = "/shortUrl")
    public String createShortUrl() {
        return null;
    }
}
