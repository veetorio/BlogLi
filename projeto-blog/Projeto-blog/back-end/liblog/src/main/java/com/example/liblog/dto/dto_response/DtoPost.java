package com.example.liblog.dto.dto_response;

import com.example.liblog.models.Post;

import java.time.LocalDate;
import java.time.LocalTime;


public record DtoPost(Long id,String title, String comentario, String pathIcon, String pathBanner , String data, String hoursdate,String DonoPost,String urlIcon,String type) {
    public DtoPost(Post post){
        this(
                post.getId(),
                post.getNome(),
                post.getComentario(),
                post.getUrl(),
                post.getPathBanner(),
                post.getData(),
                post.getHoursdate(),
                post.getUser().getNome_usuario(),
                post.getUser().getPath_profile(),
                post.getType()
        );

    }
}