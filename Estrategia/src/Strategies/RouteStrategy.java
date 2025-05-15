package Strategies;

import direccion.Direccion;

public interface RouteStrategy {
    void buildRoute(String origen, String destino);
    String formatReferenceName(Direccion.PUNTOS_REFERENCIA referencia);
}
