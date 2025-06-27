package com.beautyathome.beautyathome.model;
// model/ProfesionalPatrocinado.java
public class ProfesionalPatrocinado extends Profesional {
    private String marcaPatrocinadora;

    public ProfesionalPatrocinado(String nombre, String experiencia, String marca) {
        super(nombre, experiencia);
        this.marcaPatrocinadora = marca;
    }

    @Override
    public boolean usaProductosExclusivos() {
        return true;
    }

    @Override
    public String tipo() {
        return "Patrocinado por " + marcaPatrocinadora;
    }

    public String getMarcaPatrocinadora() {
        return marcaPatrocinadora;
    }
}
