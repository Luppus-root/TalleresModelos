package com.beautyathome.backend.pattern.factory;

import com.beautyathome.backend.pattern.builder.ServicioBuilder;
import com.beautyathome.backend.pattern.composite.ServicioSimple;
import com.beautyathome.backend.pattern.state.EstadoDisponibilidad;
import com.beautyathome.backend.pattern.observer.ObservadorDisponibilidad;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class ProfesionalPatrocinado extends Profesional {
    private String patrocinador;

    public ProfesionalPatrocinado() {
        super();
    }

    public String getPatrocinador() {
        return patrocinador;
    }

    public void setPatrocinador(String patrocinador) {
        this.patrocinador = patrocinador;
    }

    public Profesional crearProfesional() {
        return new ProfesionalPatrocinado();
    }

}
