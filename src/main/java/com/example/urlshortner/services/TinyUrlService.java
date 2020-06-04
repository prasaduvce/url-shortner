package com.example.urlshortner.services;

import com.example.urlshortner.dtos.TinyUrlResponse;
import com.example.urlshortner.entities.TinyUrl;
import com.example.urlshortner.repositories.TinyUrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TinyUrlService {

    @Autowired
    private TinyUrlRepository tinyUrlRepository;

    public TinyUrlResponse createTinyUrl(String longUrl) {
        TinyUrl tinyUrl = new TinyUrl();
        tinyUrl.setLongUrl(longUrl);
        TinyUrl savedTinyUrl = tinyUrlRepository.save(tinyUrl);
        String shortUrl = getShortUrl(savedTinyUrl.getId());
        savedTinyUrl.setShortUrl(shortUrl);
        TinyUrl updatedTinyUrl = tinyUrlRepository.save(savedTinyUrl);
        TinyUrlResponse tinyUrlResponse = new TinyUrlResponse();
        tinyUrlResponse.setShortUrl(updatedTinyUrl.getShortUrl());
        tinyUrlResponse.setLongUrl(updatedTinyUrl.getLongUrl());
        return tinyUrlResponse;
    }

    private String getShortUrl(Long id) {
        return "str";
    }
}
