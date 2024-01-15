package com.example.liblog.error.exception;





public class NotExistUserException extends RuntimeException  {
    public NotExistUserException(String message) {
        super(message);
    }

    public static void NotNullObject(Object object){
        if(object == null){
            throw new NotExistUserException("Usuário não encontrado");
        }
    }


}
