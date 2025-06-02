package core;

public class Memento {
    private final float estado;

    public Memento(float estado) {
        this.estado = estado;
    }

    public float obtenerEstado() {
        return estado;
    }
}