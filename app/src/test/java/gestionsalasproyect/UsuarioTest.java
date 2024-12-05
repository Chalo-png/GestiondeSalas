package gestionsalasproyect;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UsuarioTest {

    @Test
    public void testCrearUsuario() {
        Usuario usuario = new Usuario("U001", "Juan Pérez", "Ventas", "Gerente de Ventas");
        assertEquals("U001", usuario.getIdentificador());
        assertEquals("Juan Pérez", usuario.getNombre());
        assertEquals("Ventas", usuario.getDepartamento());
        assertEquals("Gerente de Ventas", usuario.getDescripcion());
    }

    @Test
    public void testActualizarUsuario() {
        Usuario usuario = new Usuario("U001", "Juan Pérez", "Ventas", "Gerente de Ventas");
        usuario.setNombre("Juan P.");
        usuario.setDepartamento("Marketing");
        assertEquals("Juan P.", usuario.getNombre());
        assertEquals("Marketing", usuario.getDepartamento());
    }

    @Test
    public void testEliminarUsuario() {
        SistemaGestion sistema = new SistemaGestion();
        Usuario usuario = new Usuario("U001", "Juan Pérez", "Ventas", "Gerente de Ventas");
        sistema.agregarUsuario(usuario);
        sistema.eliminarUsuario("U001");
        assertNull(sistema.buscarUsuarioPorId("U001"));
    }

}
