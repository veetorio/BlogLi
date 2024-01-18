package com.example.liblog.models;

import com.example.liblog.dto.dto_response.DtoPost;
import com.example.liblog.service.util.Convert;
import io.micrometer.common.KeyValues;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "tb_usuario")
public class Usuario implements Convert {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Long id;
    private String nome_usuario;
    private String senha_usuario;
    @Column(columnDefinition = "TEXT")
    private String path_profile;
    @Column(columnDefinition = "TEXT")
    private String path_banner;

    private String createdAccount;

    @Column(columnDefinition = "TEXT")
    private String email;

    @Column(length = 16)
    private String token;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Post> listPosts = new ArrayList<>();

    public String getPath_profile() {
        return path_profile;
    }

    public String getPath_banner() {
        return path_banner;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}






