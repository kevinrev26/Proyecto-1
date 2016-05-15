package grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import java.util.ArrayList;

import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Modelo.Institucion;

/**
 * Created by Usuario on 09/05/2016.
 */
public class InstitucionDAO extends MasterDAO{

    public static String INSTITUCION_TABLE = "institucion";
    public static String ID_INSTITUCION = "id_institucion";
    private static final int ID_INSTITUCION_COL = 0;
    private static final String NOMBRE_INSTITUCION = "nombre_institucion";
    private static final int NOMBRE_INSTITUCION_COL = 1;
    private static final String EMAIL_INSTITUCION = "email_institucion";
    private static final int EMAIL_INSTITUCION_COL = 2;
    private static final String NOMBRE_ENCARGADO = "nombre_encargado";
    private static final int NOMBRE_ENCARGADO_COL = 3;
    private static final String TELEFONO1 = "telefono1";
    private static final int TELEFONO1_COL = 4;
    private static final String TELEFONO2 = "telefono2";
    private static final int TELEFONO2_COL = 5;


    public InstitucionDAO(Context ctx) {
        super(ctx);
        Log.i("DAO", "Dentro del constructor INSTITUCION DAO");
    }

    /*
    * Con este metodo se construye el String para la creacion de la tabla
    */

    public static String crearTablaInstitucion() {
        return "CREATE TABLE " + INSTITUCION_TABLE + " (" +
                ID_INSTITUCION + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                NOMBRE_INSTITUCION + " TEXT NOT NULL, " +
                EMAIL_INSTITUCION + " TEXT NOT NULL, " +
                NOMBRE_ENCARGADO + " TEXT NOT NULL, " +
                TELEFONO1 + " TEXT(8) NOT NULL, " +
                TELEFONO2 + " TEXT(8) " +
                ");";
    }

    public static String eliminarTablaInstitucion() {
        return "DROP TABLE IF EXISTS " + INSTITUCION_TABLE;
    }

    public long insertarInstitucion(Institucion institucion) {
        //super.abrirDB();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NOMBRE_INSTITUCION, institucion.getNombreInstitucion());
        contentValues.put(EMAIL_INSTITUCION, institucion.getEmailInstitucion());
        contentValues.put(NOMBRE_ENCARGADO, institucion.getNombreEncargado());
        contentValues.put(TELEFONO1, institucion.getTelefono1());
        contentValues.put(TELEFONO2, institucion.getTelefono2());
        return mDatabase.insert(INSTITUCION_TABLE, null, contentValues);
    }

    public int actualizarInstitucion(Institucion institucion) {
        //super.abrirDB();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ID_INSTITUCION, institucion.getIdInstitucion());
        contentValues.put(NOMBRE_INSTITUCION, institucion.getNombreInstitucion());
        contentValues.put(EMAIL_INSTITUCION, institucion.getEmailInstitucion());
        contentValues.put(NOMBRE_ENCARGADO, institucion.getNombreEncargado());
        contentValues.put(TELEFONO1, institucion.getTelefono1());
        contentValues.put(TELEFONO2, institucion.getTelefono2());
        String where = ID_INSTITUCION + "= ?";
        String[] whereArgs = {String.valueOf(institucion.getIdInstitucion())};

        return mDatabase.update(INSTITUCION_TABLE, contentValues, where, whereArgs);
    }

    public int eliminarInstiucion(int idInstitucion) {
        // super.abrirDB();
        String where = ID_INSTITUCION + "= ?";
        String[] whereArgs = {String.valueOf(idInstitucion)};
        return mDatabase.delete(INSTITUCION_TABLE, where, whereArgs);
    }

    public ArrayList<Institucion> getListaInstitucion() {
        // super.abrirDB();
        String query = "SELECT * FROM " + INSTITUCION_TABLE;
        Cursor cursor = mDatabase.rawQuery(query, null);
        ArrayList<Institucion> instituciones = new ArrayList<Institucion>();
        while (cursor.moveToNext()) {
            instituciones.add(getInstitucionPorCursor(cursor));
        }

        if (cursor != null) {
            cursor.close();
        }

        return instituciones;
    }

    public Institucion institucion(int id) {
        //super.abrirDB();
        String where = ID_INSTITUCION + "= ?";
        String whereArgs[] = {String.valueOf(id)};
        Cursor cursor = mDatabase.query(INSTITUCION_TABLE, null, where, whereArgs, null, null, null);
        cursor.moveToFirst();
        Institucion temp = getInstitucionPorCursor(cursor);

        if (cursor != null) {
            cursor.close();
        }
        return temp;
    }

    private static Institucion getInstitucionPorCursor(Cursor cursor) {
        if (cursor == null || cursor.getCount() == 0) {
            return null;
        } else {
            try {
                return new Institucion(
                        cursor.getString(NOMBRE_INSTITUCION_COL),
                        cursor.getString(EMAIL_INSTITUCION_COL),
                        cursor.getString(NOMBRE_ENCARGADO_COL),
                        cursor.getString(TELEFONO1_COL),
                        cursor.getString(TELEFONO2_COL)
                        );

            } catch (Exception e) {
                Log.i("EXE", e.toString());
                return null;

            }

        }
    }
}
