package grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.DAO;

/**
 * Created by Diego on 08/05/2016.
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import java.util.ArrayList;

import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Modelo.Modalidad;


public class ModalidadDAO extends MasterDAO {


    public static final String MODALIDAD_TABLE = "modalidad";
    public static final String IDENTIFICADOR_MODALIDAD = "id_modalidad";
    public static final int ID_MODALIDAD_COL = 0;
    public static final String NOM_MODALIDAD = "nombre_modalidad";
    public static final int NOM_MODALIDAD_COL = 1;


    public ModalidadDAO(Context ctx) {
        super(ctx);
    }

    public static String crearTablaModalidad(){
        return "CREATE TABLE " + MODALIDAD_TABLE + " (" +
                IDENTIFICADOR_MODALIDAD + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                NOM_MODALIDAD + " TEXT(25) NOT NULL " +
                ");";
    }

    public static String eliminarTablaModalidad(){
        return "DROP TABLE IF EXISTS " + MODALIDAD_TABLE;
    }


    public long insertarModalidad(Modalidad modalidad){
        ContentValues contentValues = new ContentValues();
        contentValues.put(NOM_MODALIDAD,modalidad.getNombre());
        return mDatabase.insert(MODALIDAD_TABLE,null,contentValues);

    }

    public int actualizarModalidad(Modalidad modalidad){
        ContentValues contentValues = new ContentValues();
        contentValues.put(IDENTIFICADOR_MODALIDAD,modalidad.getIdModalidad());
        contentValues.put(NOM_MODALIDAD,modalidad.getNombre());

        String where = IDENTIFICADOR_MODALIDAD + "= ?";
        String[] whereArgs = {String.valueOf(modalidad.getIdModalidad())};
        return mDatabase.update(MODALIDAD_TABLE, contentValues, where, whereArgs);

    }

    public int eliminarModalidad(int id){
        String where = IDENTIFICADOR_MODALIDAD + "= ?";
        String[] whereArgs = {String.valueOf(id)};
        return mDatabase.delete(MODALIDAD_TABLE, where, whereArgs);
    }


    private static Modalidad getModalidadPorCursor(Cursor cursor){
        if (cursor == null || cursor.getCount() ==0) {
            return null;
        } else {
            try {
                return new Modalidad(
                        cursor.getInt(ID_MODALIDAD_COL),
                        cursor.getString(NOM_MODALIDAD_COL)
                        );

            } catch (Exception e){
                Log.i("EXE", e.toString());
                return null;
            }
        }

    }


    public Modalidad getModalidad(int id){
        String where = IDENTIFICADOR_MODALIDAD + "= ?";
        String[] whereArgs = {String.valueOf(id)};
        Cursor cursor = mDatabase.query(MODALIDAD_TABLE,null,where,whereArgs,null,null,null);
        cursor.moveToFirst();
        Modalidad temp = getModalidadPorCursor(cursor);
        if (cursor!=null){
            cursor.close();
        }

        return temp;
    }

    public ArrayList<Modalidad> getListaModalidades(){
        String query = "SELECT * FROM " + MODALIDAD_TABLE;
        Cursor cursor = mDatabase.rawQuery(query,null);
        ArrayList<Modalidad> modalidades = new ArrayList<Modalidad>();
        while(cursor.moveToNext()) {
            modalidades.add(getModalidadPorCursor(cursor));
        }

        if (cursor !=null){
            cursor.close();
        }
        return modalidades;
    }


}
