package grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import java.util.ArrayList;

import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Modelo.Coordinador;

/**
 * Creado por Kevin Rivera, 05-07-16.
 * Puede usar, modificar y compartir este archivo
 * Consultas y mas: kevinrev26@gmail.com
 */
public class CoordinadorDAO extends MasterDAO {


    //Constantes para la base de datos
    public static final String COORDINADOR_TABLE = "coordinador";
    public static final String IDENTIFICADOR_COORDINADOR = "id_coordinador";
    public static final int ID_COORDINADOR_COL = 0;
    public static final String NOM_COORDINADOR = "nombre_coordinador";
    public static final int NOM_COORDINADOR_COL = 1;
    public static final String EMAIL_COORDINADOR = "email_coordiandor";
    public static final int EMAIL_COORDINADOR_COL = 2;
    public static final String TEL_COORDINADOR = "telefono_coordinador";
    public static final int TEL_COORDINADOR_COL = 3;

    public CoordinadorDAO(Context ctx) {
        super(ctx);
    }

    public static String crearTablaCoordinador(){
        return "CREATE TABLE " + COORDINADOR_TABLE + " (" +
                IDENTIFICADOR_COORDINADOR + " INTEGER AUTOINCREMENT, " +
                NOM_COORDINADOR + " TEXT(10) NOT NULL, " +
                EMAIL_COORDINADOR + " TEXT(25), " +
                TEL_COORDINADOR + " TEXT(8) NOT NULL, " +
                " PRIMARY KEY(" + IDENTIFICADOR_COORDINADOR + ") " +
                ");";
    }

    public static String eliminarTablaCoordinador(){
        return "DROP TABLE IF EXISTS " + COORDINADOR_TABLE;
    }


    public long insertarCoordinador(Coordinador coordinador){
        ContentValues contentValues = new ContentValues();
        contentValues.put(NOM_COORDINADOR,coordinador.getNombre());
        contentValues.put(EMAIL_COORDINADOR, coordinador.getEmail());
        contentValues.put(TEL_COORDINADOR,coordinador.getTelefono());
        return mDatabase.insert(COORDINADOR_TABLE,null,contentValues);

    }

    public int actualizarCoordinador(Coordinador coordinador){
        ContentValues contentValues = new ContentValues();
        contentValues.put(IDENTIFICADOR_COORDINADOR,coordinador.getId_coordinador());
        contentValues.put(NOM_COORDINADOR,coordinador.getNombre());
        contentValues.put(EMAIL_COORDINADOR, coordinador.getEmail());
        contentValues.put(TEL_COORDINADOR,coordinador.getTelefono());

        String where = IDENTIFICADOR_COORDINADOR + "= ?";
        String[] whereArgs = {String.valueOf(coordinador.getId_coordinador())};
        return mDatabase.update(COORDINADOR_TABLE, contentValues, where, whereArgs);

    }

    public int eliminarCoordinador(int id){
        String where = IDENTIFICADOR_COORDINADOR + "= ?";
        String[] whereArgs = {String.valueOf(id)};
        return mDatabase.delete(COORDINADOR_TABLE, where, whereArgs);
    }


    private static Coordinador getCoordinadorPorCursor(Cursor cursor){
        if (cursor == null || cursor.getCount() ==0) {
            return null;
        } else {
            try {
                return new Coordinador(
                        cursor.getString(EMAIL_COORDINADOR_COL),
                        cursor.getInt(ID_COORDINADOR_COL),
                        cursor.getString(NOM_COORDINADOR_COL),
                        cursor.getString(TEL_COORDINADOR_COL)
                );

            } catch (Exception e){
                Log.i("EXE", e.toString());
                return null;
            }
        }

    }


    public Coordinador getCoordinador(int id){
        String where = IDENTIFICADOR_COORDINADOR + "= ?";
        String[] whereArgs = {String.valueOf(id)};
        Cursor cursor = mDatabase.query(COORDINADOR_TABLE,null,where,whereArgs,null,null,null);
        cursor.moveToFirst();
        Coordinador temp = getCoordinadorPorCursor(cursor);
        if (cursor!=null){
            cursor.close();
        }

        return temp;
    }

    public ArrayList<Coordinador> getListaCoordinadores(){
        String query = "SELECT * FROM " + COORDINADOR_TABLE;
        Cursor cursor = mDatabase.rawQuery(query,null);
        ArrayList<Coordinador> coordinadores = new ArrayList<Coordinador>();
        while(cursor.moveToNext()){
            coordinadores.add(getCoordinadorPorCursor(cursor));
        }

        if (cursor !=null){
            cursor.close();
        }
        return coordinadores;
    }


}
