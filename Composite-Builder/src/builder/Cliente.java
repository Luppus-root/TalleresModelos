package builder;

public class Cliente {
    private Chef chef;

    public Cliente(Chef chef) {
        this.chef = chef;
    }

    public String ordenarPizzaEstandar() {
        chef.agregarMasa("Delgada", 3.5);
        chef.agregarQueso("Mozzarella", 2.5);
        chef.agregarTomate("Roma", 1.5);
        chef.agregarSalsaTomate("Roma", 0.3);
        chef.agregarPollo("Asado", 4.5);
        chef.agregarPiña("Dulce", 2.0);

        return chef.crearComida();
    }

    public String ordenarPizzaEspecial() {
        chef.agregarMasa("Gruesa", 4.5);
        chef.agregarQueso("Cheddar", 3.5);
        chef.agregarTomate("Cherry", 2.5);
        chef.agregarSalsaTomate("Cherry", 0.5);
        chef.agregarPollo("Marinado", 5.5);
        chef.agregarPiña("Extra dulce", 3.0);

        return chef.crearComida();
    }


    public String ordenarPizzaPersonalizada(String tipoMasa, double precioMasa,
                                            String tipoQueso, double precioQueso,
                                            String tipoTomate, double precioTomate,
                                            double cantidadTomate,
                                            String tipoPollo, double precioPollo,
                                            String tipoPiña, double precioPiña) {
        chef.agregarMasa(tipoMasa, precioMasa);
        chef.agregarQueso(tipoQueso, precioQueso);
        chef.agregarTomate(tipoTomate, precioTomate);
        chef.agregarSalsaTomate(tipoTomate, cantidadTomate);
        chef.agregarPollo(tipoPollo, precioPollo);
        chef.agregarPiña(tipoPiña, precioPiña);

        return chef.crearComida();
    }
}