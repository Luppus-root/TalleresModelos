package com.beautyathome.backend.pattern.factory;

import com.beautyathome.backend.pattern.factory.Profesional;
import com.beautyathome.backend.pattern.factory.ProfesionalPatrocinado;


public interface ProfesionalFactory {
    Profesional crearProfesionalEstandar();
    ProfesionalPatrocinado crearProfesionalPatrocinado();
}
