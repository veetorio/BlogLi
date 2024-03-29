package com.example.liblog.repository;

import com.example.liblog.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.xml.namespace.QName;
import java.util.List;

public interface RepositoryPostagem extends JpaRepository<Post,Long> {
    @Query("from Post p where p.nome = :nome")
    Post findByName(@Param(value = "nome") String name);

    @Query("SELECT p FROM Post p ORDER BY p.id DESC")
    List<Post> findAll();

    @Query("from Post p where p.type = :type")
    List findByType(String type);

    @Query("SELECT p FROM Post p WHERE p.slugTitle LIKE %?1%")
    List<Post> findByNameContaining(String name);


}
