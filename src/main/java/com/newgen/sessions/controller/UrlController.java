package com.newgen.sessions.controller;


import com.newgen.sessions.entity.ShortUrl;
import com.newgen.sessions.service.ShortUrlService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.List;

@RestController
@RequestMapping("/url")
public class UrlController {

    @Autowired
    private ShortUrlService urlService;
    private final static String BASEURL = "http://localhost:8080/url/";

    @PostMapping("/short-url")
    public ResponseEntity<?> shortUrl(@RequestParam String url) {
        ShortUrl urlEntity = urlService.getUrlByOriginalUrl(url);
        if (urlEntity != null) {
            return ResponseEntity.ok().body(urlEntity.getShortUrl());
        } else {
            String shortUrl = generateShortUrl(url);
            ShortUrl entity = new ShortUrl();
            entity.setShortUrl(BASEURL + shortUrl);
            entity.setId(shortUrl);
            entity.setOriginalUrl(url);
            entity = urlService.saveShortUrl(entity);
            return ResponseEntity.ok().body(entity.getShortUrl());
        }
    }

    @GetMapping("/{id}/long-url")
    public ResponseEntity<String> extractUrl(@PathVariable String id) {
        ShortUrl urlEntity = urlService.getUrlById(id);
        if (urlEntity != null) {
            return ResponseEntity.ok().body(urlEntity.getOriginalUrl());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/{hashCode}")
    public String redirectUrl(@PathVariable String hashCode, HttpServletResponse res) throws IOException {
        ShortUrl urlEntity = urlService.getUrlById(hashCode);
        if (urlEntity != null) {
            res.sendRedirect(urlEntity.getOriginalUrl());
        }
        return "<h1>Invalid URL</h1>";
    }

    @GetMapping("/list")
    public List<ShortUrl> getAllUrls() {
        return urlService.getAllUrls();
    }

    private static String generateShortUrl(String longUrl) {
        String ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        int SHORT_URL_LENGTH = 7;
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(longUrl.getBytes(StandardCharsets.UTF_8));
            String base64Hash = Base64.getUrlEncoder().encodeToString(hash);
            return base64Hash.substring(0, SHORT_URL_LENGTH);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();

            return null;
        }
    }
}




