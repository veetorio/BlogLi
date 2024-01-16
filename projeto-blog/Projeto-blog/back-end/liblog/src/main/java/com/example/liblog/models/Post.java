package com.example.liblog.models;


import com.example.liblog.service.util.SimplifierAction;
import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "tb_postagens")
public class Post implements SimplifierAction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,length = 65)
    private String nome;
    @Column(columnDefinition = "TEXT",nullable = false)
    private String comentario;
    @Column(name = "imagem",columnDefinition = "Text",nullable = false)
    private String url;
    @Column(columnDefinition = "TEXT")
    private String pathBanner;





    @Column(name = "dia_postagem")
    private String data;
    @Column(name = "hora_postagem",length = 12)
    private String hoursdate;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private Usuario user;

    public String getPathBanner() {
        return pathBanner;
    }
}
