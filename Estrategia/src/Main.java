// Main.java (debe estar en el directorio raíz src/)
public class Main {
    public static void main(String[] args) {
        NavigationApp app = new NavigationApp();
        app.setRouteStrategy(new RoadStrategy()); // Cambio aquí

        app.buildRoute("Casa", "Universidad");
        app.buildRoute("Universidad", "Biblioteca");
    }
}