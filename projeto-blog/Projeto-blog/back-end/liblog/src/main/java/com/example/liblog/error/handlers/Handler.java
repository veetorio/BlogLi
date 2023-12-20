package com.example.liblog.error.handlers;

import com.example.liblog.dto.dto_exception.DtoError;
import com.example.liblog.error.exception.AuthenticateException;
import com.example.liblog.error.exception.DuplicateException;
import com.example.liblog.error.exception.ReturnNullException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestControllerAdvice
public class Handler {
    @ResponseBody
    @ExceptionHandler(ReturnNullException.class)
    public ResponseEntity<DtoError> errorIsNull(ReturnNullException error_is_null){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new DtoError(error_is_null.getMessage(),HttpStatus.NOT_FOUND.value()));
    }

    @ResponseBody
    @ExceptionHandler(DuplicateException.class)
    public ResponseEntity<DtoError> errorIsDuplicate(DuplicateException error_duplicate){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new DtoError(error_duplicate.getMessage(),HttpStatus.CONFLICT.value()));
    }

    @ResponseBody
    @ExceptionHandler(AuthenticateException.class)
    public ResponseEntity<DtoError> errorAuthenticate(AuthenticateException error_auth){
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new DtoError(error_auth.getMessage(),HttpStatus.FORBIDDEN.value()));
    }


}