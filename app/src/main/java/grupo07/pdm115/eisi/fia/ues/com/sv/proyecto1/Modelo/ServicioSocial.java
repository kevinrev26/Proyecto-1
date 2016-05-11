package grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Modelo;

/**
 * Created by Usuario on 08/05/2016.
 */
public class ServicioSocial {

    //Atributos

    private String idServicio;
    private String identificadorInstitucion;
    private String identificadorTutor;
    private String identificadorModalidad;
    private String titulo;
    private String descripcion;
    private int disponible;
    private String coordinadorAprobado;

    public ServicioSocial(String idServicio, String identificadorInstitucion, String identificadorTutor,
                          String identificadorModalidad, String titulo, String descripcion, int disponible, String coordinadorAprobado) {

        this.idServicio=idServicio;
        this.identificadorInstitucion=identificadorInstitucion;
        this.identificadorTutor=identificadorTutor;
        this.identificadorModalidad=identificadorModalidad;
        this.titulo=titulo;
        this.descripcion=descripcion;
        this.disponible=disponible;
        this.coordinadorAprobado=coordinadorAprobado;
    }


    public String getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(String idServicio) {
        this.idServicio = idServicio;
    }

    public String getIdentificadorInstitucion() {
        return identificadorInstitucion;
    }

    public void setIdentificadorInstitucion(String identificadorInstitucion) {
        this.identificadorInstitucion = identificadorInstitucion;
    }

    public String getIdentificadorTutor() {
        return identificadorTutor;
    }

    public void setIdentificadorTutor(String identificadorTutor) {
        this.identificadorTutor = identificadorTutor;
    }

    public String getIdentificadorModalidad() {
        return identificadorModalidad;
    }

    public void setIdentificadorModalidad(String identificadorModalidad) {
        this.identificadorModalidad = identificadorModalidad;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getDisponible() {
        return disponible;
    }

    public void setDisponible(int disponible) {
        this.disponible=disponible;
    }

    public String getCoordinadorAprobado() {
        return coordinadorAprobado;
    }

    public void setCoordinadorAprobado(String coordinadorAprobado) {
        this.coordinadorAprobado = coordinadorAprobado;
    }

    @Override
    public String toString() {
        return "ServicioSocial{" +
                "idServicio='" + idServicio + '\'' +
                ", identificadorInstitucion='" + identificadorInstitucion + '\'' +
                ", identificadorTutor='" + identificadorTutor + '\'' +
                ", identificadorModalidad='" + identificadorModalidad + '\'' +
                ", titulo='" + titulo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", disponible='" + disponible + '\'' +
                ", coordinadorAprobado='" + coordinadorAprobado + '\'' +
                '}';
    }
}
