package grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Modelo;

/**
 * Creado por Kevin Rivera, 05-06-16.
 * Puede usar, modificar y compartir este archivo
 * Consultas y mas: kevinrev26@gmail.com
 */
public class Coordinador {

    //Atributos
    private String id_coordinador;
    private String nombre;
    private String email;
    private String telefono;

    //Constantes para la base de datos
    public static final String COORDINADOR_TABLE = "coordinador";
    public static final String IDENTIFICADOR_COORDINADOR = "id_coordinador";
    public static final String NOM_COORDINADOR = "nombre_coordinador";
    public static final String EMAIL_COORDINADOR = "email_coordiandor";
    public static final String TEL_COORDINADOR = "telefono_coordinador";

    public Coordinador(String email, String id_coordinador, String nombre, String telefono) {
        this.email = email;
        this.id_coordinador = id_coordinador;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId_coordinador() {
        return id_coordinador;
    }

    public void setId_coordinador(String id_coordinador) {
        this.id_coordinador = id_coordinador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /*
    * El metodo crear tabla crea el string a usar en la base de datos para definir
    * la tabla Coordinador
    * */

    public static String crearTablaCoordinador(){
        return "CREATE TABLE " + COORDINADOR_TABLE + " (" +
                IDENTIFICADOR_COORDINADOR + " TEXT(5) NOT NULL, " +
                NOM_COORDINADOR + " TEXT(10) NOT NULL, " +
                EMAIL_COORDINADOR + " TEXT(25), " +
                TEL_COORDINADOR + " TEXT(8) NOT NULL, " +
                " PRIMARY KEY(" + IDENTIFICADOR_COORDINADOR + ") " +
                ");";
    }

    public static String eliminarTablaCoordinador(){
        return "DROP TABLE IF EXISTS " + COORDINADOR_TABLE;
    }

}
