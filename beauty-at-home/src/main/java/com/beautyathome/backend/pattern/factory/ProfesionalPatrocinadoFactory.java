package com.beautyathome.backend.pattern.factory;

import com.beautyathome.backend.pattern.factory.ProfesionalPatrocinado;
import com.beautyathome.backend.pattern.factory.Profesional;
import com.beautyathome.backend.pattern.state.EstadoDisponibilidad;
import com.beautyathome.backend.pattern.state.Disponible;

public class ProfesionalPatrocinadoFactory implements ProfesionalFactory {

    @Override
    public Profesional crearProfesionalEstandar() {
        throw new UnsupportedOperationException("No soportado en esta fábrica");
    }

    @Override
    public ProfesionalPatrocinado crearProfesionalPatrocinado() {
        ProfesionalPatrocinado profesional = new ProfesionalPatrocinado();
        // Estado inicial: disponible (patrón State)
        EstadoDisponibilidad estado = new Disponible();
        profesional.setEstado(estado);
        profesional.setDisponibilidad(estado.mostrarEstado());
        return profesional;
    }
}
