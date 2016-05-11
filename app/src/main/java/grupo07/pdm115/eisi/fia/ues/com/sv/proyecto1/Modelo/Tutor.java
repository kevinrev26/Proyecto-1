package grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Modelo;

/**
 * Created by Marvin on 07/05/2016.
 */
public class Tutor {
    private int id_tutor;
    private String nombre;
    private String email;
    private String telefono;

    public Tutor(int id_tutor, String nombre, String email, String telefono) {
        this.id_tutor = id_tutor;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
    }

    public int getId_tutor() {
        return id_tutor;
    }

    public void setId_tutor(int id_tutor) {
        this.id_tutor = id_tutor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
