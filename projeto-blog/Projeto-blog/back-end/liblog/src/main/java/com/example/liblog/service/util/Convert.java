package com.example.liblog.service.util;

import com.example.liblog.dto.dto_response.DtoPost;
import com.example.liblog.dto.dto_response.DtoUsuario;
import com.example.liblog.models.Post;
import com.example.liblog.models.Usuario;

import java.util.List;
import java.util.stream.Collectors;

public interface Convert {
    default List<DtoPost> listInDtoPost(List<Post> posts){
        return posts
                .stream()
                .map(DtoPost::new)
                .collect(Collectors.toList());
    }
    default DtoPost postInDtoPost(Post post){
        return new DtoPost(post);
    }
    default List<DtoUsuario> listInDtoUsuario(List<Usuario> users){
        return users
                .stream()
                .map(DtoUsuario::new)
                .collect(Collectors.toList());
    }


    default DtoUsuario UsuarioInDtoUsuario(Usuario usuario){
        return new DtoUsuario(usuario);
    }
}
