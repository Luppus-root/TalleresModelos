package com.beautyathome.backend.pattern.cor;

public interface Handler {
    void manejarSolicitud(Solicitud solicitud);
    void setSiguiente(Handler siguiente);
    boolean puedeManejar(Solicitud solicitud);
}

