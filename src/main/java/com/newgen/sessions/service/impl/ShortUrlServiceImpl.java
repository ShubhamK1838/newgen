package com.newgen.sessions.service.impl;


import com.newgen.sessions.entity.ShortUrl;
import com.newgen.sessions.repo.ShortUrlRepository;
import com.newgen.sessions.service.ShortUrlService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class ShortUrlServiceImpl implements ShortUrlService {

    private final ShortUrlRepository shortUrlRepository;

    public ShortUrlServiceImpl(ShortUrlRepository repository) {
        shortUrlRepository = repository;
    }

    @Override
    public ShortUrl saveShortUrl(ShortUrl shortUrl) {
        shortUrl.setIssuedDate(new Date());
        return shortUrlRepository.save(shortUrl);
    }

    @Override
    public ShortUrl getUrlById(String id) {
        return shortUrlRepository.findById(id)
                .orElse(null);
    }

    @Override
    public ShortUrl getUrlByShortUrl(String shortUrl) {
        return shortUrlRepository.findByShortUrl(shortUrl).orElse(null);
    }

    @Override
    public ShortUrl getUrlByOriginalUrl(String originalUrl) {
        return shortUrlRepository.findByOriginalUrl(originalUrl).orElse(null);
    }

    @Override
    public boolean deleteUrlByShortUrl(String shortUrl) {
        var entity = getUrlByShortUrl(shortUrl);
        if (entity != null) {
            shortUrlRepository.delete(entity);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteUrlByOriginalUrl(String originalUrl) {
        var entity = getUrlByOriginalUrl(originalUrl);
        if (entity != null) {
            shortUrlRepository.delete(entity);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteUrlById(String id) {
        var entity = getUrlById(id);
        if (entity != null) {
            shortUrlRepository.delete(entity);
            return true;
        }
        return false;
    }

    @Override
    public List<ShortUrl> getAllUrls() {
        return shortUrlRepository.findAll();
    }
}
