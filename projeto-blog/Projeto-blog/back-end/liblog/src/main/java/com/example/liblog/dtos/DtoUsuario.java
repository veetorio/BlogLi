package com.example.liblog.dtos;

import com.example.liblog.models.Usuario;
import lombok.Data;

@Data
public class DtoUsuario {
    private String name;
    private String email;

    public DtoUsuario(Usuario user) {
        this.name = user.getNome_usuario();
        this.email = user.getEmail();
    }
}
