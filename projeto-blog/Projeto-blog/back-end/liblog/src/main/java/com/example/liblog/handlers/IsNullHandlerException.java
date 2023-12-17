package com.example.liblog.handlers;

import com.example.liblog.dto.DtoException.DtoError;
import com.example.liblog.exception.AuthenticateException;
import com.example.liblog.exception.DuplicateException;
import com.example.liblog.exception.ReturnNullException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestControllerAdvice
public class IsNullHandlerException {
    @ResponseBody
    @ExceptionHandler(ReturnNullException.class)
    public ResponseEntity errorIsNull(ReturnNullException error_is_null){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new DtoError(error_is_null.getMessage(),HttpStatus.NOT_FOUND.value()));
    }

    @ResponseBody
    @ExceptionHandler(DuplicateException.class)
    public ResponseEntity errorIsDuplicate(DuplicateException error_duplicate){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new DtoError(error_duplicate.getMessage(),HttpStatus.CONFLICT.value()));
    }

    @ResponseBody
    @ExceptionHandler(AuthenticateException.class)
    public ResponseEntity errorAuthenticate(AuthenticateException error_auth){
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new DtoError(error_auth.getMessage(),HttpStatus.FORBIDDEN.value()));
    }


}