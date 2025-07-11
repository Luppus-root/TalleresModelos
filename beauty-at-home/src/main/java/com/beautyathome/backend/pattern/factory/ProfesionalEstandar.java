package com.beautyathome.backend.pattern.factory;

import com.beautyathome.backend.pattern.builder.ServicioBuilder;
import com.beautyathome.backend.pattern.composite.ServicioSimple;
import com.beautyathome.backend.pattern.state.EstadoDisponibilidad;
import com.beautyathome.backend.pattern.observer.ObservadorDisponibilidad;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;


public class ProfesionalEstandar extends Profesional {

    public ProfesionalEstandar() {
        super();
    }

    public ProfesionalEstandar(ServicioBuilder servicioBuilder) {
        super(servicioBuilder);
    }

    public Profesional crearProfesional() {
        return new ProfesionalEstandar();
    }

}

