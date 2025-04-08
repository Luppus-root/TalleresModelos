package builder;

public class Cliente {
    private Chef chef;

    public Cliente(Chef chef) {
        this.chef = chef;
    }

    public void setChef(Chef chef) {
        this.chef = chef;
    }

    public Object construirPizzaHawaiana(String nombreMasa, double precioMasa,
                                         String nombreQueso, double precioQueso,
                                         String nombrePiña, double precioPiña,
                                         String nombreTomate, double precioTomate,
                                         double cantidadTomate) {
        chef.crearComida();
        chef.agregarMasa(nombreMasa, precioMasa);
        chef.agregarQueso(nombreQueso, precioQueso);
        chef.agregarPiña(nombrePiña, precioPiña);
        chef.agregarTomate(nombreTomate, precioTomate);
        chef.agregarSalsaTomate(nombreTomate, cantidadTomate);
        return chef.finalizarComida();
    }

    public Object construirPizzaPollo(String nombreMasa, double precioMasa,
                                      String nombreQueso, double precioQueso,
                                      String nombrePollo, double precioPollo,
                                      String nombreTomate, double precioTomate,
                                      double cantidadTomate) {
        chef.crearComida();
        chef.agregarMasa(nombreMasa, precioMasa);
        chef.agregarQueso(nombreQueso, precioQueso);
        chef.agregarPollo(nombrePollo, precioPollo);
        chef.agregarTomate(nombreTomate, precioTomate);
        chef.agregarSalsaTomate(nombreTomate, cantidadTomate);
        return chef.finalizarComida();
    }
}