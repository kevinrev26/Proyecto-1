package grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Modelo;

import java.io.Serializable;

/**
 * Created by Gabriel on 07/05/2016.
 */
public class TipoDeActividad implements Serializable
{
    private String id_tipo_actividad;
    private String nombre_actividad;
    private int cantidad_horas;
    private String descripcion;

    public TipoDeActividad(String id_tipo_actividad, String nombre_actividad, int cantidad_horas, String descripcion) {
        this.id_tipo_actividad = id_tipo_actividad;
        this.nombre_actividad = nombre_actividad;
        this.cantidad_horas = cantidad_horas;
        this.descripcion = descripcion;
    }

    public String getId_tipo_actividad() {
        return id_tipo_actividad;
    }

    public void setId_tipo_actividad(String id_tipo_actividad) {
        this.id_tipo_actividad = id_tipo_actividad;
    }

    public String getNombre_actividad() {
        return nombre_actividad;
    }

    public void setNombre_actividad(String nombre_actividad) {
        this.nombre_actividad = nombre_actividad;
    }

    public int getCantidad_horas() {
        return cantidad_horas;
    }

    public void setCantidad_horas(int cantidad_horas) {
        this.cantidad_horas = cantidad_horas;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "TipoDeActividad{" +
                "id_tipo_actividad='" + id_tipo_actividad + '\'' +
                ", nombre_actividad='" + nombre_actividad + '\'' +
                ", cantidad_horas=" + cantidad_horas +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
