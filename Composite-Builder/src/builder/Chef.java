package builder;

public interface Chef {
    public void crearComida();

    public void agregarMasa(String nombre, double precio);

    public void agregarQueso(String nombre, double precio);

    public void agregarTomate(String nombre, double precio);

    public void agregarSalsaTomate(String tomate, double cantidadTomate);

    public Object finalizarComida();

    public void agregarPiña(String nombrePiña, double precioPiña);

    public void agregarPollo(String nombrePollo, double precioPollo);
}