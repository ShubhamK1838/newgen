package com.newgen.sessions.service.impl;


import com.newgen.sessions.entity.ShortUrl;
import com.newgen.sessions.repo.ShortUrlRepository;
import com.newgen.sessions.service.ShortUrlService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShortUrlServiceImpl implements ShortUrlService {

    private final ShortUrlRepository shortUrlRepository;

    public ShortUrlServiceImpl(ShortUrlRepository repository) {
        shortUrlRepository = repository;
    }

    @Override
    public ShortUrl getUrlById(String id) {
        return shortUrlRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Url Not Found "));
    }

    @Override
    public ShortUrl getUrlByShortUrl(String shortUrl) {
        return shortUrlRepository.findByShortUrl(shortUrl).orElseThrow(() -> new RuntimeException("Enter Valid URl"));
    }

    @Override
    public ShortUrl getUrlByOriginalUrl(String originalUrl) {
        return shortUrlRepository.findByOriginalUrl(originalUrl).orElseThrow(() -> new RuntimeException("The Url Is Not Found "));
    }

    @Override
    public boolean deleteUrlByShortUrl(String shortUrl) {
        shortUrlRepository.delete(getUrlByShortUrl(shortUrl));
        return true;
    }

    @Override
    public boolean deleteUrlByOriginalUrl(String originalUrl) {
        shortUrlRepository.delete(getUrlByOriginalUrl(originalUrl));
        return true;
    }

    @Override
    public boolean deleteUrlById(String id) {
        shortUrlRepository.delete(getUrlById(id));
        return true;
    }

    @Override
    public List<ShortUrl> getAllUrls() {
        return shortUrlRepository.findAll();
    }
}
