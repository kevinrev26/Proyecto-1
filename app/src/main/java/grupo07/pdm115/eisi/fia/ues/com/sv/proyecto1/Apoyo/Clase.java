package grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Apoyo;

/**
 * Creado por Kevin Rivera, 05-01-16.
 * Puede usar, modificar y compartir este archivo
 * Consultas y mas: kevinrev26@gmail.com
 */
/*
* Esta clase sirve para especificar el titulo de la activity, asi como
* su descripcion; ¿Donde sera usado esto? Existe un layout custom para
* el list view.
*
*/


public class Clase {

    private String nombreClase;
    private String descripcionClase;

    public Clase(String descripcionClase, String nombreClase) {
        this.descripcionClase = descripcionClase;
        this.nombreClase = nombreClase;
    }

    public String getDescripcionClase() {
        return descripcionClase;
    }

    public void setDescripcionClase(String descripcionClase) {
        this.descripcionClase = descripcionClase;
    }

    public String getNombreClase() {
        return nombreClase;
    }

    public void setNombreClase(String nombreClase) {
        this.nombreClase = nombreClase;
    }
}

