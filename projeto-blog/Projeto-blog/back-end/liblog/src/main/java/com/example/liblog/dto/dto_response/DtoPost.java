package com.example.liblog.dto.dto_response;

import com.example.liblog.models.Post;

import java.time.LocalDate;


public record DtoPost(String title, String comentario, String pathIcon,String pathBanner ,String data, String hoursdate) {
    public DtoPost(Post post){
        this(
                post.getNome() + post.getId(),
                post.getComentario(),
                post.getUrl(),
                post.getPathBanner(),
                post.getData(),
                post.getHoursdate());

    }
}