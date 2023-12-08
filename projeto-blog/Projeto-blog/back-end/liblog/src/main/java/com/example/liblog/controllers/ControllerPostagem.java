package com.example.liblog.controllers;

import com.example.liblog.dtos.DtoPostagem;
import com.example.liblog.models.PostagemLivro;
import com.example.liblog.service.ServicePostagem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blog")
public class ControllerPostagem {

    @Autowired
    ServicePostagem servicePostagem;
    @GetMapping
    public List<DtoPostagem> findAll(){
        return servicePostagem.findAll();
    }

    @PostMapping
    public PostagemLivro create(@RequestBody PostagemLivro postagemLivro){
        return servicePostagem.create(postagemLivro);
    }
}
