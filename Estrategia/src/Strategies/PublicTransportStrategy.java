package Strategies;

import direccion.Direccion;

import java.util.Random;

public class PublicTransportStrategy implements RouteStrategy {
    Direccion.TIPOS_VIAS[] tiposVia = Direccion.TIPOS_VIAS.values();
    Direccion.LOCALIDADES_BOGOTA[] localidadesBogota = Direccion.LOCALIDADES_BOGOTA.values();
    Direccion.PUNTOS_REFERENCIA[] puntosReferencia = Direccion.PUNTOS_REFERENCIA.values();

    private final Random random = new Random();

    @Override
    public void buildRoute(String origen, String destino) {
        String origenAddress = formatAddress(origen);
        String destinoAddress = formatAddress(destino);

        System.out.println("\nRUTA EN TRANSPORTE PÚBLICO");
        System.out.println("Dirección origen: " + origenAddress);
        System.out.println("Dirección destino: " + destinoAddress);

        int distancia = 5 + random.nextInt(15); // 5 a 20 km
        int tiempoMinutos = distancia * 4 + random.nextInt(15); // 4 min/km

        System.out.println("Distancia: " + distancia + " km");
        System.out.println("Tiempo estimado: " + tiempoMinutos + " minutos");

        System.out.println("\nInstrucciones");
        System.out.println("1. Desde " + origenAddress + ", camine hasta la estación más cercana.");
        System.out.println("2. Tome el bus de la ruta " + generateRouteCode() + " hacia " + localidadesBogota[random.nextInt(localidadesBogota.length)]);
        System.out.println("3. Bájese en " + formatReferenceName(puntosReferencia[random.nextInt(puntosReferencia.length)]));
        System.out.println("4. Transborde a la ruta " + generateRouteCode() + " y continúe hasta " + destinoAddress);
        System.out.println("5. Ha llegado a: " + destino);
    }


     private String formatAddress(String base) {
        return tiposVia[random.nextInt(tiposVia.length)] + " " +
                (random.nextInt(100) + 1) + " # " +
                (random.nextInt(50) + 1) + " - " +
                (random.nextInt(50) + 1) + ", " +
                localidadesBogota[random.nextInt(localidadesBogota.length)];
    }

    private String generateRouteCode() {
        char letra = (char) ('A' + random.nextInt(26));
        int numero = 1 + random.nextInt(99);
        return letra + String.valueOf(numero); // Ejemplo: B12
    }

    @Override
    public String formatReferenceName(Direccion.PUNTOS_REFERENCIA referencia) {
        return referencia.name().replace("_", " ");
    }
}
