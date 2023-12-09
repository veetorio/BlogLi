package com.example.liblog.dtos;

import com.example.liblog.models.PostagemLivro;
import jakarta.persistence.Column;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class DtoPostagem {

    private String nome;
    private String comentario;
    private String url;
    private LocalDate data;
    private String hoursdate;
    public static List<DtoPostagem> convertListDto(List<PostagemLivro> postagemLivro){
        return postagemLivro.stream().map(DtoPostagem::new).collect(Collectors.toList());
    }

    public DtoPostagem(PostagemLivro postagemLivro) {
        this.nome = postagemLivro.getNome();
        this.comentario = postagemLivro.getComentario();
        this.url = postagemLivro.getUrl();
        this.data = postagemLivro.getData();
        this.hoursdate = postagemLivro.getHoursdate();
    }
}
