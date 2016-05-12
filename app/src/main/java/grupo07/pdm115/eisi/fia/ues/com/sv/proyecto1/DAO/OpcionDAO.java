package grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.DAO;

import android.content.Context;

/**
 * Creado por Kevin Rivera, 05-12-16.
 * Puede usar, modificar y compartir este archivo
 * Consultas y mas: kevinrev26@gmail.com
 */
public class OpcionDAO  extends MasterDAO{

    //Constantes para las tablas
    public static final String OPCION_TABLE = "opcion";
    public static final String ID_OPCION = "id_opcion";
    public static final int ID_OPCION_COL = 0;
    public static final String DESCRIPCION_OPCION = "desc_opcion";
    public static final int DESCRIPCION_OPCION_COL = 1;
    public static final String TOKEN = "token";
    public static final int TOKEN_COL = 2;

    public OpcionDAO(Context ctx) {
        super(ctx);
    }


    public static String crearTablaOpcion(){
        return "CREATE TABLE " + OPCION_TABLE + " (" +
                ID_OPCION + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                DESCRIPCION_OPCION + " TEXT, " +
                TOKEN + " TEXT NO NULL " +
                ");";
    }


    public static String eliminarTablaOpcion(){
        return  "DROP TABLE IF EXISTS " + OPCION_TABLE;
    }
}
