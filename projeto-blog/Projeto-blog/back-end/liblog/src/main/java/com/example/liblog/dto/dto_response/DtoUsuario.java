package com.example.liblog.dto.dto_response;

import com.example.liblog.models.Post;
import com.example.liblog.models.Usuario;
import com.example.liblog.service.util.Convert;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public record DtoUsuario(String name,String email,List<DtoPost> mypost,Boolean auth){

    public DtoUsuario(Usuario usuario){
        this(usuario.getNome_usuario(), usuario.getEmail(),usuario.listInDtoPost(usuario.getListPosts()),true);
    }
}