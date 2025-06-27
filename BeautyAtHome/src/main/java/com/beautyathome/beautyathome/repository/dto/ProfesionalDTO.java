package com.beautyathome.beautyathome.repository.dto;

import java.util.List;

// dto/ProfesionalDTO.java
public record ProfesionalDTO(
        String nombre,
        String experiencia,
        List<String> zonasCobertura,
        boolean patrocinado,
        String marcaPatrocinadora
) {}
