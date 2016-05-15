package grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.DAO;

import android.content.Context;

/**
 * Creado por Kevin Rivera, 05-15-16.
 * Puede usar, modificar y compartir este archivo
 * Consultas y mas: kevinrev26@gmail.com
 */
public class SystemLogDAO extends MasterDAO{

    //Cosntantes
    public static final String SYSTEMLOG_TABLE = "system_log";
    public static final String IDENTIFICADOR_ENTIDAD = "id_entidad";
    public static final int ID_ENTIDAD_COL = 0;
    public static final String NOMBRE_ENTIDAD = "nombre_entidad";
    public static final int NOM_ENTRY_DATE_COL = 1;


    public SystemLogDAO(Context ctx) {
        super(ctx);
    }


    public static String crearTablaSystemLog(){
        return "CREATE TABLE " + SYSTEMLOG_TABLE + " (" +
                IDENTIFICADOR_ENTIDAD + " INTEGER, " +
                NOMBRE_ENTIDAD + " TEXT NO NULL "+
                ");";
    }

    public static String eliminarTablaSystemLog(){
        return "DROP TABLE IF EXISTS " + SYSTEMLOG_TABLE;
    }


}
