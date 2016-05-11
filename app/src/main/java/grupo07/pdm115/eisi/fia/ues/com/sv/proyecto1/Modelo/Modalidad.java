package grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Modelo;

/**
 * Created by Diego on 09/05/2016.
 */
public class Modalidad {

    private int id_modalidad;
    private String nombre;

    public Modalidad(int id_modalidad, String nombre) {
        this.id_modalidad = id_modalidad;
        this.nombre = nombre;
    }

    public int getId_modalidad() {
        return id_modalidad;
    }

    public void setId_modalidad(int id_modalidad) {
        this.id_modalidad = id_modalidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
