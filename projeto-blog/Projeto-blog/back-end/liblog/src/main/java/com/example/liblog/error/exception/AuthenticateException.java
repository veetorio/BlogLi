package com.example.liblog.error.exception;

import com.example.liblog.dto.so.SoUser;
import com.example.liblog.models.Usuario;
import lombok.Data;


public class AuthenticateException extends RuntimeException{
    public AuthenticateException(String message) {
        super(message);
    }

    public static void ValidateUser(Usuario object, SoUser objectSo){
        if (!object.getSenha_usuario().equals(objectSo.getDataSearchPassword())){
             throw new AuthenticateException("Este usuario não foi autenticado");
        }
    }
}
