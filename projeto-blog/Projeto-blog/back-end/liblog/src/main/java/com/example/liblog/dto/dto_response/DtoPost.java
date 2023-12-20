package com.example.liblog.dto.dto_response;

import com.example.liblog.models.Post;

import java.time.LocalDate;


public record DtoPost(String title, String comentario, String url, LocalDate data, String hoursdate) {
    public DtoPost(Post post){
        this(post.getNome(), post.getComentario(), post.getUrl(), post.getData(), post.getHoursdate());
    }
}
