package com.beautyathome.beautyathome.service.composite;

import java.util.List;

// service/composite/ServicioComponent.java
public interface ServicioComponent {
    String getNombre();
    String getDescripcion();
    double getPrecio();
    List<String> getImagenes();
}
