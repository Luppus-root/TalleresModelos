package Strategies;

import direccion.Direccion;
import java.util.Random;
import java.util.HashSet;
import java.util.Set;

public class TouristAttractionsRoute implements RouteStrategy {
    Direccion.TIPOS_VIAS[] tiposVia = Direccion.TIPOS_VIAS.values();
    Direccion.LOCALIDADES_BOGOTA[] localidadesBogota = Direccion.LOCALIDADES_BOGOTA.values();
    Direccion.PUNTOS_REFERENCIA[] puntosReferencia = Direccion.PUNTOS_REFERENCIA.values();
    Direccion.ATRACCIONES_TURISTICAS[] atracciones = Direccion.ATRACCIONES_TURISTICAS.values();

    private final Random random = new Random();

    @Override
    public void buildRoute(String origen, String destino) {
        String origenAddress = formatAddress();
        System.out.println("\nRUTA TURÍSTICA");
        System.out.println("Punto de partida: " + origenAddress);

        Set<Direccion.ATRACCIONES_TURISTICAS> seleccionadas = new HashSet<>();
        while (seleccionadas.size() < 5) {
            seleccionadas.add(atracciones[random.nextInt(atracciones.length)]);
        }

        int index = 1;
        for (Direccion.ATRACCIONES_TURISTICAS atraccion : seleccionadas) {
            System.out.println(index + ". Visite: " + formatAttractionName(atraccion));
            System.out.println("   → Ubicada en: " + generateRoadName() + " " + formatReferenceName(puntosReferencia[random.nextInt(puntosReferencia.length)]));
            index++;
        }

        String destinoAddress = formatAddress();
        System.out.println("Destino final: " + destinoAddress);
    }

    private String formatAddress() {
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

    private String formatAttractionName(Direccion.ATRACCIONES_TURISTICAS atraccion) {
        return atraccion.name().replace("_", " ");
    }

    @Override
    public String formatReferenceName(Direccion.PUNTOS_REFERENCIA referencia) {
        return referencia.name().replace("_", " ");
    }
}
