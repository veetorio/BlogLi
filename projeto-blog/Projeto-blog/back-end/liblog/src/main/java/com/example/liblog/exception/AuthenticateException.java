package com.example.liblog.exception;

import lombok.Data;


public class AuthenticateException extends RuntimeException{
    public AuthenticateException(String message) {
        super(message);
    }
}
