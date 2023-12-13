package com.example.liblog.service;

import com.example.liblog.dtos.DtoPostagem;
import com.example.liblog.exception.DuplicateException;
import com.example.liblog.exception.RetornoNuloException;
import com.example.liblog.models.PostagemLivro;
import com.example.liblog.repositorys.RepositoryPostagem;
import org.hibernate.query.sql.internal.ParameterRecognizerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Service
public class ServicePostagem {
    @Autowired
    RepositoryPostagem repositoryPostagem;

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
        repositoryPostagem.save(postagemLivro);
<<<<<<< Updated upstream
        isDuplicate(postagemLivro);
=======
>>>>>>> Stashed changes
        return new DtoPostagem(postagemLivro);
    }

    public void delete(String name){
        PostagemLivro dto = repositoryPostagem.findByName(name);
        repositoryPostagem.delete(dto);
    }

    private void isNull(PostagemLivro livro){
        if(livro == null){
            throw new RetornoNuloException("Elemento não encontrado");
        }
    }
    private void isDuplicate(PostagemLivro livro){
        List<PostagemLivro> post = repositoryPostagem.findAll().stream().toList();
        if(post.contains(livro)){
            throw new DuplicateException("Este valor já existe");
        }
    }
}
