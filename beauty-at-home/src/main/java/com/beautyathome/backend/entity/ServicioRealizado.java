package com.beautyathome.backend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ServicioRealizado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate fecha;

    @ElementCollection
    private List<String> fotosResultado;

    @ManyToOne
    private Profesional profesional;

    @ManyToOne
    private Cliente cliente;

    @OneToOne(mappedBy = "servicioRealizado", cascade = CascadeType.ALL)
    private Reseña reseña;
}

