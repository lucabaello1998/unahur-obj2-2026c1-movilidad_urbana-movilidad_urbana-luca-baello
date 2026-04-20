package ar.edu.unahur.obj2.uml;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class VehiculoTest {

    @Test
    void unVehiculoAlCrearseEstaDisponible() {
        Vehiculo vehiculo = new Bicicleta(28);

        assertTrue(vehiculo.estaDisponible());
    }

    @Test
    void unVehiculoPuedeMarcarseNoDisponible() {
        Vehiculo vehiculo = new Monopatin("Santa Cruz");

        vehiculo.marcarNoDisponible();

        assertFalse(vehiculo.estaDisponible());
    }

    @Test
    void unVehiculoPuedeMarcarseDisponibleNuevamente() {
        Vehiculo vehiculo = new Bicicleta(28);
        vehiculo.marcarNoDisponible();

        vehiculo.marcarDisponible();

        assertTrue(vehiculo.estaDisponible());
    }
}
