package com.beautyathome.backend.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ServicioDTO {

    private Long id;
    private String nombre;
    private String descripcion;
    private Double precio;
    private List<String> imagenes;

    private Long profesionalId;
    private List<Long> serviciosIncluidosIds; // para ServicioPaquete
    private boolean decorado;
    private String regalo;
    private Double descuento;
}

