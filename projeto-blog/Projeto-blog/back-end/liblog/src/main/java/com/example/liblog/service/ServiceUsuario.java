package com.example.liblog.service;

import com.example.liblog.dto.dto_response.DtoUsuario;
import com.example.liblog.error.exception.AuthenticateException;
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
        List<DtoUsuario> userDto = user.stream().map(user_us -> new DtoUsuario(user_us.getNome_usuario(),user_us.getEmail(),user_us.getListPosts())).toList();
        return userDto;
    }

    public DtoUsuario findByNameOrUsuario(String name){
        Usuario user = repositoryUsuario.findByNameOrEmail(name);
        DtoUsuario userDto = new DtoUsuario(user.getNome_usuario(), user.getEmail(), user.getListPosts());
        return userDto;
    }
    public DtoUsuario create(Usuario user){
        authValueExist(user);
        repositoryUsuario.save(user);
        DtoUsuario userDto = new DtoUsuario(user.getNome_usuario(), user.getEmail(), user.getListPosts());
        return userDto;
    }
    public DtoUsuario update(Usuario userBefore){
        Usuario userAfter = repositoryUsuario.findById(userBefore.getId()).orElseThrow();
        userAfter.setNome_usuario(userBefore.getNome_usuario());
        userAfter.setEmail(userBefore.getEmail());
        userAfter.setSenha_usuario(userBefore.getSenha_usuario());

        repositoryUsuario.save(userAfter);

        DtoUsuario userDto = new DtoUsuario(userAfter.getNome_usuario(), userAfter.getEmail(), userAfter.getListPosts());

        return userDto;
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
