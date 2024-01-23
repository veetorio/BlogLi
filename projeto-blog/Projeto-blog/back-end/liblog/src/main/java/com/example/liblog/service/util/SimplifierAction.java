package com.example.liblog.service.util;

import com.example.liblog.error.exception.NotExistUserException;
import com.example.liblog.models.Post;
import com.example.liblog.models.Usuario;

import javax.lang.model.element.Element;
import java.sql.Date;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public interface SimplifierAction extends Convert {
    default Object setterUpdate(Object updates,Object objectafter) {
        if (updates instanceof Usuario updatesUser) {
            Usuario userAfter = (Usuario) objectafter;
            userAfter.setNome_usuario(updatesUser.getNome_usuario());
            userAfter.setEmail(updatesUser.getEmail());

            return userAfter;
        } else if (updates instanceof Post updatesPost) {
            Post postAfter = (Post) objectafter;
            postAfter.setNome(updatesPost.getNome());
            postAfter.setUrl(updatesPost.getUrl());
            postAfter.setPathBanner(updatesPost.getPathBanner());

            return postAfter;
        }
        return (NotExistUserException) new NotExistUserException("tipo não existe");
    }
    default String dismantleIdN(String value){
        return  value
                .replaceAll("-"," ")
                .substring( value.length()- 5);
    }
    default String dismantle(String value){
        return value
                .replaceAll("-"," ")
                .substring(0,value.length() - 6);
    }
    default StringBuilder GeneratedKey(){
        Random rand = new Random();
        String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789$#*?!";

        StringBuilder token = new StringBuilder();
        for (int i = 0;i < 10;i++){
            int position = rand.nextInt(token.length() + 1);
            char letter = alpha.charAt(rand.nextInt(alpha.length()));
            token.insert(position,letter);
        }
        return token;
    }

    default String  setTiming(){
        LocalTime localTime = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        return localTime.format(formatter);
    }
    default String setDate(){
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy-MM-dd");
        return localDateTime.format(formatter);
    }
}
