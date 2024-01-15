package com.example.liblog.service.util;


import com.example.liblog.dto.so.SoUser;
import com.example.liblog.error.exception.AuthenticateException;
import com.example.liblog.error.exception.NotExistUserException;
import com.example.liblog.error.exception.ReturnNullException;
import com.example.liblog.models.Usuario;
import com.example.liblog.repository.RepositoryUsuario;


import java.util.List;
import java.util.NoSuchElementException;

public interface Validates{

    default void emptyList(List obj,String value){
        if(obj.isEmpty()) throw new ReturnNullException( value + " não encontrado");
    }
    default void NotExist(Object object,String value){
        if(object != null) throw new NoSuchElementException();
    }
    default void Exist(Object object){
        if(object == null) throw new NotExistUserException("Este usuario não existe");
    }
    default void ExistIntoTable(RepositoryUsuario repositoryUsuario, Usuario user){
        List<Usuario> users = repositoryUsuario
                .findAll()
                .stream()
                .toList();
        users.forEach( usuario -> {
                    // verificar se o usuario já não existe
                    boolean inUseName = usuario.getNome_usuario().equals(user.getNome_usuario());
                    // verificar se o email já existe
                    boolean inUseEmail = usuario.getEmail().equals(user.getEmail());
                    if (inUseName){
                        throw new AuthenticateException("não é possivel de dar proseguimento,pois o nome já está em uso");
                    } else if (inUseEmail) {
                        throw new AuthenticateException("não é possivel dar proseguimento,pois email já está em uso");

                    }
                }
        );
    }
    default void Auth(Usuario tuple, SoUser newTuple){
        if (!(tuple.getSenha_usuario().equals(newTuple.getDataSearchPassword()))) throw new AuthenticateException("Este usuario não é autenticado");
    }
    default Boolean IsAuth(Boolean auth,Object object){


        return true;
    }
}

