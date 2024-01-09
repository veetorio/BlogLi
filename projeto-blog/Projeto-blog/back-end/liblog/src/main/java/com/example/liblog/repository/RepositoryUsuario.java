package com.example.liblog.repository;

import com.example.liblog.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface RepositoryUsuario extends JpaRepository<Usuario,Long> {

    @Query("SELECT u FROM Usuario u WHERE u.nome_usuario = :name OR u.email = :name")
    public Usuario findByNameOrEmail(@Param(value = "name") String name);

    @Query("SELECT D FROM Usuario D WHERE D.nome_usuario = :name AND D.email = :email")
    public List<Usuario> findByNameAndEmail(@Param(value = "name") String name,@Param(value = "email")String email);

    @Query("SELECT u FROM Usuario u WHERE u.nome_usuario = :name OR u.email = :name")
    public List<Usuario> findByNameOrEmailList(@Param(value = "name") String name);


}
