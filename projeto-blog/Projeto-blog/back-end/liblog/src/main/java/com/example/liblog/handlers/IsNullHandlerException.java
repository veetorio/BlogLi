package com.example.liblog.handlers;

import com.example.liblog.exception.RetornoNuloException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestControllerAdvice
public class IsNullHandlerException {
    @ExceptionHandler(RetornoNuloException.class)
    @ResponseBody
    public ResponseEntity errorIsNull(RetornoNuloException error){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error.getMessage());
    }
}
