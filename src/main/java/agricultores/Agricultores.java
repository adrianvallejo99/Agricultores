package agricultores;

import java.util.ArrayList;
public class Agricultores {
    private ArrayList<Integer> lista;

    public Agricultores() {
        lista = new ArrayList<>();
    }

    public ArrayList<Integer> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Integer> lista) {
        this.lista = lista;
    }

    public boolean insertarElemento(Integer i) {
        if (i > 0) {
            lista.add(i);
            return true;
        } else {
            return false;
        }
    }

    public void mostrar() {
        System.out.println("Lista: " + lista);
    }

    @Override
    public String toString() {
        return "Agricultores{" +
                "lista=" + lista +
                '}';
    }
}
