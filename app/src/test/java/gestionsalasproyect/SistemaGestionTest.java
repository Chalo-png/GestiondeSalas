package gestionsalasproyect;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

public class SistemaGestionTest {

    @Test
    public void testAgregarYBuscarSala() {
        SistemaGestion sistema = new SistemaGestion();
        Sala sala = new Sala("S001", "Sala A", "Piso 1");
        sistema.agregarSala(sala);
        Sala salaEncontrada = sistema.buscarSalaPorCodigo("S001");
        assertNotNull(salaEncontrada);
        assertEquals("Sala A", salaEncontrada.getNombre());
    }

    @Test
    public void testAgregarReserva() {
        SistemaGestion sistema = new SistemaGestion();
        Sala sala = new Sala("S001", "Sala A", "Piso 1");
        Usuario usuario = new Usuario("U001", "Juan Pérez", "Ventas", "Gerente de Ventas");
        sistema.agregarSala(sala);
        sistema.agregarUsuario(usuario);
        Reserva reserva = new Reserva(sala, usuario, LocalDate.now(), "Reunión de Ventas");
        sistema.agregarReserva(reserva);
        assertTrue(sala.isReservada());
    }

    @Test
    public void testUsuarioYaTieneReserva() {
        SistemaGestion sistema = new SistemaGestion();
        Sala sala1 = new Sala("S001", "Sala A", "Piso 1");
        Sala sala2 = new Sala("S002", "Sala B", "Piso 2");
        Usuario usuario = new Usuario("U001", "Juan Pérez", "Ventas", "Gerente de Ventas");
        sistema.agregarSala(sala1);
        sistema.agregarSala(sala2);
        sistema.agregarUsuario(usuario);
        Reserva reserva1 = new Reserva(sala1, usuario, LocalDate.now(), "Reunión 1");
        sistema.agregarReserva(reserva1);
        Reserva reserva2 = new Reserva(sala2, usuario, LocalDate.now(), "Reunión 2");
        sistema.agregarReserva(reserva2); 
    }

    @Test
    public void testActualizarReserva() {
        SistemaGestion sistema = new SistemaGestion();
        Sala sala = new Sala("S001", "Sala A", "Piso 1");
        Usuario usuario = new Usuario("U001", "Juan Pérez", "Ventas", "Gerente de Ventas");
        sistema.agregarSala(sala);
        sistema.agregarUsuario(usuario);
        Reserva reserva = new Reserva(sala, usuario, LocalDate.now(), "Reunión de Ventas");
        sistema.agregarReserva(reserva);

        Reserva reservaExistente = sistema.buscarReserva("S001", "U001", LocalDate.now());
        assertNotNull(reservaExistente);
        reservaExistente.setDetalle("Reunión de Estrategia");

        assertEquals("Reunión de Estrategia", reservaExistente.getDetalle());
    }

    @Test
    public void testEliminarReserva() {
        SistemaGestion sistema = new SistemaGestion();
        Sala sala = new Sala("S001", "Sala A", "Piso 1");
        Usuario usuario = new Usuario("U001", "Juan Pérez", "Ventas", "Gerente de Ventas");
        sistema.agregarSala(sala);
        sistema.agregarUsuario(usuario);
        Reserva reserva = new Reserva(sala, usuario, LocalDate.now(), "Reunión de Ventas");
        sistema.agregarReserva(reserva);

        boolean resultado = sistema.eliminarReserva("S001", "U001", LocalDate.now());
        assertTrue(resultado);
        assertFalse(sala.isReservada());
        assertNull(sistema.buscarReserva("S001", "U001", LocalDate.now()));
    }

}
