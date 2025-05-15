public class NavigationApp {
    private RouteStrategy routingStrategy;

    public void setRouteStrategy(RouteStrategy rs) {
        this.routingStrategy = rs;
    }

    public void buildRoute(String origin, String destination) {

        System.out.println("\nORIGEN: " + origin);
        System.out.println("DESTINO: " + destination);

        routingStrategy.buildRoute(origin, destination);
    }
}