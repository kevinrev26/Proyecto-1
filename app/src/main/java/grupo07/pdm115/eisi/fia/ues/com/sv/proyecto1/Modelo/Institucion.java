package grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Modelo;

import java.io.Serializable;

/**
 * Created by Usuario on 09/05/2016.
 */
public class Institucion implements Serializable{

    //Atributos

    private int idInstitucion;
    private String nombreInstitucion;
    private String emailInstitucion;
    private String nombreEncargado;
    private String telefono1;
    private String telefono2;

    public Institucion(int idInstitucion, String nombreInstitucion, String emailInstitucion,
                          String nombreEncargado, String telefono1, String telefono2) {

        this.idInstitucion=idInstitucion;
        this.nombreInstitucion=nombreInstitucion;
        this.emailInstitucion=emailInstitucion;
        this.nombreEncargado=nombreEncargado;
        this.telefono1=telefono1;
        this.telefono2=telefono2;
    }

    public Institucion() {

    }

    public int getIdInstitucion() {
        return idInstitucion;
    }

    public void setIdInstitucion(int idInstitucion) {
        this.idInstitucion = idInstitucion;
    }

    public String getNombreInstitucion() {
        return nombreInstitucion;
    }

    public void setNombreInstitucion(String nombreInstitucion) {
        this.nombreInstitucion = nombreInstitucion;
    }

    public String getEmailInstitucion() {
        return emailInstitucion;
    }

    public void setEmailInstitucion(String emailInstitucion) {
        this.emailInstitucion = emailInstitucion;
    }

    public String getNombreEncargado() {
        return nombreEncargado;
    }

    public void setNombreEncargado(String nombreEncargado) {
        this.nombreEncargado = nombreEncargado;
    }

    public String getTelefono1() {
        return telefono1;
    }

    public void setTelefono1(String telefono1) {
        this.telefono1 = telefono1;
    }

    public String getTelefono2() {
        return telefono2;
    }

    public void setTelefono2(String telefono2) {
        this.telefono2 = telefono2;
    }

    @Override
    public String toString() {

        return "instituciones{" +
                "nombreInstitucion='" + nombreInstitucion+ '\'' +
                ", emailInstitucion='" + emailInstitucion + '\'' +
                ", nombreEncargado='" + nombreEncargado + '\'' +
                ", telefono1='" + telefono1 + '\'' +
                ", telefono2='" + telefono2 + '\'' +
                '}';
    }
}
