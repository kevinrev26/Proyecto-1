package grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Modelo.Coordinador;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Modelo.Usuario;

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

    public long insertarUsuario(Usuario usuario){
        ContentValues contentValues = new ContentValues();
        contentValues.put(NOMBRE_USUARIO,usuario.getNombreUsuario());
        contentValues.put(PASSWORD, usuario.getPassword());

        return mDatabase.insert(USUARIO_TABLE,null,contentValues);

    }


    public Usuario getUser(String username){
        String where = NOMBRE_USUARIO + "= ?";
        String[] whereArgs = {username};
        Cursor cursor = mDatabase.query(USUARIO_TABLE,null,where,whereArgs,null,null,null);
        cursor.moveToFirst();
        Usuario temp = getUsuarioPorCursor(cursor);
        if (cursor!=null){
            cursor.close();
        }

        return temp;
    }



    private static Usuario getUsuarioPorCursor(Cursor cursor){
        if (cursor == null || cursor.getCount() ==0) {
            return null;
        } else {
            try {
                return new Usuario(
                        cursor.getInt(ID_USUARIO_COL),
                        cursor.getString(NOMBRE_USUARIO_COL),
                        cursor.getString(PASSWORD_COL)
                );

            } catch (Exception e){
                Log.i("EXE", e.toString());
                return null;
            }
        }

    }

    public int llenarUsuarios(){
        long bandera=0;
        bandera += insertarUsuario(new Usuario("GABRIEL","VC10014"));
        bandera += insertarUsuario(new Usuario("DIEGO","EA08015"));
        bandera += insertarUsuario(new Usuario("FABIOLA","DT11002"));
        bandera += insertarUsuario(new Usuario("KEVIN","RM11014"));
        bandera += insertarUsuario(new Usuario("MIGUEL","UR08001"));
        bandera += insertarUsuario(new Usuario("ROOT","PDM115"));

        return (int)bandera;
    }
}
