package com.example.liblog.controllers;


import com.example.liblog.dto.so.SoUser;
import com.example.liblog.service.ServiceUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("authUser")
public class ControllerAuth {

    @Autowired
    private ServiceUsuario serviceUsuario;
    @PostMapping
    public ResponseEntity authenticate(@RequestBody SoUser user){
        return ResponseEntity.status(HttpStatus.OK).body(serviceUsuario.PostAuth(user));
    }
}
