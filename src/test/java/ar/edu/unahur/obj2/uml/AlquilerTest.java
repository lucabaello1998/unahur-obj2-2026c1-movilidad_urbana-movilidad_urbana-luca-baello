package ar.edu.unahur.obj2.uml;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class AlquilerTest {

    @Test
    void unAlquilerGuardaLosAtributosBasicos() {
        Usuario usuario = new Usuario("Maria");
        Vehiculo vehiculo = new Bicicleta(28);
        LocalDate fecha = LocalDate.of(2026, 4, 19);

        Alquiler alquiler = new Alquiler(usuario, vehiculo, fecha);

        assertEquals(usuario, alquiler.usuario());
        assertEquals(vehiculo, alquiler.vehiculo());
        assertEquals(fecha, alquiler.fechaInicio());
    }

    @Test
    void alCrearseUnAlquilerNoTieneFechaFin() {
        Usuario usuario = new Usuario("Carlos");
        Vehiculo vehiculo = new Monopatin("Venom");
        LocalDate fecha = LocalDate.of(2026, 4, 19);

        Alquiler alquiler = new Alquiler(usuario, vehiculo, fecha);

        assertNull(alquiler.fechaFin());
    }

    @Test
    void unAlquilerEstaActivoSiNoTieneFechaFin() {
        Usuario usuario = new Usuario("Ana");
        Vehiculo vehiculo = new Bicicleta(26);
        LocalDate fecha = LocalDate.of(2026, 4, 19);

        Alquiler alquiler = new Alquiler(usuario, vehiculo, fecha);

        assertTrue(alquiler.estaActivo());
    }

    @Test
    void unAlquilerPuedeFinalizar() {
        Usuario usuario = new Usuario("Luis");
        Vehiculo vehiculo = new Monopatin("Santa Cruz");
        LocalDate fechaInicio = LocalDate.of(2026, 4, 19);
        LocalDate fechaFin = LocalDate.of(2026, 4, 20);

        Alquiler alquiler = new Alquiler(usuario, vehiculo, fechaInicio);
        alquiler.finalizarAlquiler(fechaFin);

        assertEquals(fechaFin, alquiler.fechaFin());
        assertFalse(alquiler.estaActivo());
    }
}
