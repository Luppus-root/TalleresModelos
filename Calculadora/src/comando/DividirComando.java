package comando;

public class DividirComando extends ComandoAbstracto {
    private final float valor;

    public DividirComando(float valor) { this.valor = valor; }
    public void ejecutar() { calculadora.dividir(valor); }
}