package ar.edu.unahur.obj2.uml;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SistemaMovilidadUrbanaTest {

    @Test
    void sistemaPuedeRegistrarVehiculos() {
        SistemaMovilidadUrbana sistema = new SistemaMovilidadUrbana();
        Vehiculo bicicleta = new Bicicleta(28);
        Vehiculo monopatin = new Monopatin("Venom");

        sistema.registrarVehiculo(bicicleta);
        sistema.registrarVehiculo(monopatin);

        assertEquals(2, sistema.vehiculosDisponibles().size());
    }

    @Test
    void sistemaConsultaVehiculosDisponibles() {
        SistemaMovilidadUrbana sistema = new SistemaMovilidadUrbana();
        Bicicleta bicicleta1 = new Bicicleta(28);
        Bicicleta bicicleta2 = new Bicicleta(26);
        Monopatin monopatin = new Monopatin("Sector 9");

        sistema.registrarVehiculo(bicicleta1);
        sistema.registrarVehiculo(bicicleta2);
        sistema.registrarVehiculo(monopatin);

        bicicleta2.marcarNoDisponible();

        List<Vehiculo> disponibles = sistema.vehiculosDisponibles();
        assertEquals(2, disponibles.size());
        assertTrue(disponibles.contains(bicicleta1));
        assertFalse(disponibles.contains(bicicleta2));
        assertTrue(disponibles.contains(monopatin));
    }

    @Test
    void sistemaAlquilaUnVehiculoDisponible() {
        SistemaMovilidadUrbana sistema = new SistemaMovilidadUrbana();
        Usuario usuario = new Usuario("Juan");
        Vehiculo vehiculo = new Bicicleta(28);
        LocalDate fecha = LocalDate.of(2026, 4, 19);

        sistema.registrarVehiculo(vehiculo);
        Alquiler alquiler = sistema.alquilarVehiculo(usuario, vehiculo, fecha);

        assertEquals(usuario, alquiler.usuario());
        assertEquals(vehiculo, alquiler.vehiculo());
        assertFalse(vehiculo.estaDisponible());
    }

    @Test
    void sistemaNoAlquilaUnVehiculoNoDisponible() {
        SistemaMovilidadUrbana sistema = new SistemaMovilidadUrbana();
        Usuario usuario = new Usuario("Maria");
        Vehiculo vehiculo = new Monopatin("Santa Cruz");
        LocalDate fecha = LocalDate.of(2026, 4, 19);

        vehiculo.marcarNoDisponible();
        sistema.registrarVehiculo(vehiculo);

        assertThrows(RuntimeException.class,
                () -> sistema.alquilarVehiculo(usuario, vehiculo, fecha));
    }

    @Test
    void sistemaRegistraAlquileres() {
        SistemaMovilidadUrbana sistema = new SistemaMovilidadUrbana();
        Usuario usuario1 = new Usuario("Carlos");
        Usuario usuario2 = new Usuario("Ana");
        Vehiculo vehiculo1 = new Bicicleta(28);
        Vehiculo vehiculo2 = new Monopatin("Venom");
        LocalDate fecha = LocalDate.of(2026, 4, 19);

        sistema.registrarVehiculo(vehiculo1);
        sistema.registrarVehiculo(vehiculo2);

        Alquiler alquiler1 = sistema.alquilarVehiculo(usuario1, vehiculo1, fecha);
        Alquiler alquiler2 = sistema.alquilarVehiculo(usuario2, vehiculo2, fecha);

        List<Alquiler> alquileres = sistema.alquileres();
        assertEquals(2, alquileres.size());
        assertTrue(alquileres.contains(alquiler1));
        assertTrue(alquileres.contains(alquiler2));
    }

    @Test
    void sistemaConsultaAlquileresDelUsuario() {
        SistemaMovilidadUrbana sistema = new SistemaMovilidadUrbana();
        Usuario usuario1 = new Usuario("Luis");
        Usuario usuario2 = new Usuario("Paula");
        Vehiculo vehiculo1 = new Bicicleta(28);
        Vehiculo vehiculo2 = new Monopatin("Santa Cruz");
        Vehiculo vehiculo3 = new Bicicleta(26);
        LocalDate fecha = LocalDate.of(2026, 4, 19);

        sistema.registrarVehiculo(vehiculo1);
        sistema.registrarVehiculo(vehiculo2);
        sistema.registrarVehiculo(vehiculo3);

        Alquiler alquiler1 = sistema.alquilarVehiculo(usuario1, vehiculo1, fecha);
        Alquiler alquiler2 = sistema.alquilarVehiculo(usuario2, vehiculo2, fecha);
        Alquiler alquiler3 = sistema.alquilarVehiculo(usuario1, vehiculo3, fecha);

        List<Alquiler> alquileresUsuario1 = sistema.alquileresDelUsuario(usuario1);
        assertEquals(2, alquileresUsuario1.size());
        assertTrue(alquileresUsuario1.contains(alquiler1));
        assertTrue(alquileresUsuario1.contains(alquiler3));
        assertFalse(alquileresUsuario1.contains(alquiler2));
    }

    @Test
    void sistemaPuedeDevolverUnVehiculo() {
        SistemaMovilidadUrbana sistema = new SistemaMovilidadUrbana();
        Usuario usuario = new Usuario("Roberto");
        Vehiculo vehiculo = new Bicicleta(28);
        LocalDate fechaInicio = LocalDate.of(2026, 4, 19);
        LocalDate fechaFin = LocalDate.of(2026, 4, 20);

        sistema.registrarVehiculo(vehiculo);
        Alquiler alquiler = sistema.alquilarVehiculo(usuario, vehiculo, fechaInicio);

        sistema.devolverVehiculo(alquiler, fechaFin);

        assertFalse(alquiler.estaActivo());
        assertEquals(fechaFin, alquiler.fechaFin());
        assertTrue(vehiculo.estaDisponible());
    }

    @Test
    void sistemaNoDevuelveUnAlquilerYaFinalizado() {
        SistemaMovilidadUrbana sistema = new SistemaMovilidadUrbana();
        Usuario usuario = new Usuario("Sofia");
        Vehiculo vehiculo = new Monopatin("Sector 9");
        LocalDate fechaInicio = LocalDate.of(2026, 4, 19);
        LocalDate fechaFin1 = LocalDate.of(2026, 4, 20);
        LocalDate fechaFin2 = LocalDate.of(2026, 4, 21);

        sistema.registrarVehiculo(vehiculo);
        Alquiler alquiler = sistema.alquilarVehiculo(usuario, vehiculo, fechaInicio);

        sistema.devolverVehiculo(alquiler, fechaFin1);

        assertThrows(RuntimeException.class,
                () -> sistema.devolverVehiculo(alquiler, fechaFin2));
    }
}
