package com.beautyathome.backend.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponse {

    private String token;
    private String tipoUsuario; // CLIENTE, PROFESIONAL, ADMINISTRADOR
    private Long usuarioId;
}

