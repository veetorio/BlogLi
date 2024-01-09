package com.example.liblog.models;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "tb_postagens")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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

    @Override
    public Post clone() throws CloneNotSupportedException {
        return (Post) super.clone();
    }
}
