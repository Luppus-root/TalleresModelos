package model.base;

import java.util.ArrayList;
import java.util.List;

public class ComidaCompuesta implements Comida {
    protected List<Comida> componentes = new ArrayList<>();

    public void agregarComponente(Comida comida) {
        componentes.add(comida);
    }

    @Override
    public String getDescripcion() {
        StringBuilder descripcion = new StringBuilder();
        for (Comida c : componentes) {
            descripcion.append("- ").append(c.getDescripcion()).append("\n");
        }
        return descripcion.toString();
    }

    @Override
    public double getPrecioUnitario() {
        double total = 0;
        for (Comida c : componentes) {
            total += c.getPrecioUnitario();
        }
        return total;
    }
}
