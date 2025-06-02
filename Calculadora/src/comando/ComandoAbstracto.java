package comando;

import core.Calculadora;
import core.Memento;

public abstract class ComandoAbstracto implements Comando {
    protected Calculadora calculadora;
    protected Memento mementoAntes;
    protected Memento mementoDespues;

    public Memento getMementoAntes() { return mementoAntes; }
    public Memento getMementoDespues() { return mementoDespues; }
    public void setCalculadora(Calculadora c) { this.calculadora = c; }
    public void setMementoAntes(Memento m) { this.mementoAntes = m; }
    public void setMementoDespues(Memento m) { this.mementoDespues = m; }
}