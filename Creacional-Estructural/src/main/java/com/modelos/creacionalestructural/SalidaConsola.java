public class SalidaConsola implements Salida{

    @Override
    public void mostrar(String mensaje) {
        System.out.println(mensaje);
    }
}
