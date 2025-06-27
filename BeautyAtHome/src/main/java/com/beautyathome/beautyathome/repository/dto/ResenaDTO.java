package com.beautyathome.beautyathome.repository.dto;

import java.util.List;

// dto/ResenaDTO.java
public record ResenaDTO(
        String clienteAnonimo,
        String texto,
        int estrellas,
        List<String> imagenes
) {}
