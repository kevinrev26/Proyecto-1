package grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.DAO;

/**
 * Created by Diego on 10/05/2016.
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import java.util.ArrayList;

import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Modelo.Tutor;


public class TutorDAO extends MasterDAO {


    //Constantes para la base de datos
    public static final String TUTOR_TABLE = "tutor";
    public static final String IDENTIFICADOR_TUTOR = "id_tutor";
    public static final int ID_TUTOR_COL = 0;
    public static final String NOM_TUTOR = "nombre_tutor";
    public static final int NOM_TUTOR_COL = 1;
    public static final String EMAIL_TUTOR = "email_tutor";
    public static final int EMAIL_TUTOR_COL = 2;
    public static final String TEL_TUTOR = "telefono_tutor";
    public static final int TEL_TUTOR_COL = 3;

    public TutorDAO(Context ctx) {
        super(ctx);
    }

    public static String crearTablaTutor(){
        return "CREATE TABLE " + TUTOR_TABLE + " (" +
                IDENTIFICADOR_TUTOR + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                NOM_TUTOR + " TEXT(10) NOT NULL, " +
                EMAIL_TUTOR + " TEXT(25), " +
                TEL_TUTOR + " TEXT(8) NOT NULL " +
                ");";
    }

    public static String eliminarTablaTutor(){
        return "DROP TABLE IF EXISTS " + TUTOR_TABLE;
    }


    public long insertarTutor(Tutor tutor){
        ContentValues contentValues = new ContentValues();
        contentValues.put(NOM_TUTOR,tutor.getNombre());
        contentValues.put(EMAIL_TUTOR, tutor.getEmail());
        contentValues.put(TEL_TUTOR,tutor.getTelefono());
        return mDatabase.insert(TUTOR_TABLE,null,contentValues);

    }

    public int actualizarTutor(Tutor tutor){
        ContentValues contentValues = new ContentValues();
        contentValues.put(IDENTIFICADOR_TUTOR, tutor.getIdTutor());
        contentValues.put(NOM_TUTOR, tutor.getNombre());
        contentValues.put(EMAIL_TUTOR, tutor.getEmail());
        contentValues.put(TEL_TUTOR, tutor.getTelefono());

        String where = IDENTIFICADOR_TUTOR + "= ?";
        String[] whereArgs = {String.valueOf(tutor.getIdTutor())};
        return mDatabase.update(TUTOR_TABLE, contentValues, where, whereArgs);

    }

    public int eliminarTutor(int id){
        String where = IDENTIFICADOR_TUTOR + "= ?";
        String[] whereArgs = {String.valueOf(id)};
        return mDatabase.delete(TUTOR_TABLE, where, whereArgs);
    }


    private static Tutor getTutorPorCursor(Cursor cursor){
        if (cursor == null || cursor.getCount() ==0) {
            return null;
        } else {
            try {
                return new Tutor(
                        cursor.getInt(ID_TUTOR_COL),
                        cursor.getString(EMAIL_TUTOR_COL),
                        cursor.getString(NOM_TUTOR_COL),
                        cursor.getString(TEL_TUTOR_COL)
                );

            } catch (Exception e){
                Log.i("EXE", e.toString());
                return null;
            }
        }

    }


    public Tutor getTutor(int id){
        String where = IDENTIFICADOR_TUTOR + "= ?";
        String[] whereArgs = {String.valueOf(id)};
        Cursor cursor = mDatabase.query(TUTOR_TABLE,null,where,whereArgs,null,null,null);
        cursor.moveToFirst();
        Tutor temp = getTutorPorCursor(cursor);
        if (cursor!=null){
            cursor.close();
        }

        return temp;
    }

    public ArrayList<Tutor> getListaTutores(){
        String query = "SELECT * FROM " + TUTOR_TABLE;
        Cursor cursor = mDatabase.rawQuery(query,null);
        ArrayList<Tutor> tutores = new ArrayList<Tutor>();
        while(cursor.moveToNext()) {
            tutores.add(getTutorPorCursor(cursor));
        }

        if (cursor !=null){
            cursor.close();
        }
        return tutores;
    }


}
