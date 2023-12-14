package com.example.liblog.controllers;

import com.example.liblog.service.ServiceUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/usuarios")
public class ControllerUsuario {
    @Autowired
    ServiceUsuario serviceUsuario;
    @GetMapping
    public ResponseEntity findAll() {
        return ResponseEntity.status(200).body(serviceUsuario.findAll());
    }
    @GetMapping("/{name}")
    public ResponseEntity findByNameOrEmail(@PathVariable(value = "name") String name){
        return ResponseEntity.status(200).body(serviceUsuario.findByNameOrUsuario(name));
    }

}

