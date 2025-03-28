public class Cliente {
    private final Entrada entrada;
    private final Salida salida;

    public Cliente(EntradaSalidaFabricaAbstracta factory) {
        this.entrada = factory.crearEntrada();
        this.salida = factory.crearSalida();
    }

    public void mostrarDatos() {

    }

}