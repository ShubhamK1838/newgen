package com.newgen.sessions.exception;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class ExceptionResponse extends RuntimeException {

    private String message;
    private Date timeStamp;

    public ExceptionResponse(Exception exception) {
        this.message = exception.getMessage();
        this.timeStamp = new Date();
    }

}
