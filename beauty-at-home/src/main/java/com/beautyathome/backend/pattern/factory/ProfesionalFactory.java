package com.beautyathome.backend.pattern.factory;

import com.beautyathome.backend.entity.ProfesionalEstandar;
import com.beautyathome.backend.entity.ProfesionalPatrocinado;

public interface ProfesionalFactory {
    ProfesionalEstandar crearProfesionalEstandar();
    ProfesionalPatrocinado crearProfesionalPatrocinado();
}
