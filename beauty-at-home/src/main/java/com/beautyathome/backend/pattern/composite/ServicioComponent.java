package com.beautyathome.backend.pattern.composite;
import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public abstract class ServicioComponent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    protected String nombre;
    protected String descripcion;
    protected Double precio;

    public abstract Double calcularPrecio();
}

