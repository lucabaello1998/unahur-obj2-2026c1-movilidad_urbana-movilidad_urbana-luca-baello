package ar.edu.unahur.obj2.uml;

import java.time.LocalDate;

public class Usuario {
    private final String nombre;

    public Usuario(String nombre) {
        this.nombre = nombre;
    }

    public String nombre() {
        return this.nombre;
    }
}
