import Strategies.PublicTransportStrategy;
import Strategies.RoadStrategy;
import Strategies.TouristAttractionsRoute;
import Strategies.WalkingStrategy;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        NavigationApp app = new NavigationApp();

        System.out.println("Seleccione el modo de viaje que desea: ");
        System.out.println("1. Carro");
        System.out.println("2. Transporte Público");
        System.out.println("3. Caminando");
        System.out.println("4. Ruta turística");
        System.out.println("Eleccion: ");
        int seleccion = sc.nextInt();

        switch (seleccion){
            case 1:
                app.setRouteStrategy(new RoadStrategy());
                break;
            case 2:
                app.setRouteStrategy(new PublicTransportStrategy());
                break;
            case 3:
                app.setRouteStrategy(new WalkingStrategy());
                break;
            case 4:
                app.setRouteStrategy(new TouristAttractionsRoute());
                break;
            default:
                System.out.println("Seleccione una opcion válida");
                System.exit(0);
                break;
        }

        app.buildRoute("Casa", "Universidad");
        app.buildRoute("Universidad", "Biblioteca");
    }
}