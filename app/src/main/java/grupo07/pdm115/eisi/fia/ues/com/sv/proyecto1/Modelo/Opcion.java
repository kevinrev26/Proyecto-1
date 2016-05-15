package grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Modelo;

/**
 * Creado por Kevin Rivera, 05-12-16.
 * Puede usar, modificar y compartir este archivo
 * Consultas y mas: kevinrev26@gmail.com
 */
public class Opcion {

   // private String idOpcion;
    private String DescripcionOpcion;
    private int token;

    public Opcion(int token, String descripcionOpcion) {
        this.token = token;
        DescripcionOpcion = descripcionOpcion;
    }

    public String getDescripcionOpcion() {
        return DescripcionOpcion;
    }

    public void setDescripcionOpcion(String descripcionOpcion) {
        DescripcionOpcion = descripcionOpcion;
    }

    public int getToken() {
        return token;
    }

    public void setToken(int token) {
        this.token = token;
    }
}
