package core;

import comando.Comando;

import java.util.Stack;

public class GestorComandos {
    private final Calculadora calculadora;
    private final Stack<Memento> historialDeshacer = new Stack<>();
    private final Stack<Memento> historialRehacer = new Stack<>();

    public GestorComandos(Calculadora calculadora) {
        this.calculadora = calculadora;
    }

    public void ejecutar(Comando comando) {
        comando.setCalculadora(calculadora);
        comando.setMementoAntes(calculadora.crearMemento());
        comando.ejecutar();
        comando.setMementoDespues(calculadora.crearMemento());
        historialDeshacer.push(comando.getMementoAntes());
        historialRehacer.clear();
    }

    public void deshacer() {
        if (!historialDeshacer.isEmpty()) {
            Memento m = historialDeshacer.pop();
            historialRehacer.push(calculadora.crearMemento());
            calculadora.restaurar(m);
        }
    }

    public void rehacer() {
        if (!historialRehacer.isEmpty()) {
            Memento m = historialRehacer.pop();
            historialDeshacer.push(calculadora.crearMemento());
            calculadora.restaurar(m);
        }
    }
}