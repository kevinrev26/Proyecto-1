package grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Modelo;

/**
 * Created by Gabriel on 07/05/2016.
 */
public class Bitacora
{
    //Atributos
    private String id_bitacora;
    private String fecha_inicio;
    private String fecha_fin;
    private String revision_coordinador; //Relacion con tabla coordinador
    private String revision_tutor;       //Relacion con la tabla tutor
    private String identificador_actividad;//Relacion con la tabla tipo de actividad
   // private String id_coordinador; //Relacion con tabla coordinador
    //private String id_tutor;       //Relacion con la tabla tutor
    //private String id_tipoActividad;//Relacion con la tabla tipo de actividad



    //getters and setters
    public String getId_bitacora() {
        return id_bitacora;
    }

    public void setId_bitacora(String id_bitacora) {
        this.id_bitacora = id_bitacora;
    }

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public String getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(String fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public String getRevision_coordinador() {
        return revision_coordinador;
    }

    public void setRevision_coordinador(String revision_coordinador) {
        this.revision_coordinador = revision_coordinador;
    }

    public String getRevision_tutor() {
        return revision_tutor;
    }

    public void setRevision_tutor(String revision_tutor) {
        this.revision_tutor = revision_tutor;
    }

    public String getIdentificador_actividad() {
        return identificador_actividad;
    }

    public void setIdentificador_actividad(String identificador_actividad) {
        this.identificador_actividad = identificador_actividad;
    }

    /*public String getId_coordinador() {
        return id_coordinador;
    }

    public void setId_coordinador(String id_coordinador) {
        this.id_coordinador = id_coordinador;
    }

    public String getId_tutor() {
        return id_tutor;
    }

    public void setId_tutor(String id_tutor) {
        this.id_tutor = id_tutor;
    }

    public String getId_tipoActividad() {
        return id_tipoActividad;
    }

    public void setId_tipoActividad(String id_tipoActividad) {
        this.id_tipoActividad = id_tipoActividad;
    }*/

    //to String

    @Override
    public String toString() {
        return "Bitacora{" +
                "id_bitacora='" + id_bitacora + '\'' +
                ", fecha_inicio='" + fecha_inicio + '\'' +
                ", fecha_fin='" + fecha_fin + '\'' +
                ", revision_coordinador='" + revision_coordinador + '\'' +
                ", revision_tutor='" + revision_tutor + '\'' +
                ", identificador_actividad='" + identificador_actividad + '\'' +
                /*", id_coordinador='" + id_coordinador + '\'' +
                ", id_tutor='" + id_tutor + '\'' +
                ", id_tipoActividad='" + id_tipoActividad + '\'' +*/
                '}';
    }
}
