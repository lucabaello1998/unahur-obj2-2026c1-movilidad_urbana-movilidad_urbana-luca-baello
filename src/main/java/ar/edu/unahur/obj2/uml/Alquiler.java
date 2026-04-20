package ar.edu.unahur.obj2.uml;

import java.time.LocalDate;

public class Alquiler {
    private final Usuario usuario;
    private final Vehiculo vehiculo;
    private final LocalDate fechaInicio;
    private LocalDate fechaFin;

    public Alquiler(Usuario usuario, Vehiculo vehiculo, LocalDate fechaInicio) {
        this.usuario = usuario;
        this.vehiculo = vehiculo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = null;
    }

    public Usuario usuario() {
        return this.usuario;
    }

    public Vehiculo vehiculo() {
        return this.vehiculo;
    }

    public LocalDate fechaInicio() {
        return this.fechaInicio;
    }

    public LocalDate fechaFin() {
        return this.fechaFin;
    }

    public void finalizarAlquiler(LocalDate fecha) {
        this.fechaFin = fecha;
    }

    public boolean estaActivo() {
        return this.fechaFin == null;
    }
}
