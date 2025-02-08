package com.newgen.sessions.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;


@Getter
@Setter
@ToString
@Entity
public class ShortUrl {


    @Id
    private String id;
    private String originalUrl;
    private String shortUrl;
    @Temporal(TemporalType.DATE)
    private Date issuedDate;
}
