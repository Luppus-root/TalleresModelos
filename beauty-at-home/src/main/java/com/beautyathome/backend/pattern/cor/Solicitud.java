package com.beautyathome.backend.pattern.cor;

public class Solicitud {
    private String descripcion;
    private boolean atendida;

    public Solicitud(String descripcion) {
        this.descripcion = descripcion;
        this.atendida = false;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public boolean isAtendida() {
        return atendida;
    }

    public void marcarAtendida() {
        this.atendida = true;
    }
}
