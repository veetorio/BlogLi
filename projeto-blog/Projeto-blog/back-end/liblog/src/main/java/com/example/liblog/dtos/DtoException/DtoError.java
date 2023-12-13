package com.example.liblog.dtos.DtoException;

import lombok.Data;

@Data
public class DtoError {
    private int status;
    private String message;

    public DtoError(String message, int status) {
        this.status = status;
        this.message = message;
    }
}
