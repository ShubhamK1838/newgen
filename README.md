# Sessions - URL Shortening Service

## Overview
The **Sessions** project is a demo application built with **Spring Boot** that implements a URL shortening service. This application allows users to shorten long URLs and retrieve the original URLs using the generated short links.

## Features
- Shorten long URLs and retrieve the original URLs.
- List all shortened URLs.
- Handle exceptions with a global exception handler.

## Technologies Used
- **Java**: 21
- **Spring Boot**: 3.4.2
- **Spring Data JPA**: For database interactions.
- **MySQL**: Database for storing URLs.
- **Lombok**: To reduce boilerplate code.
- **JUnit**: For testing the application.

## Project Structure
sessions
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── newgen
│   │   │           └── sessions
│   │   │               ├── SessionsApplication.java
│   │   │               ├── controller
│   │   │               │   └── UrlController.java
│   │   │               ├── entity
│   │   │               │   └── ShortUrl.java
│   │   │               ├── exception
│   │   │               │   ├── ExceptionHandler.java
│   │   │               │   └── ExceptionResponse.java
│   │   │               ├── repo
│   │   │               │   └── ShortUrlRepository.java
│   │   │               └── service
│   │   │                   ├── ShortUrlService.java
│   │   │                   └── impl
│   │   │                       └── ShortUrlServiceImpl.java
│   │   └── resources
│   │       └── application.properties
│   └── test
│       └── java
│           └── com
│               └── newgen
│                   └── sessions
│                       └── SessionsApplicationTests.java
└── pom.xml
