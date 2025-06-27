package com.beautyathome.beautyathome.util;

import com.beautyathome.beautyathome.model.Resena;

import java.util.ArrayList;
import java.util.List;

// util/ListaResenas.java
public class ListaResenas {
    private final List<Resena> resenas = new ArrayList<>();

    public void agregar(Resena r) {
        resenas.add(r);
    }

    public ResenaIterator crearIterador() {
        return new ResenaIterator() {
            private int indice = 0;

            @Override
            public boolean tieneSiguiente() {
                return indice < resenas.size();
            }

            @Override
            public Resena siguiente() {
                return resenas.get(indice++);
            }
        };
    }
}

