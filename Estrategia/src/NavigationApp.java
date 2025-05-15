import Strategies.RouteStrategy;

public class NavigationApp {
    private RouteStrategy routingStrategy;

    public void setRouteStrategy(RouteStrategy rs) {
        this.routingStrategy = rs;
    }

    public void buildRoute(String origen, String destino) {

        System.out.println("\nORIGEN: " + origen);
        System.out.println("DESTINO: " + destino);

        routingStrategy.buildRoute(origen, destino);
    }
}