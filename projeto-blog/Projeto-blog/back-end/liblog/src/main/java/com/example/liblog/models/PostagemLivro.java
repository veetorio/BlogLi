package com.example.liblog.models;


import jakarta.persistence.*;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
@Entity
@Table(name = "tb_postagens")
public class PostagemLivro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false,length = 35)
    private String nome;
    @Column(columnDefinition = "Text",nullable = false)
    private String comentario;
    @Column(name = "imagem",columnDefinition = "Text",nullable = false)
    private String url;
    @Column(name = "dia_postagem")
    private LocalDate data;
    @Column(name = "hora_postagem",length = 12)
    private String hoursdate;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private Usuario user;




}
