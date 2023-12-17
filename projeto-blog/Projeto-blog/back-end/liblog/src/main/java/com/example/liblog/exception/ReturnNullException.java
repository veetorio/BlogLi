package com.example.liblog.exception;

import lombok.Data;


public class ReturnNullException extends RuntimeException {
    public ReturnNullException(String message) {
        super(message);
    }
}
