package com.beautyathome.beautyathome.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

// model/ResenaEntity.java
@Entity
public class ResenaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String clienteAnonimo;
    private String texto;
    private int estrellas;
    private LocalDate fecha;
    private String profesionalId;

    @ElementCollection
    private List<String> imagenes = new ArrayList<>();
}
