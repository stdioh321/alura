package br.com.alura.forum.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Column;

@Data
@AllArgsConstructor
public class JwtDto {
    private String jwt;
    private String type;

    private UsuarioDto user;

}
