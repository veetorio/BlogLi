package com.example.liblog.service;

import com.example.liblog.dto.DtoUsuario;
import com.example.liblog.exception.AuthenticateException;
import com.example.liblog.models.Usuario;
import com.example.liblog.repository.RepositoryUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
    public DtoUsuario create(Usuario user){
        authValueExist(user);
        repositoryUsuario.save(user);
        return new DtoUsuario(user);
    }
    public DtoUsuario update(Usuario userBefore){
        Usuario userAfter = repositoryUsuario.findById(userBefore.getId()).orElseThrow();
        userAfter.setNome_usuario(userBefore.getNome_usuario());
        userAfter.setEmail(userBefore.getEmail());
        userAfter.setSenha_usuario(userBefore.getSenha_usuario());

        repositoryUsuario.save(userAfter);

        return new DtoUsuario(userAfter);
    }

    public String delete(Long id){
        Usuario user = repositoryUsuario.findById(id).orElseThrow();
        repositoryUsuario.delete(user);
        return "usuario removido com sucesso !";
    }
    public Usuario PostAuth(Usuario user){
        Usuario usuario = repositoryUsuario.findByNameOrEmail(user.getNome_usuario());
        if(usuario == null || usuario.getSenha_usuario() == usuario.getSenha_usuario()){
            throw new AuthenticateException("Este usuario não existe");
        }
        return null;
    }

    private void authValueExist(Usuario person){
        List<Usuario> users = repositoryUsuario.findAll().stream().toList();

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
