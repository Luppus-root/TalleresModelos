package com.beautyathome.backend.pattern.strategy;
import com.beautyathome.backend.pattern.strategy.IEstrategia;

public class Cliente {
    private String nombre;
    private IEstrategia estrategia;

    public Cliente(String nombre, IEstrategia estrategia) {
        this.nombre = nombre;
        this.estrategia = estrategia;
    }

    public void setEstrategia(IEstrategia estrategia) {
        this.estrategia = estrategia;
    }

    // Getters y setters básicos
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
