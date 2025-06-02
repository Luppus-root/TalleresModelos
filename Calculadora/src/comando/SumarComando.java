package comando;

public class SumarComando extends ComandoAbstracto {
    private final float valor;

    public SumarComando(float valor) { this.valor = valor; }
    public void ejecutar() { calculadora.sumar(valor); }
}