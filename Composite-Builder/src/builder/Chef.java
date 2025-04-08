package builder;

public interface Chef {
    String crearComida();

    public void agregarPollo(String nombre, double precio);

    public void agregarPiña(String nombre, double precio);

    public void agregarMasa(String nombre, double precio);

    public void agregarQueso(String nombre, double precio);

    public void agregarTomate(String nombre, double precio);

    public void agregarSalsaTomate(String tomate, double cantidadTomate);
}