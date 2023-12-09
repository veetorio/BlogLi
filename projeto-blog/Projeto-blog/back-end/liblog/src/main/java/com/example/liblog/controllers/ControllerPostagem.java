package com.example.liblog.controllers;

import com.example.liblog.dtos.DtoPostagem;
import com.example.liblog.models.PostagemLivro;
import com.example.liblog.service.ServicePostagem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;


import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.logging.Logger;

@RestController
@RequestMapping("/blog")
public class ControllerPostagem {

    @Autowired
    ServicePostagem servicePostagem;

    @GetMapping
    public ResponseEntity<List<DtoPostagem>> findAll() {
        return ResponseEntity.status(200).body(servicePostagem.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DtoPostagem> findById(@PathVariable(value = "id") Long id) {
        try{
             return ResponseEntity.status(HttpStatus.FOUND).body(servicePostagem.findById(id));
        }catch(NoSuchElementException such){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    public ResponseEntity<DtoPostagem> create(@RequestBody PostagemLivro postagemLivro) {
        try {
            return ResponseEntity.status(201).body(servicePostagem.create(postagemLivro));
        }catch (Exception exceptionDuplicate){
            String errorMessage = exceptionDuplicate.getCause().getLocalizedMessage();
            return ResponseEntity.status(HttpStatus.FORBIDDEN).header("error",errorMessage).build();
        }
    }
}
