package com.example.liblog.models;

import com.example.liblog.dto.dto_response.DtoPost;
import io.micrometer.common.KeyValues;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "tb_usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Long id;
    private String nome_usuario;
    private String senha_usuario;
    @Column(columnDefinition = "TEXT")
    private String email;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Post> listPosts = new ArrayList<>();

    public String getNome_usuario() {
        return nome_usuario;
    }

    public String getSenha_usuario() {
        return senha_usuario;
    }

    public  List<DtoPost> convert(List<Post> posts){
        return posts
                .stream()
                .map(post -> new DtoPost(post))
                .toList();
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}






