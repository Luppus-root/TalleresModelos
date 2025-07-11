package com.beautyathome.backend.pattern.builder;

import com.beautyathome.backend.pattern.composite.ServicioSimple;

public interface ServicioBuilder {
    void reset();
    void setNombre(String nombre);
    void setDescripcion(String descripcion);
    void setPrecio(double precio);
    ServicioSimple obtenerServicio();
}



