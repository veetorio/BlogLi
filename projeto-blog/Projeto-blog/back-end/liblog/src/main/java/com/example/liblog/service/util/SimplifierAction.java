package com.example.liblog.service.util;

import com.example.liblog.error.exception.NotExistUserException;
import com.example.liblog.models.Post;
import com.example.liblog.models.Usuario;

import javax.lang.model.element.Element;
import java.util.Random;

public interface SimplifierAction extends Convert {
    default Object setterUpdate(Object updates,Object objectafter){
        switch (updates.getClass().getSimpleName()) {
            case "Usuario":
                Usuario element = (Usuario) updates;// user com atualizações
                Usuario UserAfter = (Usuario) objectafter;// user para atualizar

                UserAfter.setNome_usuario(element.getNome_usuario());
                UserAfter.setSenha_usuario(element.getSenha_usuario());
                UserAfter.setEmail(element.getEmail());

                return UserAfter;
            case "Post":
                Post post = (Post) updates;// post com atualizações
                Post postAfter = (Post) objectafter;// post para atualizar
                
                postAfter.setNome(post.getNome());
                postAfter.setUrl(post.getUrl());
                postAfter.setComentario(post.getComentario());

                return postAfter;
            default:
                return new NotExistUserException("Este tipo de dado não é suportado");
        }
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
}
