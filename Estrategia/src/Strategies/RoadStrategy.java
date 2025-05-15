package Strategies;

import direccion.Direccion;
import java.util.Random;

public class RoadStrategy implements RouteStrategy {
    Direccion.TIPOS_VIAS[] tiposVia = Direccion.TIPOS_VIAS.values();
    Direccion.LOCALIDADES_BOGOTA[] localidadesBogota = Direccion.LOCALIDADES_BOGOTA.values();
    Direccion.PUNTOS_REFERENCIA[] puntosReferencia = Direccion.PUNTOS_REFERENCIA.values();

    private final Random random = new Random();

    @Override
    public void buildRoute(String origen, String destino) {
        String origenAddress = formatAddress(origen);
        String destinoAddress = formatAddress(destino);

        System.out.println("\nRUTA EN VEHÍCULO");
        System.out.println("Dirección origen: " + origenAddress);
        System.out.println("Dirección destino: " + destinoAddress);

        int distancia = 2 + random.nextInt(20);
        int tiempoMinutos = distancia * 3 + random.nextInt(15);

        System.out.println("Distancia: " + distancia + " km");
        System.out.println("Tiempo estimado: " + tiempoMinutos + " minutos");

        System.out.println("\nInstrucciones");
        System.out.println("1. Inicie en " + origenAddress);
        System.out.println("2. Avance por " + generateRoadName() + " " + formatReferenceName(puntosReferencia[random.nextInt(puntosReferencia.length)]));

        int distancia1 = random.nextInt(distancia/2) + 1;
        System.out.println("3. En " + distancia1 + " km, gire en " +
                generateIntersection());

        int distancia2 = distancia - distancia1;
        System.out.println("4. Continúe " + distancia2 + " km hasta " +
                destinoAddress + " " +
                formatReferenceName(puntosReferencia[random.nextInt(puntosReferencia.length)]));
        System.out.println("5. Ha llegado a: " + destino);

    }

    private String formatAddress(String base) {
        return tiposVia[random.nextInt(tiposVia.length)] + " " +
                (random.nextInt(100) + 1) + " # " +
                (random.nextInt(50) + 1) + " - " +
                (random.nextInt(50) + 1) + ", " +
                localidadesBogota[random.nextInt(localidadesBogota.length)];
    }

    private String generateRoadName() {
        return tiposVia[random.nextInt(tiposVia.length)] + " " +
                (random.nextInt(100) + 1);
    }

    private String generateIntersection() {
        return tiposVia[random.nextInt(tiposVia.length)] + " " + (random.nextInt(100) + 1) + " con " +
                tiposVia[random.nextInt(tiposVia.length)] + " " + (random.nextInt(100) + 1);
    }

    @Override
    public String formatReferenceName(Direccion.PUNTOS_REFERENCIA referencia) {
        return referencia.name().replace("_", " ");
    }
}