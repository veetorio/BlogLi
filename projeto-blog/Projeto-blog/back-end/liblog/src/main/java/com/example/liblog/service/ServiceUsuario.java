package com.example.liblog.service;

import com.example.liblog.dto.DtoUsuario;
import com.example.liblog.models.Usuario;
import com.example.liblog.repository.RepositoryUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceUsuario {
    @Autowired
    RepositoryUsuario repositoryUsuario;

    public List<DtoUsuario> findAll(){
        List<Usuario> user = repositoryUsuario.findAll();
        List<DtoUsuario> userDto = user.stream().map(DtoUsuario::new).toList();
        return userDto;
    }

    public DtoUsuario findByNameOrUsuario(String name){
        Usuario user = repositoryUsuario.findByNameOrEmail(name);
        return new DtoUsuario(user);
    }


}
