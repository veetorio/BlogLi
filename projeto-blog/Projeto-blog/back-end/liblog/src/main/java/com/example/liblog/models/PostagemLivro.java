package com.example.liblog.models;


import jakarta.persistence.*;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Entity
@Table(name = "tabela_postagens")
public class PostagemLivro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,unique = true)
    private String nome;
    @Column(columnDefinition = "Text",nullable = false,unique = true)
    private String comentario;
    @Column(name = "imagem",columnDefinition = "Text",nullable = false)
    private String url;
    @Column(name = "dia_postagem")
    private LocalDate data;
    @Column(name = "hora_postagem")
    private String hoursdate;
}
