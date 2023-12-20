package com.example.liblog.controllers;

import com.example.liblog.models.Usuario;
import com.example.liblog.service.ServiceUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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

    @PostMapping
    public ResponseEntity createUser(@RequestBody Usuario user){
        return ResponseEntity.status(202).body(serviceUsuario.create(user));
    }
    @PutMapping
    public ResponseEntity updateUser(@RequestBody Usuario usuario){
        return ResponseEntity.status(202).body(serviceUsuario.update(usuario));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable(value = "id") Long id){
        return ResponseEntity.status(200).body(serviceUsuario.delete(id));
    }

    @PostMapping("/authenticate")
    public ResponseEntity authenticate(@RequestBody Usuario user){
        return ResponseEntity.status(HttpStatus.OK).body(serviceUsuario.PostAuth(user));
    }
}

