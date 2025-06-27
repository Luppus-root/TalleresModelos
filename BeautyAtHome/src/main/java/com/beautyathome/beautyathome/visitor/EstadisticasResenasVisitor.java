package com.beautyathome.beautyathome.visitor;

import com.beautyathome.beautyathome.model.Resena;

public class EstadisticasResenasVisitor implements ResenaVisitor {
    private int sumaEstrellas = 0;
    private int total = 0;

    @Override
    public void visitar(Resena resena) {
        sumaEstrellas += resena.getEstrellas();
        total++;
    }

    public double obtenerPromedio() {
        return total == 0 ? 0 : (double) sumaEstrellas / total;
    }
}
