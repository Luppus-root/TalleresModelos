package com.beautyathome.backend.pattern.proxy;

import com.beautyathome.backend.pattern.visitor.VisitorReseña;

public interface Reseña {
    void eliminarReseña();
    String obtenerReseña();
    void aceptar(VisitorReseña v);
}
