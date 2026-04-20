package ar.edu.unahur.obj2.uml;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MonopatinTest {

    @Test
    void unMonopatinGuardaSuMarca() {
        Monopatin monopatin = new Monopatin("Sector 9");

        assertEquals("Sector 9", monopatin.marca());
    }

    @Test
    void unMonopatinHeredaDisponibilidad() {
        Monopatin monopatin = new Monopatin("Santa Cruz");

        monopatin.marcarNoDisponible();

        assertEquals(false, monopatin.estaDisponible());
    }
}
