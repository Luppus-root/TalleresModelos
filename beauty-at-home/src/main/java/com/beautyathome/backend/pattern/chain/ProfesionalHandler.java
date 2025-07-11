package com.beautyathome.backend.pattern.chain;

public class ProfesionalHandler implements Handler {

    private Handler siguiente;
    private String especialidad;
    private boolean disponible;

    public ProfesionalHandler(String especialidad, boolean disponible) {
        this.especialidad = especialidad;
        this.disponible = disponible;
    }

    @Override
    public void setSiguiente(Handler siguiente) {
        this.siguiente = siguiente;
    }

    @Override
    public void manejarSolicitud(Solicitud solicitud) {
        if (puedeManejar(solicitud)) {
            System.out.println("Solicitud '" + solicitud.getDescripcion() +
                    "' atendida por profesional de " + especialidad);
            solicitud.marcarAtendida();
        } else if (siguiente != null) {
            siguiente.manejarSolicitud(solicitud);
        } else {
            System.out.println("Ningún profesional disponible para la solicitud: " + solicitud.getDescripcion());
        }
    }

    public boolean puedeManejar(Solicitud solicitud) {
        return disponible && solicitud.getDescripcion().contains(especialidad);
    }
}
