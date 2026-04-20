package ar.edu.unahur.obj2.uml;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BicicletaTest {

    @Test
    void unaBicicletaGuardaSuRodado() {
        Bicicleta bicicleta = new Bicicleta(28);

        assertEquals(28, bicicleta.rodado());
    }

    @Test
    void unaBicicletaHeredaDisponibilidad() {
        Bicicleta bicicleta = new Bicicleta(26);

        bicicleta.marcarNoDisponible();

        assertEquals(false, bicicleta.estaDisponible());
    }
}
