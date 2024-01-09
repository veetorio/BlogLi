package com.example.liblog.service;

import com.example.liblog.dto.dto_response.DtoUsuario;
import com.example.liblog.dto.so.SoUser;
import com.example.liblog.error.exception.AuthenticateException;
import com.example.liblog.error.exception.NotExistUserException;
import com.example.liblog.error.exception.ReturnNullException;
import com.example.liblog.models.Usuario;
import com.example.liblog.repository.RepositoryUsuario;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        Usuario user = repositoryUsuario.findByNameOrEmail(name);
        DtoUsuario userDto = new DtoUsuario(user);
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
    public DtoUsuario PostAuth(@NotNull SoUser soUser)  {
        Usuario usuario = repositoryUsuario.findByNameOrEmail(soUser.getDataSearchName());
        NotExistUserException.NotNullObject(usuario);
        AuthenticateException.ValidateUser(usuario,soUser);
        return new DtoUsuario(usuario);
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
