public class EntradaSalidaFabricaAbstractaConsola implements EntradaSalidaFabricaAbstracta{
    @Override
    public Entrada crearEntrada() {
        return new EntradaConsola();
    }

    @Override
    public Salida crearSalida() {
        return new SalidaConsola();
    }
}
