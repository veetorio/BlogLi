package com.example.liblog.dto.dto_response;

import com.example.liblog.models.Post;

import java.time.LocalDate;


public record DtoPost(String title, String comentario, String url, String data, String hoursdate,String IdN) {
    public DtoPost(Post post){
        this(
                post.getNome()
                        .replaceAll("-"," ")
                        .substring(0,post.getNome().length() - 5),
                post.getComentario(),
                post.getUrl(), post.getData(),
                post.getHoursdate(),
                post.getNome().substring(post.getNome().length() - 5));
    }
}
