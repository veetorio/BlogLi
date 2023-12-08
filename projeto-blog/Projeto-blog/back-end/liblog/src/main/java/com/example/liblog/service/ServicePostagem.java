package com.example.liblog.service;

import com.example.liblog.dtos.DtoPostagem;
import com.example.liblog.models.PostagemLivro;
import com.example.liblog.repositorys.RepositoryPostagem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServicePostagem {
    @Autowired
    RepositoryPostagem repositoryPostagem;

    public List<DtoPostagem> findAll(){
        List<PostagemLivro> listaLivros = repositoryPostagem.findAll();
        return DtoPostagem.convertDto(listaLivros);
    }
    public PostagemLivro create(PostagemLivro postagemLivro){
        Date data = new Date();
        LocalDate date = data.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        postagemLivro.setData(date);
        return repositoryPostagem.save(postagemLivro);
    }
}
