package com.example.liblog.dto.dto_response;

import com.example.liblog.models.Usuario;
import lombok.Data;

import java.util.List;

public record DtoUsuario(String name,String email,List<DtoPost> mypost) {
    public DtoUsuario(Usuario usuario){
        this(usuario.getNome_usuario(), usuario.getEmail(), usuario.convert(usuario.getListPosts()));

    }

}