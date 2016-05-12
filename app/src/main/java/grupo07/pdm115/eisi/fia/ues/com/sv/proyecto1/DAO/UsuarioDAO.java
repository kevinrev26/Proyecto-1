package grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.DAO;

import android.content.Context;

/**
 * Creado por Kevin Rivera, 05-12-16.
 * Puede usar, modificar y compartir este archivo
 * Consultas y mas: kevinrev26@gmail.com
 */
public class UsuarioDAO  extends MasterDAO{

    //Definiendo constantes para las tablas
    public static final String USUARIO_TABLE = "usuario";
    public static final String ID_USUARIO = "id_usuario";
    public static final int  ID_USUARIO_COL = 0;
    public static final String NOMBRE_USUARIO = "nombre_usuario";
    public static final int NOMBRE_USUARIO_COL = 1;
    public static final String PASSWORD = "password";
    public static final int PASSWORD_COL = 2;


    public UsuarioDAO(Context ctx) {
        super(ctx);
    }


    public static String crearTablaUsuario(){
        return "CREATE TABLE " + USUARIO_TABLE + " (" +
                ID_USUARIO + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                NOMBRE_USUARIO + " TEXT NOT NULL, " +
                PASSWORD + " TEXT NOT NULL " +
                ");";

    }

    public static String eliminarTablaUsuario(){
        return "DROP TABLE IF EXISTS " + USUARIO_TABLE;
    }
}
