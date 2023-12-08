package com.example.liblog.models;


import jakarta.persistence.*;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "tabela_postagens")
public class PostagemLivro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,length = 30)
    private String nome;
    @Column(columnDefinition = "Text",nullable = false)
    private String comentario;
    @Column(name = "imagem",columnDefinition = "Text",nullable = false)
    private String url;
    @Column(name = "postagem")
    private LocalDate data;
}
