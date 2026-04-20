package ar.edu.unahur.obj2.uml;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SistemaMovilidadUrbana {
    private final List<Vehiculo> vehiculos;
    private final List<Alquiler> alquileres;

    public SistemaMovilidadUrbana() {
        this.vehiculos = new ArrayList<>();
        this.alquileres = new ArrayList<>();
    }

    public void registrarVehiculo(Vehiculo vehiculo) {
        this.vehiculos.add(vehiculo);
    }

    public List<Vehiculo> vehiculosDisponibles() {
        return this.vehiculos.stream()
                .filter(Vehiculo::estaDisponible)
                .toList();
    }

    public Alquiler alquilarVehiculo(Usuario usuario, Vehiculo vehiculo, LocalDate fechaInicio) {
        if (!vehiculo.estaDisponible()) {
            throw new RuntimeException("El vehículo no está disponible");
        }
        
        Alquiler alquiler = new Alquiler(usuario, vehiculo, fechaInicio);
        vehiculo.marcarNoDisponible();
        this.alquileres.add(alquiler);
        
        return alquiler;
    }

    public void devolverVehiculo(Alquiler alquiler, LocalDate fechaFin) {
        if (!alquiler.estaActivo()) {
            throw new RuntimeException("El alquiler ya ha sido finalizado");
        }
        
        alquiler.finalizarAlquiler(fechaFin);
        alquiler.vehiculo().marcarDisponible();
    }

    public List<Alquiler> alquileres() {
        return new ArrayList<>(this.alquileres);
    }

    public List<Alquiler> alquileresDelUsuario(Usuario usuario) {
        return this.alquileres.stream()
                .filter(a -> a.usuario().equals(usuario))
                .toList();
    }
}
