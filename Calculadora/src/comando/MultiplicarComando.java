package comando;

public class MultiplicarComando extends ComandoAbstracto {
    private final float valor;

    public MultiplicarComando(float valor) { this.valor = valor; }
    public void ejecutar() { calculadora.multiplicar(valor); }
}