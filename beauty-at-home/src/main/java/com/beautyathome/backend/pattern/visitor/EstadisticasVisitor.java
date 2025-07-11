package com.beautyathome.backend.pattern.visitor;

import com.beautyathome.backend.pattern.proxy.ReseñaReal;

public class EstadisticasVisitor implements VisitorReseña {

    private int totalReseñas = 0;
    private int sumaCalificaciones = 0;

    @Override
    public void visitReseñaReal(ReseñaReal r) {
        if (r.getCalificacion() > 0) {
            totalReseñas++;
            sumaCalificaciones += r.getCalificacion();
        }
    }

    public int getTotalReseñas() {
        return totalReseñas;
    }

    public double getPromedio() {
        return totalReseñas == 0 ? 0 : (double) sumaCalificaciones / totalReseñas;
    }
}
