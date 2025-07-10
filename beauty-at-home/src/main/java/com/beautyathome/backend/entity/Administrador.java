package com.beautyathome.backend.entity;

import com.beautyathome.backend.pattern.composite.ServicioComponent;
import com.beautyathome.backend.pattern.visitor.Reseña;
import com.beautyathome.backend.pattern.proxy.ReseñaReal;
import jakarta.persistence.Entity;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Administrador extends Usuario {

    // Suponemos que estos se obtienen mediante inyección de dependencias en un entorno real
    private static List<Usuario> usuariosRegistrados;
    private static List<ReseñaReal> reseñasRegistradas;

    public ServicioComponent[] consultarClientes() {
        return usuariosRegistrados.stream()
                .filter(u -> u instanceof Cliente)
                .map(u -> (ServicioComponent) u)
                .toArray(ServicioComponent[]::new);
    }

    public ServicioComponent[] consultarProfesionales() {
        return usuariosRegistrados.stream()
                .filter(u -> u instanceof Profesional)
                .map(u -> (ServicioComponent) u)
                .toArray(ServicioComponent[]::new);
    }

    public void estadisticasReseñas(ServicioComponent servicio, Reseña visitor) {
        servicio.aceptar(visitor);
    }

    public void exportarReseñas(Reseña visitor) {
        for (ReseñaReal r : reseñasRegistradas) {
            r.aceptar(visitor);
        }
    }

    public ReseñaReal[] obtenerReseñas() {
        return reseñasRegistradas.toArray(new ReseñaReal[0]);
    }
}
