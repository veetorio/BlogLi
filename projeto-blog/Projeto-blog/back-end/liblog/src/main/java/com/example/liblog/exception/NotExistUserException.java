package com.example.liblog.exception;

public class NotExistUserException extends RuntimeException{
    public NotExistUserException(String message) {
        super(message);
    }
}
