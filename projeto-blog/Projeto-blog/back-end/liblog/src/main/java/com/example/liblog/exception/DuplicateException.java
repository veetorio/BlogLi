package com.example.liblog.exception;

import lombok.Data;

public class DuplicateException extends RuntimeException{
    private String message;

    public DuplicateException(String message) {
        super(message);}
}
