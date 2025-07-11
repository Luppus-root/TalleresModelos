package com.beautyathome.backend.pattern.factory;

import com.beautyathome.backend.pattern.factory.Profesional;
import com.beautyathome.backend.pattern.factory.ProfesionalEstandar;
import com.beautyathome.backend.pattern.factory.ProfesionalPatrocinado;
import com.beautyathome.backend.pattern.state.Disponible;
import com.beautyathome.backend.pattern.state.EstadoDisponibilidad;


public class ProfesionalEstandarFactory implements ProfesionalFactory {

    @Override
    public Profesional crearProfesionalEstandar() {
        Profesional profesional = new ProfesionalEstandar();

        // Estado inicial: disponible (patrón State)

        EstadoDisponibilidad estado = new Disponible();
        profesional.setEstado(estado);
        profesional.setDisponibilidad(estado.mostrarEstado());

        return profesional;
    }

    @Override
    public ProfesionalPatrocinado crearProfesionalPatrocinado() {
        throw new UnsupportedOperationException("No soportado en esta fábrica");
    }
}
