package grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Modelo;

import java.io.Serializable;

/**
 * Created by Diego on 09/05/2016.
 */
public class Modalidad implements Serializable {

    private int idModalidad;
    private String nombre;

    public Modalidad() {
    }

    public Modalidad(int idModalidad, String nombre) {
        this.idModalidad = idModalidad;
        this.nombre = nombre;
    }

    public int getIdModalidad() {
        return idModalidad;
    }

    public void setIdModalidad(int idModalidad) {
        this.idModalidad = idModalidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String toString() {
        return
                "Nombre: " + nombre;
    }
}
