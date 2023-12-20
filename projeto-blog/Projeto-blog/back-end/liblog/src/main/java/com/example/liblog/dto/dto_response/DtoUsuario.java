package com.example.liblog.dto.dto_response;

import com.example.liblog.models.Usuario;
import lombok.Data;

import java.util.List;

public record DtoUsuario(String name,String email,List mypost) { }