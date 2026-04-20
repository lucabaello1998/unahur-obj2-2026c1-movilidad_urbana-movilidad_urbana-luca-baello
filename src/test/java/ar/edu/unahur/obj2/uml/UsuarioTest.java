package ar.edu.unahur.obj2.uml;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UsuarioTest {

    @Test
    void unUsuarioGuardaSuNombre() {
        Usuario usuario = new Usuario("Juan");

        assertEquals("Juan", usuario.nombre());
    }
}
