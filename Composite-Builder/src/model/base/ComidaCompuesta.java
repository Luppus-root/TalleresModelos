package model.base;

public class ComidaCompuesta extends Comida {

    protected Comida[] children;

    public ComidaCompuesta() {
        this.children = new Comida[0];
    }

    @Override
    public String getDescripcion() {
        StringBuilder descripcion = new StringBuilder();
        for (Comida child : children) {
            descripcion.append(child.getDescripcion()).append(", ");
        }

        if (children.length > 0) {
            descripcion.delete(descripcion.length() - 2, descripcion.length());
        }

        return descripcion.toString();
    }

    public void agregar(Comida comida) {
        Comida[] newChildren = new Comida[children.length + 1];
        System.arraycopy(children, 0, newChildren, 0, children.length);
        newChildren[children.length] = comida;
        children = newChildren;
    }

    public void eliminar(Comida comida) {
        int indexToRemove = -1;
        for (int i = 0; i < children.length; i++) {
            if (children[i].equals(comida)) {
                indexToRemove = i;
                break;
            }
        }

        if (indexToRemove != -1) {
            Comida[] newChildren = new Comida[children.length - 1];
            System.arraycopy(children, 0, newChildren, 0, indexToRemove);
            System.arraycopy(children, indexToRemove + 1, newChildren, indexToRemove, children.length - indexToRemove - 1);
            children = newChildren;
        }
    }
}