package com.example.liblog.dto;

import com.example.liblog.models.Usuario;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class DtoUsuario {
    private String name;
    private String email;
    private List<DtoPostagem> listPostdto;

    public DtoUsuario(Usuario user) {
        this.name = user.getNome_usuario();
        this.email = user.getEmail();
        this.listPostdto = user.getListPosts().stream().map(DtoPostagem::new).toList();
    }





}