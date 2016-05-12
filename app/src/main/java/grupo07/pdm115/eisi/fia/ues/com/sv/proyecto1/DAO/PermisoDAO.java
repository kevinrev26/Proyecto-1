package grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.DAO;

import android.content.Context;

/**
 * Creado por Kevin Rivera, 05-12-16.
 * Puede usar, modificar y compartir este archivo
 * Consultas y mas: kevinrev26@gmail.com
 */
public class PermisoDAO extends MasterDAO {

    //Constantes
    public static final String PERMISO_TABLE = "permiso";
    public static final String ID_USUARIO = "id_usuario";
    public static final int ID_USUARIO_COL = 0;
    public static final String ID_OPCION = "id_opcion";
    public static final int ID_OPCION_COL = 1;

    public PermisoDAO(Context ctx) {
        super(ctx);
    }

    public static String crearTablaPermiso(){
        return "CREATE TABLE " + PERMISO_TABLE + " (" +
                ID_USUARIO + " INTEGER REFERENCES " + UsuarioDAO.USUARIO_TABLE + "("+UsuarioDAO.ID_USUARIO+") " +
                "ON DELETE CASCADE ON UPDATE CASCADE, " +
                ID_OPCION + " INTEGER REFERENCES " + OpcionDAO.OPCION_TABLE + "("+OpcionDAO.ID_OPCION+") " +
                "ON DELETE CASCADE ON UPDATE CASCADE, " +
                "PRIMARY KEY (" + ID_USUARIO + "," + ID_OPCION + ")" +
                ");";
    }


    public static String eliminarTablaPermiso(){
        return  "DROP TABLE IF EXISTS " + PERMISO_TABLE;
    }

}
