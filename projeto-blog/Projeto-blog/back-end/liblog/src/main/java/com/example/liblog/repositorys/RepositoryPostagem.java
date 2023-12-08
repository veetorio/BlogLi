package com.example.liblog.repositorys;

import com.example.liblog.models.PostagemLivro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryPostagem extends JpaRepository<PostagemLivro,Long> {
}
