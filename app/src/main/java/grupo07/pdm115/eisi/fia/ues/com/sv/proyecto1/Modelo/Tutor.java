package grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Modelo;

import java.io.Serializable;

/**
 * Created by Marvin on 07/05/2016.
 */
public class Tutor implements Serializable {
    private int idTutor;
    private String nombre;
    private String email;
    private String telefono;

    public Tutor(){
    }

    public Tutor(int idTutor, String nombre, String email, String telefono) {
        this.idTutor = idTutor;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
    }

    public int getIdTutor() {
        return idTutor;
    }

    public void setId_tutor(int id_tutor) {
        this.idTutor = idTutor;
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

    @Override
    public String toString() {
        return "Tutor{" +
                "idTutor=" + idTutor +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}
