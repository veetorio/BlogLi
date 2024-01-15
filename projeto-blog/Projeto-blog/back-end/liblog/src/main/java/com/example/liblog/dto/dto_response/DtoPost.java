package com.example.liblog.dto.dto_response;

import com.example.liblog.models.Post;

import java.time.LocalDate;


public record DtoPost(String title, String comentario, String url, String data, String hoursdate,String IdN) {
    public DtoPost(Post post){
        this(
                post.dismantle(post.getNome()),
                post.getComentario(),
                post.getUrl(), post.getData(),
                post.getHoursdate(),
                post.dismantleIdN(post.getNome()));
    }
}