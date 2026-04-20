package ar.edu.unahur.obj2.uml;

public class Bicicleta extends Vehiculo {
    private final int rodado;

    public Bicicleta(int rodado) {
        super();
        this.rodado = rodado;
    }

    public int rodado() {
        return this.rodado;
    }
}
