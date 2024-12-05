package gestionsalasproyect;

import java.time.LocalDate;
import java.util.Objects;

public class Reserva {
    private Sala sala;
    private Usuario usuario;
    private LocalDate fecha;
    private String detalle;

    public Reserva(Sala sala, Usuario usuario, LocalDate fecha, String detalle) {
        this.sala = Objects.requireNonNull(sala, "La sala no puede ser null");
        this.usuario = Objects.requireNonNull(usuario, "El usuario no puede ser null");
        this.fecha = Objects.requireNonNull(fecha, "La fecha no puede ser null");
        this.detalle = Objects.requireNonNull(detalle, "El detalle no puede ser null");
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = Objects.requireNonNull(sala, "La sala no puede ser null");
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = Objects.requireNonNull(usuario, "El usuario no puede ser null");
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = Objects.requireNonNull(fecha, "La fecha no puede ser null");
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = Objects.requireNonNull(detalle, "El detalle no puede ser null");
    }

    public void mostrarInformacion() {
        System.out.println("Sala reservada:");
        sala.mostrarInformacion();
        System.out.println("Reservada por:");
        usuario.mostrarInformacion();
        System.out.println("Fecha: " + fecha);
        System.out.println("Detalle: " + detalle);
    }
}
