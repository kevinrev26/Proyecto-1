package grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Modelo;

/**
 * Created by Usuario on 08/05/2016.
 */
public class ServicioSocial {

    //Atributos

    private int idServicio;
    private int identificadorInstitucion;
    private int identificadorTutor;
    private int identificadorModalidad;
    private String titulo;
    private String descripcion;
    private int disponible;
    private int coordinadorAprobado;

    public ServicioSocial(int identificadorInstitucion, int identificadorTutor,
                          int identificadorModalidad, String titulo, String descripcion, int disponible, int coordinadorAprobado) {

        this.identificadorInstitucion=identificadorInstitucion;
        this.identificadorTutor=identificadorTutor;
        this.identificadorModalidad=identificadorModalidad;
        this.titulo=titulo;
        this.descripcion=descripcion;
        this.disponible=disponible;
        this.coordinadorAprobado=coordinadorAprobado;
    }

    public ServicioSocial(){}

    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    public int getIdentificadorInstitucion() {
        return identificadorInstitucion;
    }

    public void setIdentificadorInstitucion(int identificadorInstitucion) {
        this.identificadorInstitucion = identificadorInstitucion;
    }

    public int getIdentificadorTutor() {
        return identificadorTutor;
    }

    public void setIdentificadorTutor(int identificadorTutor) {
        this.identificadorTutor = identificadorTutor;
    }

    public int getIdentificadorModalidad() {
        return identificadorModalidad;
    }

    public void setIdentificadorModalidad(int identificadorModalidad) {
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

    public int getCoordinadorAprobado() {
        return coordinadorAprobado;
    }

    public void setCoordinadorAprobado(int coordinadorAprobado) {
        this.coordinadorAprobado = coordinadorAprobado;
    }

    @Override
    public String toString() {
        return "ServicioSocial{" +
                "idServicio=" + idServicio +
                ", identificadorInstitucion=" + identificadorInstitucion +
                ", identificadorTutor=" + identificadorTutor +
                ", identificadorModalidad=" + identificadorModalidad +
                ", titulo='" + titulo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", disponible='" + disponible + '\'' +
                ", coordinadorAprobado=" + coordinadorAprobado +
                '}';
    }
}
