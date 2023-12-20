package com.example.liblog.repository;

import com.example.liblog.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RepositoryPostagem extends JpaRepository<Post,Long> {
    @Query("from Post p where p.nome = :nome")
    Post findByName(@Param(value = "nome") String name);

    @Query("select p from Post p")
    public List<Post> findAll();

}
