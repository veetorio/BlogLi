package com.example.liblog.error.exception;

import lombok.Data;

public class DuplicateException extends RuntimeException{
    public DuplicateException(String message) {
        super(message);}
}
