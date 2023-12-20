package com.example.liblog.error.exception;

import lombok.Data;


public class ReturnNullException extends RuntimeException {
    public ReturnNullException(String message) {
        super(message);
    }
}
