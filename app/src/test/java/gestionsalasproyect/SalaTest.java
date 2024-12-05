package gestionsalasproyect;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SalaTest {

    @Test
    public void testCrearSala() {
        Sala sala = new Sala("S001", "Sala de Conferencias", "Piso 1");
        assertEquals("S001", sala.getCodigo());
        assertEquals("Sala de Conferencias", sala.getNombre());
        assertEquals("Piso 1", sala.getUbicacion());
        assertFalse(sala.isReservada());
    }

    @Test
    public void testActualizarSala() {
        Sala sala = new Sala("S001", "Sala de Conferencias", "Piso 1");
        sala.setNombre("Sala de Reuniones");
        sala.setUbicacion("Piso 2");
        assertEquals("Sala de Reuniones", sala.getNombre());
        assertEquals("Piso 2", sala.getUbicacion());
    }

    @Test
    public void testLeerDatosSala() {
        Sala sala = new Sala("S001", "Sala de Conferencias", "Piso 1");
        assertEquals("S001", sala.getCodigo());
        assertEquals("Sala de Conferencias", sala.getNombre());
        assertEquals("Piso 1", sala.getUbicacion());
    }

    @Test
    public void testActualizarSalaInexistente() {
        SistemaGestion sistema = new SistemaGestion();
        Sala salaActualizada = new Sala("S999", "Sala Fantasma", "Sótano");
        sistema.actualizarSala(salaActualizada);
        assertNull(sistema.buscarSalaPorCodigo("S999"));
    }


}
