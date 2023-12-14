package com.example.liblog.repositorys;

import com.example.liblog.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RepositoryUsuario extends JpaRepository<Usuario,Long> {

    @Query("SELECT u FROM Usuario u WHERE u.nome_usuario = :name OR u.email = :name")
    public Usuario findByNameOrEmail(@Param(value = "name") String name);

}
