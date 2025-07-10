package com.beautyathome.backend.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProfesionalDTO {

    private Long id;
    private String nombre;
    private String resumen;
    private String fotoUrl;
    private String email;

    private List<Long> zonaIds;
    private Long marcaId;
}

