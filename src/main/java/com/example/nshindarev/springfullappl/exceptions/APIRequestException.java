package com.example.nshindarev.springfullappl.exceptions;

// what we are going to throw
public class APIRequestException extends RuntimeException{
    public APIRequestException(String message) {
        super(message);
    }

    public APIRequestException(String message, Throwable cause) {
        super(message, cause);
    }
}
