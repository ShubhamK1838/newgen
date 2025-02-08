package com.newgen.sessions.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandler {


    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponse> globalExceptionHandler(Exception exception) {
        return
                ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(new ExceptionResponse(exception));
    }
}
