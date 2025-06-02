package core;

import comando.*;

public class Cliente {
    private final GestorComandos gestor;
    private final Calculadora calculadora;

    public Cliente() {
        calculadora = new Calculadora();
        gestor = new GestorComandos(calculadora);
    }

    public void botonSumar(float valor) { gestor.ejecutar(new SumarComando(valor)); }
    public void botonRestar(float valor) { gestor.ejecutar(new RestarComando(valor)); }
    public void botonMultiplicar(float valor) { gestor.ejecutar(new MultiplicarComando(valor)); }
    public void botonDividir(float valor) { gestor.ejecutar(new DividirComando(valor)); }
    public void botonBorrar() { gestor.ejecutar(new BorrarComando()); }
    public void botonDeshacer() { gestor.deshacer(); }
    public void botonRehacer() { gestor.rehacer(); }
    public float getResultado() { return calculadora.getResultado(); }
}