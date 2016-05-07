package grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Modelo;

/**
 * Creado por Kevin Rivera, 05-06-16.
 * Puede usar, modificar y compartir este archivo
 * Consultas y mas: kevinrev26@gmail.com
 */
public class Estudiante {

    //Atributos
    private String carnet;
    private String nombre;
    private String email;
    private String telefono;
    private String carrera;


    //Constantes para las tablas
    public static final String ESTUDIANTE_TABLE = "estudiante";
    public static final String CARNET = "carnet_estudiante";
    public static final String NOMBRE = "nombre_estudiante";
    public static final String EMAIL = "email_estudiante";
    public static final String TELEFONO = "telefono_estudiante";
    public static final String CARRERA = "CARRERA";

    public Estudiante(String carnet, String carrera, String email, String telefono, String nombre) {
        this.carnet = carnet;
        this.carrera = carrera;
        this.email = email;
        this.telefono = telefono;
        this.nombre = nombre;
    }

    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
    * Con este metodo se construye el String para la creacion de la tabla
    */
    public static String crearTablaEstudiante(){
        return "CREATE TABLE " + ESTUDIANTE_TABLE + " (" +
                CARNET + " TEXT(7) NOT NULL, " +
                NOMBRE + " TEXT(20) NOT NULL, " +
                EMAIL  + " TEXT(25) NOT NULL, " +
                TELEFONO + " TEXT(8), " +
                CARRERA +  " TEXT(20), " +
                "PRIMARY KEY(" + CARNET +") " +
                ");";
    }

    public static String eliminarTablaEstudiante(){
        return  "DROP TABLE IF EXISTS " + ESTUDIANTE_TABLE;
    }
}
