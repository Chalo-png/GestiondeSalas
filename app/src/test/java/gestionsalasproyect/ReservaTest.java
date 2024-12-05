package gestionsalasproyect;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

public class ReservaTest {

    @Test
    public void testCrearReserva() {
        Sala sala = new Sala("S001", "Sala A", "Piso 1");
        Usuario usuario = new Usuario("U001", "Juan Pérez", "Ventas", "Gerente de Ventas");
        LocalDate fecha = LocalDate.now();
        String detalle = "Reunión de estrategia";

        Reserva reserva = new Reserva(sala, usuario, fecha, detalle);

        assertEquals(sala, reserva.getSala());
        assertEquals(usuario, reserva.getUsuario());
        assertEquals(fecha, reserva.getFecha());
        assertEquals(detalle, reserva.getDetalle());
    }

    @Test
    public void testActualizarReserva() {
        Sala sala = new Sala("S001", "Sala A", "Piso 1");
        Usuario usuario = new Usuario("U001", "Juan Pérez", "Ventas", "Gerente de Ventas");
        LocalDate fechaInicial = LocalDate.now();
        String detalleInicial = "Reunión inicial";

        Reserva reserva = new Reserva(sala, usuario, fechaInicial, detalleInicial);

        LocalDate nuevaFecha = fechaInicial.plusDays(1);
        String nuevoDetalle = "Reunión reprogramada";

        reserva.setFecha(nuevaFecha);
        reserva.setDetalle(nuevoDetalle);

        assertEquals(nuevaFecha, reserva.getFecha());
        assertEquals(nuevoDetalle, reserva.getDetalle());
    }

    @Test
    public void testCambiarSalaYUsuario() {
        Sala sala1 = new Sala("S001", "Sala A", "Piso 1");
        Sala sala2 = new Sala("S002", "Sala B", "Piso 2");
        Usuario usuario1 = new Usuario("U001", "Juan Pérez", "Ventas", "Gerente de Ventas");
        Usuario usuario2 = new Usuario("U002", "María Gómez", "Marketing", "Directora de Marketing");
        LocalDate fecha = LocalDate.now();
        String detalle = "Reunión conjunta";

        Reserva reserva = new Reserva(sala1, usuario1, fecha, detalle);

        reserva.setSala(sala2);
        reserva.setUsuario(usuario2);

        assertEquals(sala2, reserva.getSala());
        assertEquals(usuario2, reserva.getUsuario());
    }

    @Test
    public void testReservaConDatosNulos() {
        Exception exception = assertThrows(NullPointerException.class, () -> {
            new Reserva(null, null, null, null);
        });
        assertNotNull(exception);
    }

    @Test
    public void testNoPermitirReservaSalaYaReservada() {
        Sala sala = new Sala("S001", "Sala A", "Piso 1");
        Usuario usuario1 = new Usuario("U001", "Juan Pérez", "Ventas", "Gerente de Ventas");
        Usuario usuario2 = new Usuario("U002", "María Gómez", "Marketing", "Directora de Marketing");
        LocalDate fecha = LocalDate.now();

        Reserva reserva1 = new Reserva(sala, usuario1, fecha, "Reunión de Ventas");
        SistemaGestion sistema = new SistemaGestion();
        sistema.agregarSala(sala);
        sistema.agregarUsuario(usuario1);
        sistema.agregarUsuario(usuario2);
        sistema.agregarReserva(reserva1);

        Reserva reserva2 = new Reserva(sala, usuario2, fecha, "Reunión de Marketing");
        sistema.agregarReserva(reserva2); 

        assertTrue(sistema.usuarioTieneReservaEnFecha(usuario2, fecha) == false);
    }

    @Test
    public void testNoPermitirReservaUsuarioMismaFecha() {
        Sala sala1 = new Sala("S001", "Sala A", "Piso 1");
        Sala sala2 = new Sala("S002", "Sala B", "Piso 2");
        Usuario usuario = new Usuario("U001", "Juan Pérez", "Ventas", "Gerente de Ventas");
        LocalDate fecha = LocalDate.now();

        Reserva reserva1 = new Reserva(sala1, usuario, fecha, "Reunión 1");
        Reserva reserva2 = new Reserva(sala2, usuario, fecha, "Reunión 2");

        SistemaGestion sistema = new SistemaGestion();
        sistema.agregarSala(sala1);
        sistema.agregarSala(sala2);
        sistema.agregarUsuario(usuario);
        sistema.agregarReserva(reserva1);

        
        sistema.agregarReserva(reserva2); 

        assertFalse(sala2.isReservada());
        assertFalse(sistema.usuarioTieneReservaEnFecha(usuario, fecha) && sistema.buscarReserva("S002", "U001", fecha) != null);
    }

}
