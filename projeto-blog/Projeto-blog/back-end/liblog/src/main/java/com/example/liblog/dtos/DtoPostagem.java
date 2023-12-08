package com.example.liblog.dtos;

import com.example.liblog.models.PostagemLivro;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class DtoPostagem {

    private String nome;
    private String comentario;
    private String url;
    private LocalDate data;

    public static List<DtoPostagem> convertDto(List<PostagemLivro> postagemLivro){
        return postagemLivro.stream().map(livros -> new DtoPostagem(livros)).collect(Collectors.toList());
    }

    public DtoPostagem(PostagemLivro postagemLivro) {
        this.nome = postagemLivro.getNome();
        this.comentario = postagemLivro.getComentario();
        this.url = postagemLivro.getUrl();
        this.data = postagemLivro.getData();
    }
}
