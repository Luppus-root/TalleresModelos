package core;

public class Calculadora {
    private float resultado = 0;

    public void sumar(float valor) { resultado += valor; }
    public void restar(float valor) { resultado -= valor; }
    public void multiplicar(float valor) { resultado *= valor; }
    public void dividir(float valor) { if (valor != 0) resultado /= valor; }
    public void borrar() { resultado = 0; }
    public Memento crearMemento() { return new Memento(resultado); }
    public void restaurar(Memento m) { this.resultado = m.obtenerEstado(); }
    public float getResultado() { return resultado; }
}