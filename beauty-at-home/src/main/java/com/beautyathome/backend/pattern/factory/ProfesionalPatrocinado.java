package com.beautyathome.backend.pattern.factory;


public class ProfesionalPatrocinado extends Profesional {
    private String patrocinador;

    public ProfesionalPatrocinado() {
        super();
    }

    public String getPatrocinador() {
        return patrocinador;
    }

    public void setPatrocinador(String patrocinador) {
        this.patrocinador = patrocinador;
    }

    public Profesional crearProfesional() {
        return new ProfesionalPatrocinado();
    }

}
