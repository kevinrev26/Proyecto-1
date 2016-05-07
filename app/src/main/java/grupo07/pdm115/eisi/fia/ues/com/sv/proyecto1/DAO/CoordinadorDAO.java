package grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.DAO;

import android.content.Context;

/**
 * Creado por Kevin Rivera, 05-07-16.
 * Puede usar, modificar y compartir este archivo
 * Consultas y mas: kevinrev26@gmail.com
 */
public class CoordinadorDAO extends MasterDAO {


    //Constantes para la base de datos
    public static final String COORDINADOR_TABLE = "coordinador";
    public static final String IDENTIFICADOR_COORDINADOR = "id_coordinador";
    public static final String NOM_COORDINADOR = "nombre_coordinador";
    public static final String EMAIL_COORDINADOR = "email_coordiandor";
    public static final String TEL_COORDINADOR = "telefono_coordinador";

    public CoordinadorDAO(Context ctx) {
        super(ctx);
    }

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
