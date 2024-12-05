package gestionsalasproyect;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SistemaGestion {
    private List<Sala> salas;
    private List<Usuario> usuarios;
    private List<Reserva> reservas;

    public SistemaGestion() {
        salas = new ArrayList<>();
        usuarios = new ArrayList<>();
        reservas = new ArrayList<>();
    }

    public void agregarSala(Sala sala) {
        if (buscarSalaPorCodigo(sala.getCodigo()) == null) {
            salas.add(sala);
            System.out.println("Sala agregada exitosamente.");
        } else {
            System.out.println("Ya existe una sala con ese código.");
        }
    }

    public Sala buscarSalaPorCodigo(String codigo) {
        for (Sala sala : salas) {
            if (sala.getCodigo().equals(codigo)) {
                return sala;
            }
        }
        return null;
    }

    public void actualizarSala(Sala salaActualizada) {
        Sala sala = buscarSalaPorCodigo(salaActualizada.getCodigo());
        if (sala != null) {
            sala.setNombre(salaActualizada.getNombre());
            sala.setUbicacion(salaActualizada.getUbicacion());
            System.out.println("Sala actualizada correctamente.");
        } else {
            System.out.println("La sala no existe.");
        }
    }

    public void eliminarSala(String codigo) {
        Sala sala = buscarSalaPorCodigo(codigo);
        if (sala != null) {
            salas.remove(sala);
            System.out.println("Sala eliminada correctamente.");
        } else {
            System.out.println("La sala no existe.");
        }
    }

    public void listarSalas() {
        for (Sala sala : salas) {
            sala.mostrarInformacion();
            System.out.println("-------------------------");
        }
    }

    public void agregarUsuario(Usuario usuario) {
        if (buscarUsuarioPorId(usuario.getIdentificador()) == null) {
            usuarios.add(usuario);
            System.out.println("Usuario agregado exitosamente.");
        } else {
            System.out.println("Ya existe un usuario con ese identificador.");
        }
    }

    public Usuario buscarUsuarioPorId(String id) {
        for (Usuario usuario : usuarios) {
            if (usuario.getIdentificador().equals(id)) {
                return usuario;
            }
        }
        return null;
    }

    public void actualizarUsuario(Usuario usuarioActualizado) {
        Usuario usuario = buscarUsuarioPorId(usuarioActualizado.getIdentificador());
        if (usuario != null) {
            usuario.setNombre(usuarioActualizado.getNombre());
            usuario.setDepartamento(usuarioActualizado.getDepartamento());
            usuario.setDescripcion(usuarioActualizado.getDescripcion());
            System.out.println("Usuario actualizado correctamente.");
        } else {
            System.out.println("El usuario no existe.");
        }
    }

    public void eliminarUsuario(String id) {
        Usuario usuario = buscarUsuarioPorId(id);
        if (usuario != null) {
            usuarios.remove(usuario);
            System.out.println("Usuario eliminado correctamente.");
        } else {
            System.out.println("El usuario no existe.");
        }
    }

    public void listarUsuarios() {
        for (Usuario usuario : usuarios) {
            usuario.mostrarInformacion();
            System.out.println("-------------------------");
        }
    }

    public void agregarReserva(Reserva reserva) {
        if (reserva.getSala().isReservada()) {
            System.out.println("La sala ya está reservada.");
            return;
        }
        if (usuarioTieneReservaEnFecha(reserva.getUsuario(), reserva.getFecha())) {
            System.out.println("El usuario ya tiene una reserva en esa fecha.");
            return;
        }
        reservas.add(reserva);
        reserva.getSala().setReservada(true);
        System.out.println("Reserva agregada exitosamente.");
    }

    public boolean usuarioTieneReservaEnFecha(Usuario usuario, LocalDate fecha) {
        for (Reserva reserva : reservas) {
            if (reserva.getUsuario().equals(usuario) && reserva.getFecha().equals(fecha)) {
                return true;
            }
        }
        return false;
    }

    public void listarReservas() {
        for (Reserva reserva : reservas) {
            reserva.mostrarInformacion();
            System.out.println("-------------------------");
        }
    }

    public Reserva buscarReserva(String codigoSala, String idUsuario, LocalDate fecha) {
        for (Reserva reserva : reservas) {
            if (reserva.getSala().getCodigo().equals(codigoSala) &&
                reserva.getUsuario().getIdentificador().equals(idUsuario) &&
                reserva.getFecha().equals(fecha)) {
                return reserva;
            }
        }
        return null;
    }

    public boolean eliminarReserva(String codigoSala, String idUsuario, LocalDate fecha) {
        Reserva reserva = buscarReserva(codigoSala, idUsuario, fecha);
        if (reserva != null) {
            reserva.getSala().setReservada(false);
            reservas.remove(reserva);
            return true;
        }
        return false;
    }

}
