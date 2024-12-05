package gestionsalasproyect;

public class Usuario {
    private String identificador;
    private String nombre;
    private String departamento;
    private String descripcion;

    public Usuario(String identificador, String nombre, String departamento, String descripcion) {
        this.identificador = identificador;
        this.nombre = nombre;
        this.departamento = departamento;
        this.descripcion = descripcion;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public void mostrarInformacion() {
        System.out.println("ID: " + identificador);
        System.out.println("Nombre: " + nombre);
        System.out.println("Departamento: " + departamento);
        System.out.println("Descripción: " + descripcion);
    }
}
