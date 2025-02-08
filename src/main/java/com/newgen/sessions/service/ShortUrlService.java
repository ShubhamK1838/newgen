package com.newgen.sessions.service;

import com.newgen.sessions.entity.ShortUrl;

import java.util.List;

public interface ShortUrlService {

    ShortUrl getUrlById(String id);

    ShortUrl getUrlByShortUrl(String shortUrl);

    ShortUrl getUrlByOriginalUrl(String originalUrl);

    boolean deleteUrlByShortUrl(String shortUrl);

    boolean deleteUrlByOriginalUrl(String originalUrl);

    boolean deleteUrlById(String id);

    List<ShortUrl> getAllUrls();
    
}
