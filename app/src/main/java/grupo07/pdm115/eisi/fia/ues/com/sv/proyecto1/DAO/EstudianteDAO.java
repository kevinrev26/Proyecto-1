package grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.DAO;

import android.app.ActivityManager;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Modelo.Coordinador;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Modelo.Estudiante;

/**
 * Creado por Kevin Rivera, 05-07-16.
 * Puede usar, modificar y compartir este archivo
 * Consultas y mas: kevinrev26@gmail.com
 */
public class EstudianteDAO extends MasterDAO {


    //Constantes para las tablas
    private static final String ESTUDIANTE_TABLE = "estudiante";
    private static final String CARNET = "carnet_estudiante";
    private static final int CARNET_COL = 0;
    private static final String NOMBRE = "nombre_estudiante";
    private static final int NOMBRE_COL = 1;
    private static final String EMAIL = "email_estudiante";
    private static final int EMAIL_COL = 2;
    private static final String TELEFONO = "telefono_estudiante";
    private static final int TEL_COL = 3;
    private static final String CARRERA = "CARRERA";
    private static final int CARRERA_COL = 4;

    public EstudianteDAO(Context ctx) {
        super(ctx);
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

    public Estudiante getEstudiante(String id){
        String where = CARNET + "= ?";
        String whereArgs[] = { id };
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
                Log.i("EXE_INS",e.toString());
                return null;

            }

        }


    }
}

