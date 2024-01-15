package com.example.liblog.service;

import com.example.liblog.dto.dto_response.DtoUsuario;
import com.example.liblog.dto.dto_response.Response;
import com.example.liblog.dto.so.SoUser;
import com.example.liblog.error.exception.NotExistUserException;
import com.example.liblog.models.Usuario;
import com.example.liblog.repository.RepositoryUsuario;
import com.example.liblog.service.util.SimplifierAction;
import com.example.liblog.service.util.Validates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ServiceUsuario implements Validates,SimplifierAction {
    @Autowired
    RepositoryUsuario repositoryUsuario;

    public List<DtoUsuario> findAll(){
        List<Usuario> user = repositoryUsuario.findAll();
        return listInDtoUsuario(user);
    }
    public List findByNameOrUsuario(String name){
        List user = repositoryUsuario.findByContentValue(name);
        Exist(user);
        return listInDtoUsuario(user);
    }
    public DtoUsuario create(Usuario user){
        ExistIntoTable(repositoryUsuario,user);// verifica se ele já existe
        repositoryUsuario.save(user);// guardar o user no banco de dados
        return UsuarioInDtoUsuario(user);
    }
    public DtoUsuario update(Usuario userBefore){
        Usuario userAfter = repositoryUsuario.findById(userBefore.getId()).orElseThrow(() -> new NotExistUserException("usuario não existe"));
        Usuario user = (Usuario) setterUpdate(userBefore,userAfter);
        repositoryUsuario.save(user);
        return UsuarioInDtoUsuario(user);
    }
    public Response delete(Long id){
        Usuario user = repositoryUsuario.findById(id).orElseThrow(() -> new NotExistUserException("Usuario não encontrado"));
        repositoryUsuario.delete(user);
        return new Response("Usuario removido");
    }
    public DtoUsuario PostAuth(SoUser soUser)  {
        Usuario usuario = repositoryUsuario.findByNameOrEmail(soUser.getDataSearchName());
        Exist(usuario);
        Auth(usuario,soUser);
        return new DtoUsuario(usuario);
    }
}
