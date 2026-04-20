package ar.edu.unahur.obj2.uml;

public class Monopatin extends Vehiculo {
    private final String marca;

    public Monopatin(String marca) {
        super();
        this.marca = marca;
    }

    public String marca() {
        return this.marca;
    }
}
