package grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.DAO;

import android.app.ActivityManager;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import java.util.ArrayList;

import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Modelo.Coordinador;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Modelo.Estudiante;

/**
 * Creado por Kevin Rivera, 05-07-16.
 * Puede usar, modificar y compartir este archivo
 * Consultas y mas: kevinrev26@gmail.com
 */
public class EstudianteDAO extends MasterDAO {


    //Constantes para las tablas
    public static final String ESTUDIANTE_TABLE = "estudiante";
    public static final String CARNET = "carnet_estudiante";
    public static final int CARNET_COL = 0;
    public static final String NOMBRE = "nombre_estudiante";
    public static final int NOMBRE_COL = 1;
    public static final String EMAIL = "email_estudiante";
    public static final int EMAIL_COL = 2;
    public static final String TELEFONO = "telefono_estudiante";
    public static final int TEL_COL = 3;
    public static final String CARRERA = "CARRERA";
    public static final int CARRERA_COL = 4;

    public EstudianteDAO(Context ctx) {
        super(ctx);
        //Log.i("DAO","Dentro del constructor ESTUDIANTE DAO");
    }

    /*
    * Con este metodo se construye el String para la creacion de la tabla
    */
    public static String crearTablaEstudiante(){
        return "CREATE TABLE " + ESTUDIANTE_TABLE + " (" +
                CARNET + " TEXT(7) NOT NULL, " +
                NOMBRE + " TEXT(20) NOT NULL, " +
                EMAIL  + " TEXT(25) NOT NULL, " +
                TELEFONO + " TEXT(8), " +
                CARRERA +  " TEXT(20), " +
                "PRIMARY KEY(" + CARNET +") " +
                ");";
    }

    public static String eliminarTablaEstudiante(){
        return  "DROP TABLE IF EXISTS " + ESTUDIANTE_TABLE;
    }

    public long insertarEstudiante(Estudiante estudiante){
        //super.abrirDB();
        ContentValues contentValues = new ContentValues();
        contentValues.put(CARNET,estudiante.getCarnet());
        contentValues.put(NOMBRE,estudiante.getNombre());
        contentValues.put(EMAIL,estudiante.getEmail());
        contentValues.put(TELEFONO, estudiante.getTelefono());
        contentValues.put(CARRERA, estudiante.getCarrera());
        return mDatabase.insert(ESTUDIANTE_TABLE, null,contentValues);
    }

    public int actualizarEstudiante(Estudiante estudiante){
        //super.abrirDB();
        ContentValues contentValues = new ContentValues();
        contentValues.put(CARNET,estudiante.getCarnet());
        contentValues.put(NOMBRE,estudiante.getNombre());
        contentValues.put(EMAIL,estudiante.getEmail());
        contentValues.put(TELEFONO, estudiante.getTelefono());
        contentValues.put(CARRERA, estudiante.getCarrera());

        String where = CARNET + "= ?";
        String[] whereArgs = {estudiante.getCarnet() };
        return mDatabase.update(ESTUDIANTE_TABLE, contentValues, where, whereArgs);
    }

    public int eliminarEstudiante(String carnet){
       // super.abrirDB();
        String where = CARNET + "= ?";
        String[] whereArgs = {carnet};
        return mDatabase.delete(ESTUDIANTE_TABLE, where, whereArgs);
    }

    public ArrayList<Estudiante> getListaEstudiantes(){
       // super.abrirDB();
        String query = "SELECT * FROM " + ESTUDIANTE_TABLE;
        Cursor cursor = mDatabase.rawQuery(query,null);
        ArrayList<Estudiante> estudiantes = new ArrayList<Estudiante>();
        while (cursor.moveToNext()){
            estudiantes.add(getEstudiantePorCursor(cursor));
        }

        if (cursor!=null){
            cursor.close();
        }

        return estudiantes;

    }

    public Estudiante getEstudiante(String carnet){
        //super.abrirDB();
        String where = CARNET + "= ?";
        String whereArgs[] = { carnet };
        Cursor cursor  = mDatabase.query(ESTUDIANTE_TABLE,null,where,whereArgs,null,null,null);
        cursor.moveToFirst();
        Estudiante temp = getEstudiantePorCursor(cursor);

        if (cursor!=null){
            cursor.close();
        }
        return temp;
    }

    private static Estudiante getEstudiantePorCursor(Cursor cursor) {
        if (cursor == null || cursor.getCount() == 0) {
            return null;
        } else {
            try {
                return new Estudiante(
                        cursor.getString(CARNET_COL),
                        cursor.getString(CARRERA_COL),
                        cursor.getString(EMAIL_COL),
                        cursor.getString(TEL_COL),
                        cursor.getString(NOMBRE_COL)
                );

            } catch (Exception e){
                Log.i("EXE",e.toString());
                return null;

            }

        }


    }
}


