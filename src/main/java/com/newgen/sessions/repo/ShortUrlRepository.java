package com.newgen.sessions.repo;

import com.newgen.sessions.entity.ShortUrl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShortUrlRepository  extends JpaRepository<ShortUrl,String> {

    Optional<ShortUrl> findByShortUrl(String shortUrl);
    Optional<ShortUrl> findByOriginalUrl(String originalUrl); 

}
