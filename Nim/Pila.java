package Nim;

public class Pila {

 private int contadores = 5;

    public int getContadores() {
        return contadores;
    }

    public void reducirPila(int cantidad) {
        if (cantidad <= contadores && cantidad > 0) {
            contadores -= cantidad;
        } else {
            System.out.println("No se puede reducir esa cantidad");
        }
    }

    public boolean getEstado() {
        return contadores > 0;
    }
}
