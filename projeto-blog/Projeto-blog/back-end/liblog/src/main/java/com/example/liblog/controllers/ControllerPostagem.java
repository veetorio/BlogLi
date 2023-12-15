package com.example.liblog.controllers;

import com.example.liblog.dto.DtoPostagem;
import com.example.liblog.models.PostagemLivro;
import com.example.liblog.service.ServicePostagem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/blog")
public class ControllerPostagem {

    NoSuchElementException suc;
    @Autowired
    ServicePostagem servicePostagem;

    @GetMapping
    public ResponseEntity<List<DtoPostagem>> findAll() {
        return ResponseEntity.status(200).body(servicePostagem.findAll());
    }

    @GetMapping("/{name}")
    public ResponseEntity<DtoPostagem> findByName(@PathVariable(value = "name") String name) {
        DtoPostagem returndto = servicePostagem.findByName(name);
        return ResponseEntity.status(200).body(returndto);
    }

    @PostMapping
    public ResponseEntity<DtoPostagem> create(@RequestBody PostagemLivro postagemLivro) {
        return ResponseEntity.status(201).body(servicePostagem.create(postagemLivro));
    }

    @DeleteMapping("/{name}")
    public ResponseEntity deleteByName(@PathVariable(value = "name") String name){
        servicePostagem.delete(name);
        return ResponseEntity.status(200).body("objeto deletado com sucesso");
    }

}
