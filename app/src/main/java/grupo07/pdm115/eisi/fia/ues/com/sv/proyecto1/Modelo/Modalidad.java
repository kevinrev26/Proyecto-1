package grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Modelo;

/**
 * Created by Diego on 09/05/2016.
 */
public class Modalidad {

    private String idModalidad;
    private String nombre;

    public Modalidad(String idModalidad, String nombre) {
        this.idModalidad = idModalidad;
        this.nombre = nombre;
    }

    public String getIdModalidad() {
        return idModalidad;
    }

    public void setIdModalidad(String idModalidad) {
        this.idModalidad = idModalidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
