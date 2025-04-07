package builder;

public abstract class Chef {
    public abstract String crearComida();

    public abstract void agregarPollo(String nombre, double precio);

    public abstract void agregarPiña(String nombre, double precio);

    public abstract void agregarMasa(String nombre, double precio);

    public abstract void agregarQueso(String nombre, double precio);

    public abstract void agregarTomate(String nombre, double precio);

    public abstract void agregarSalsaTomate(String tomate, double cantidadTomate);
}