package com.example.liblog.service;

import com.example.liblog.dto.DtoPostagem;
import com.example.liblog.exception.NotExistUserException;
import com.example.liblog.exception.ReturnNullException;
import com.example.liblog.models.PostagemLivro;
import com.example.liblog.models.Usuario;
import com.example.liblog.repository.RepositoryPostagem;
import com.example.liblog.repository.RepositoryUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicePostagem {
    @Autowired
    RepositoryPostagem repositoryPostagem;
    @Autowired
    RepositoryUsuario repositoryUsuario;

    public List<DtoPostagem> findAll(){
        List<PostagemLivro> listaLivros = repositoryPostagem.findAll();
        return DtoPostagem.convertListDto(listaLivros);
    }

    public DtoPostagem findByName(String name){
       PostagemLivro livro = repositoryPostagem.findByName(name);
       isNull(livro);
       DtoPostagem dto = new DtoPostagem(livro);
       return dto;
    }

    public DtoPostagem create(PostagemLivro postagemLivro){
        ExistUser(postagemLivro);
        repositoryPostagem.save(postagemLivro);
        return new DtoPostagem(postagemLivro);
    }

    public void delete(String name){
        PostagemLivro dto = repositoryPostagem.findByName(name);
        repositoryPostagem.delete(dto);
    }

    private void isNull(PostagemLivro livro){
        if(livro == null){
            throw new ReturnNullException("Elemento não encontrado");
        }
    }
    private void ExistUser(PostagemLivro post){
        Usuario element = repositoryUsuario.findById(post.getUser().getId()).orElseThrow( () -> {throw new NotExistUserException("usuario não existe");});
    }

}
