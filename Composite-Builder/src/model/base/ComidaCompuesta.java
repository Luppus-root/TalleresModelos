package model.base;

import java.util.ArrayList;

public class ComidaCompuesta implements Comida {
    protected ArrayList<Comida> children;

    public ComidaCompuesta() {
        this.children = new ArrayList<>();
    }

    @Override
    public String getDescripcion() {
        StringBuilder descripcion = new StringBuilder("Comida compuesta que contiene: ");
        for (Comida comida : children) {
            descripcion.append(comida.getDescripcion()).append(", ");
        }
        return descripcion.substring(0, descripcion.length() - 2);
    }

    public void agregar(Comida comida) {
        children.add(comida);
    }

    public void eliminar(Comida comida) {
        children.remove(comida);
    }
}