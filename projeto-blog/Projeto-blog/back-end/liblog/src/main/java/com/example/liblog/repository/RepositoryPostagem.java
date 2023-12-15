package com.example.liblog.repository;

import com.example.liblog.models.PostagemLivro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RepositoryPostagem extends JpaRepository<PostagemLivro,Long> {
    @Query("from PostagemLivro p where p.nome = :nome")
    PostagemLivro findByName(@Param(value = "nome") String name);

    @Query("select p from PostagemLivro p")
    public List<PostagemLivro> findAll();

}
