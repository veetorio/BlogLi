package com.example.liblog.service;

import com.example.liblog.dto.dto_response.DtoPost;
import com.example.liblog.dto.dto_response.DtoUsuario;
import com.example.liblog.error.exception.NotExistUserException;
import com.example.liblog.error.exception.ReturnNullException;
import com.example.liblog.models.Post;
import com.example.liblog.models.Usuario;
import com.example.liblog.repository.RepositoryPostagem;
import com.example.liblog.repository.RepositoryUsuario;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

@Service
public class ServicePostagem {
    @Autowired
    RepositoryPostagem repositoryPostagem;
    @Autowired
    RepositoryUsuario repositoryUsuario;

    public List<DtoPost> findAll(){
        List<Post> listaLivros = repositoryPostagem.findAll();
        return repositoryPostagem.
                findAll()
                .stream()
                .map(DtoPost::new)
                .toList();
    }

    public DtoPost findByName(String name){
       Post livro = repositoryPostagem.findByName(name);
       isNull(livro);
       DtoPost dto = new DtoPost(livro);
       return dto;
    }

    public DtoPost create(Post livro){
        ExistUser(livro);
        repositoryPostagem.save(livro);
        DtoPost tuple_dto = new DtoPost(livro);
        return tuple_dto;
    }

    public void delete(String name){
        Post dto = repositoryPostagem.findByName(name);
        repositoryPostagem.delete(dto);
    }

    @SneakyThrows
    public DtoPost[] update(Post post){
        Post entityAfter = repositoryPostagem.findById(post.getId()).orElseThrow( () -> new NotExistUserException("este post não existe"));

        DtoPost dtoBafore = new DtoPost(entityAfter);


        entityAfter.setComentario(post.getComentario());
        entityAfter.setNome(post.getNome());
        entityAfter.setUrl(post.getUrl());

        repositoryPostagem.save(entityAfter);

        DtoPost dtoAfter = new DtoPost(entityAfter);

        DtoPost[] arrayPost = new DtoPost[2];
        arrayPost[0] = dtoBafore;
        arrayPost[1] = dtoAfter;

        return arrayPost;
    }

    private void isNull(Post livro){
        if(livro == null){
            throw new ReturnNullException("Elemento não encontrado");
        }
    }
    private void ExistUser(Post post){
        Usuario element = repositoryUsuario.findById(post.getUser().getId()).orElseThrow( () -> {throw new NotExistUserException("usuario não existe");});
    }

}
