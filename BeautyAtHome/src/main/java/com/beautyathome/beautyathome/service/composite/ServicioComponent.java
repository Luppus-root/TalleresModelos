package com.beautyathome.beautyathome.service.composite;

import java.util.List;

public interface ServicioComponent {
    String getNombre();
    String getDescripcion();
    double getPrecio();
    List<String> getImagenes();
}
