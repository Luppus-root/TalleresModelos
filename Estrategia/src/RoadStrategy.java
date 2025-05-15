import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RoadStrategy implements RouteStrategy{

    private static final List<String> TIPOS_VIAS = Arrays.asList(
            "Carrera", "Calle", "Avenida", "Diagonal", "Transversal"
    );

    private static final List<String> LOCALIDADES_BOGOTA = Arrays.asList(
            "Chapinero", "Usaquén", "Santa Fe", "Teusaquillo", "La Candelaria",
            "San Cristóbal", "Usme", "Bosa", "Kennedy", "Fontibón"
    );

    private static final List<String> PUNTOS_REFERENCIA = Arrays.asList(
            "frente al centro comercial", "después del semáforo",
            "junto al parque", "cerca del hospital",
            "al lado de la estación de policía"
    );

    private final Random random = new Random();

    @Override
    public void buildRoute(String origin, String destination) {
        String originAddress = formatAddress(origin);
        String destinationAddress = formatAddress(destination);

        System.out.println("\nRUTA EN VEHÍCULO");
        System.out.println("Dirección origen: " + originAddress);
        System.out.println("Dirección destino: " + destinationAddress);

        int distancia = 2 + random.nextInt(20);
        int tiempoMinutos = distancia * 3 + random.nextInt(15);

        System.out.println("Distancia: " + distancia + " km");
        System.out.println("Tiempo estimado: " + tiempoMinutos + " minutos");

        System.out.println("\nInstrucciones");
        System.out.println("1. Inicie en " + originAddress);
        System.out.println("2. Avance por " + generateRoadName() + " " + PUNTOS_REFERENCIA.get(random.nextInt(PUNTOS_REFERENCIA.size())));

        int distancia1 = random.nextInt(distancia/2) + 1;
        System.out.println("3. En " + distancia1 + " km, gire en " +
                generateIntersection());

        int distancia2 = distancia - distancia1;
        System.out.println("4. Continúe " + distancia2 + " km hasta " +
                destinationAddress + " " +
                PUNTOS_REFERENCIA.get(random.nextInt(PUNTOS_REFERENCIA.size())));
    }

    private String formatAddress(String base) {
        return TIPOS_VIAS.get(random.nextInt(TIPOS_VIAS.size())) + " " +
                (random.nextInt(100) + 1) + " # " +
                (random.nextInt(50) + 1) + " - " +
                (random.nextInt(50) + 1) + ", " +
                LOCALIDADES_BOGOTA.get(random.nextInt(LOCALIDADES_BOGOTA.size()));
    }

    private String generateRoadName() {
        return TIPOS_VIAS.get(random.nextInt(TIPOS_VIAS.size())) + " " +
                (random.nextInt(100) + 1);
    }

    private String generateIntersection() {
        return TIPOS_VIAS.get(random.nextInt(TIPOS_VIAS.size())) + " con " +
                TIPOS_VIAS.get(random.nextInt(TIPOS_VIAS.size()));
    }
}