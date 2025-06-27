package com.beautyathome.beautyathome.repository.dto;

import java.util.List;

public record ResenaPrivadaDTO(
        String texto,
        int estrellas,
        List<String> imagenes
) {}