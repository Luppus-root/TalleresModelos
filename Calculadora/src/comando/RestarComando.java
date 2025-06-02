package comando;

public class RestarComando extends ComandoAbstracto {
    private final float valor;

    public RestarComando(float valor) { this.valor = valor; }
    public void ejecutar() { calculadora.restar(valor); }
}