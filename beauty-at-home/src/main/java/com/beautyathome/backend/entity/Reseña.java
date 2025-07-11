package com.beautyathome.backend.entity;
import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Reseña {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String texto;
    private int estrellas;

    @OneToOne
    private ServicioRealizado servicioRealizado;

    public String resumen() {
        return "Reseña: " + estrellas + " estrellas - " + texto;
    }

    public void exportar() {
        // Placeholder para el patrón Visitor
    }

}

