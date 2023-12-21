package com.example.liblog.service;

import com.example.liblog.dto.dto_response.DtoUsuario;
import com.example.liblog.error.exception.AuthenticateException;
import com.example.liblog.error.exception.ReturnNullException;
import com.example.liblog.models.Usuario;
import com.example.liblog.repository.RepositoryUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceUsuario {
    @Autowired
    RepositoryUsuario repositoryUsuario;

    public List<DtoUsuario> findAll(){
        List<Usuario> user = repositoryUsuario.findAll();
        List<DtoUsuario> dtouser = user.stream().map(DtoUsuario::new).toList();
        return dtouser;
    }

    public DtoUsuario findByNameOrUsuario(String name){
        Optional<Usuario> user = repositoryUsuario.findByNameOrEmail(name);
        DtoUsuario userDto = new DtoUsuario(user.get());
        return userDto;
    }
    public DtoUsuario create(Usuario user){
        authValueExist(user);
        repositoryUsuario.save(user);
        DtoUsuario userDto = new DtoUsuario(user);
        return userDto;
    }
    public DtoUsuario update(Usuario userBefore){
        Usuario userAfter = repositoryUsuario.findById(userBefore.getId()).orElseThrow();
        userAfter.setNome_usuario(userBefore.getNome_usuario());
        userAfter.setEmail(userBefore.getEmail());
        userAfter.setSenha_usuario(userBefore.getSenha_usuario());

        repositoryUsuario.save(userAfter);
        DtoUsuario userDto = new DtoUsuario(userAfter);

        return userDto;
    }

    public String delete(Long id){
        Usuario user = repositoryUsuario
                .findById(id)
                .orElseThrow();
        repositoryUsuario.delete(user);
        return "usuario removido com sucesso !";
    }
    public Usuario PostAuth(Usuario user)  {
        Usuario usuario = repositoryUsuario.findByNameOrEmail(user.getNome_usuario()).orElseThrow( () ->  new AuthenticateException("Este usuario não existe"));

        if(!usuario.getSenha_usuario().equals(user.getSenha_usuario())){throw new AuthenticateException("senha não correspondente");}

        return user;
    }


    private void authValueExist(Usuario person){
        List<Usuario> users = repositoryUsuario
                .findAll()
                .stream()
                .toList();

        users.forEach( usuario -> {
        // verificar se o usuario já não existe
            boolean inUseName = usuario.getNome_usuario().equals(person.getNome_usuario());
        // verificar se o email já existe
            boolean inUseEmail = usuario.getEmail().equals(person.getEmail());
            if (inUseName){
                throw new AuthenticateException("não é possivel de dar proseguimento,pois o nome já está em uso");
            } else if (inUseEmail) {
                throw new AuthenticateException("não é possivel dar proseguimento");

            }
                }
        );
    }






}
