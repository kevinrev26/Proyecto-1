package grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Modelo;

/**
 * Creado por Kevin Rivera, 05-06-16.
 * Puede usar, modificar y compartir este archivo
 * Consultas y mas: kevinrev26@gmail.com
 */
public class Coordinador {

    //Atributos
    private int id_coordinador;
    private String nombre;
    private String email;
    private String telefono;


    public Coordinador(String email, int id_coordinador, String nombre, String telefono) {
        this.email = email;
        this.id_coordinador = id_coordinador;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId_coordinador() {
        return id_coordinador;
    }

    public void setId_coordinador(int id_coordinador) {
        this.id_coordinador = id_coordinador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre +
                ", telefono: " + telefono;
    }
}
