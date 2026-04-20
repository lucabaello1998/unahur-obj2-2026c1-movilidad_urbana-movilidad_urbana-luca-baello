package ar.edu.unahur.obj2.uml;

public abstract class Vehiculo {
    private boolean disponible;

    protected Vehiculo() {
        this.disponible = true;
    }

    public boolean estaDisponible() {
        return this.disponible;
    }

    public void marcarDisponible() {
        this.disponible = true;
    }

    public void marcarNoDisponible() {
        this.disponible = false;
    }
}
