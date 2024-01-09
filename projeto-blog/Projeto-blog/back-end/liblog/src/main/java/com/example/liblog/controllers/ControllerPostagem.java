package com.example.liblog.controllers;

import com.example.liblog.dto.dto_response.DtoPost;
import com.example.liblog.models.Post;
import com.example.liblog.service.ServicePostagem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<List<DtoPost>> findAll() {
        return ResponseEntity.status(200).body(servicePostagem.findAll());
    }

    @GetMapping("/{name}")
    public ResponseEntity findByName(@PathVariable(value = "name") String name) {
        DtoPost returndto = servicePostagem.findByName(name);
        return ResponseEntity.status(200).body(returndto);
    }

    @PostMapping
    public ResponseEntity<DtoPost> create(@RequestBody Post postagemLivro) {
        return ResponseEntity.status(201).body(servicePostagem.create(postagemLivro));
    }

    @DeleteMapping("/{name}")
    public ResponseEntity deleteByName(@PathVariable(value = "name") String name){
        servicePostagem.delete(name);
        return ResponseEntity.status(200).body("objeto deletado com sucesso");
    }

    @PutMapping
    public  ResponseEntity update(@RequestBody Post postBefore){
        return ResponseEntity.status(HttpStatus.OK).body(servicePostagem.update(postBefore));
    }

}
