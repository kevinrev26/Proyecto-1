package grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import java.util.ArrayList;

import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Modelo.Permiso;

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
                ID_OPCION + " INTEGER REFERENCES " + OpcionDAO.OPCION_TABLE + "("+OpcionDAO.TOKEN+") " +
                "ON DELETE CASCADE ON UPDATE CASCADE, " +
                "PRIMARY KEY (" + ID_USUARIO + "," + ID_OPCION + ")" +
                ");";
    }


    public static String eliminarTablaPermiso(){
        return  "DROP TABLE IF EXISTS " + PERMISO_TABLE;
    }

    public long insertarPermiso(Permiso permiso){
        ContentValues contentValues = new ContentValues();
        contentValues.put(ID_USUARIO,permiso.getIdUsuario());
        contentValues.put(ID_OPCION,permiso.getIdOpcion());

        return mDatabase.insert(PERMISO_TABLE,null,contentValues);
    }


    public int llenarPermisos(){
        long bandera = 0;
        //Gabriel
        bandera += insertarPermiso(new Permiso(30,1));
        bandera += insertarPermiso(new Permiso(31,1));
        bandera += insertarPermiso(new Permiso(32,1));
        bandera += insertarPermiso(new Permiso(33,1));
        bandera += insertarPermiso(new Permiso(34,1));
        bandera += insertarPermiso(new Permiso(35,1));
        bandera += insertarPermiso(new Permiso(40,1));
        bandera += insertarPermiso(new Permiso(41,1));
        bandera += insertarPermiso(new Permiso(42,1));
        bandera += insertarPermiso(new Permiso(43,1));
        bandera += insertarPermiso(new Permiso(44,1));
        bandera += insertarPermiso(new Permiso(45,1));

        //Diego
        bandera += insertarPermiso(new Permiso(50,2));
        bandera += insertarPermiso(new Permiso(51,2));
        bandera += insertarPermiso(new Permiso(52,2));
        bandera += insertarPermiso(new Permiso(53,2));
        bandera += insertarPermiso(new Permiso(54,2));
        bandera += insertarPermiso(new Permiso(55,2));
        bandera += insertarPermiso(new Permiso(70,2));
        bandera += insertarPermiso(new Permiso(71,2));
        bandera += insertarPermiso(new Permiso(72,2));
        bandera += insertarPermiso(new Permiso(72,2));
        bandera += insertarPermiso(new Permiso(74,2));
        bandera += insertarPermiso(new Permiso(75,2));

        //Fabiola
        bandera += insertarPermiso(new Permiso(110,3));
        bandera += insertarPermiso(new Permiso(111,3));
        bandera += insertarPermiso(new Permiso(112,3));
        bandera += insertarPermiso(new Permiso(113,3));
        bandera += insertarPermiso(new Permiso(114,3));
        bandera += insertarPermiso(new Permiso(115,3));
        bandera += insertarPermiso(new Permiso(60,3));
        bandera += insertarPermiso(new Permiso(61,3));
        bandera += insertarPermiso(new Permiso(62,3));
        bandera += insertarPermiso(new Permiso(63,3));
        bandera += insertarPermiso(new Permiso(64,3));
        bandera += insertarPermiso(new Permiso(65,3));

        //Kevin
        bandera += insertarPermiso(new Permiso(10,4));
        bandera += insertarPermiso(new Permiso(11,4));
        bandera += insertarPermiso(new Permiso(12,4));
        bandera += insertarPermiso(new Permiso(13,4));
        bandera += insertarPermiso(new Permiso(14,4));
        bandera += insertarPermiso(new Permiso(15,4));
        bandera += insertarPermiso(new Permiso(20,4));
        bandera += insertarPermiso(new Permiso(21,4));
        bandera += insertarPermiso(new Permiso(22,4));
        bandera += insertarPermiso(new Permiso(23,4));
        bandera += insertarPermiso(new Permiso(24,4));
        bandera += insertarPermiso(new Permiso(25,4));

        //Miguel

        //Root




        return (int)bandera;
    }



    private static Permiso getPermisoPorCursor(Cursor cursor){
        if (cursor == null || cursor.getCount() ==0) {
            return null;
        } else {
            try {
                return new Permiso(
                        cursor.getInt(ID_OPCION_COL),
                        cursor.getInt(ID_USUARIO_COL)
                );

            } catch (Exception e){
                Log.i("EXE", e.toString());
                return null;
            }
        }

    }

    public ArrayList<Permiso> getPermisos(int idUsuario){
        String where = ID_USUARIO + "= ?";
        String[] whereArgs = {String.valueOf(idUsuario)};
        Cursor cursor = mDatabase.query(PERMISO_TABLE,null,where,whereArgs,null,null,null);
        ArrayList<Permiso> permisos= new ArrayList<Permiso>();
        cursor.moveToFirst();
        while(cursor.moveToNext()){
            permisos.add(getPermisoPorCursor(cursor));

        }
        if (cursor!=null){
            cursor.close();
        }


        return permisos;
    }
}
