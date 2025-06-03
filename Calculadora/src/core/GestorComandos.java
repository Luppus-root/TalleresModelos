package core;

import comando.Comando;
import java.util.Stack;

public class GestorComandos {
    private final Calculadora calculadora;
    private final Stack<Comando> historialDeshacer = new Stack<>();
    private final Stack<Comando> historialRehacer = new Stack<>();

    public GestorComandos(Calculadora calculadora) {
        this.calculadora = calculadora;
    }

    public void ejecutar(Comando comando) {
        // Configurar el comando
        comando.setCalculadora(calculadora);

        // Guardar estado antes de ejecutar
        comando.setMementoAntes(calculadora.crearMemento());

        // Ejecutar el comando
        comando.ejecutar();

        // Guardar estado después de ejecutar
        comando.setMementoDespues(calculadora.crearMemento());

        // Agregar al historial de deshacer
        historialDeshacer.push(comando);

        // Limpiar historial de rehacer
        historialRehacer.clear();
    }

    public void deshacer() {
        if (!historialDeshacer.isEmpty()) {
            Comando comando = historialDeshacer.pop();

            // Restaurar al estado anterior
            calculadora.restaurar(comando.getMementoAntes());

            // Mover al historial de rehacer
            historialRehacer.push(comando);
        }
    }

    public void rehacer() {
        if (!historialRehacer.isEmpty()) {
            Comando comando = historialRehacer.pop();

            // Restaurar al estado posterior
            calculadora.restaurar(comando.getMementoDespues());

            // Mover de vuelta al historial de deshacer
            historialDeshacer.push(comando);
        }
    }
}
