package com.beautyathome.beautyathome.proxy;

import com.beautyathome.beautyathome.model.Resena;

import java.util.List;
import java.util.Optional;

public class ResenaProxy {
    private final Resena resena;
    private final boolean tienePermiso;

    public ResenaProxy(Resena resena, boolean tienePermiso) {
        this.resena = resena;
        this.tienePermiso = tienePermiso;
    }

    public Optional<String> getTexto() {
        return tienePermiso ? Optional.of(resena.getTexto()) : Optional.empty();
    }

    public Optional<List<String>> getImagenes() {
        return tienePermiso ? Optional.of(resena.getImagenes()) : Optional.empty();
    }

    public int getEstrellas() {
        return resena.getEstrellas();
    }
}
