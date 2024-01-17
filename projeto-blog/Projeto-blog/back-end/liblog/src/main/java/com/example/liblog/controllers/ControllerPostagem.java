package com.example.liblog.controllers;

import com.example.liblog.dto.dto_response.DtoPost;
import com.example.liblog.dto.dto_response.Response;
import com.example.liblog.models.Post;
import com.example.liblog.service.ServicePostagem;

import com.github.slugify.Slugify;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/blog")
public class ControllerPostagem {

    Slugify slugify = new Slugify();
    @Autowired
    ServicePostagem servicePostagem;

    @GetMapping
    public ResponseEntity<List<DtoPost>> findAll() {
        return ResponseEntity.status(200).body(servicePostagem.findAll());
    }
    @GetMapping("/{name}")
    public ResponseEntity findByName(@PathVariable String name) {
        List returndto = servicePostagem.findByName(slugify.slugify(name));
        return ResponseEntity.status(200).body(returndto);
    }

    @PostMapping
    public ResponseEntity<DtoPost> create(@RequestBody Post postagemLivro,@RequestHeader String token,@RequestHeader String name) {
        servicePostagem.authorized(token,name);
        return ResponseEntity.status(201).body(servicePostagem.create(postagemLivro));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteByName(@PathVariable(value = "id") String id,@RequestHeader String token,@RequestHeader String name){
//        servicePostagem.authorized(token,name);
        servicePostagem.delete(id);
        return ResponseEntity.status(200).body(new Response("Post deletado com sucesso"));
    }

    @PutMapping
    public  ResponseEntity update(@RequestBody Post postBefore,@RequestHeader String token,@RequestHeader String name){
//        servicePostagem.authorized(token,name);
        return ResponseEntity.status(HttpStatus.OK).body(servicePostagem.update(postBefore));
    }

}
