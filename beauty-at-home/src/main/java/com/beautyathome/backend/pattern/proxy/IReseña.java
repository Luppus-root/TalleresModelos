package com.beautyathome.backend.pattern.proxy;

import com.beautyathome.backend.pattern.visitor.VisitorReseña;

public interface IReseña {
    void eliminarReseña();
    String obtenerReseña();
    void exportar();
    String resumen();
    void aceptar(VisitorReseña v);
}

