package comando;

import core.Calculadora;
import core.Memento;

public interface Comando {
    void ejecutar();
    Memento getMementoAntes();
    Memento getMementoDespues();
    void setCalculadora(Calculadora calculadora);
    void setMementoAntes(Memento m);
    void setMementoDespues(Memento m);
}
