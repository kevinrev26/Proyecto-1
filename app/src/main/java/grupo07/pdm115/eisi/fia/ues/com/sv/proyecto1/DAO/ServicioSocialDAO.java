package grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import java.util.ArrayList;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Modelo.Institucion;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Modelo.ServicioSocial;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Modelo.Tutor;

public class ServicioSocialDAO extends MasterDAO {

    private static final String SERVICIO_SOCIAL_TABLE = "servicio_social";
    private static final String ID_SERVICIO = "id_servicio";
    private static final int ID_SERVICIO_COL = 0;
    private static final String IDENTIFICADOR_INSTITUCION = "identificador_institucion";
    private static final int ID_INSTITUCION_COL = 1;
    private static final String IDENTIFICADOR_TUTOR = "identificador_tutor";
    private static final int ID_TUTOR_COL = 2;
    private static final String IDENTIFICADOR_MODALIDAD = "identificador_modalidad";
    private static final int ID_MODALIDAD_COL = 3;
    private static final String TITULO = "titulo";
    private static final int TITULO_COL = 4;
    private static final String DESCRIPCION = "descripcion";
    private static final int DESCRIPCION_COL = 5;
    private static final int DISPONIBLE = 1;
    private static final int DISPONIBLE_COL = 6;
    private static final String COORDINADOR_APROBADO = "coordinador_aprobado";
    private static final int COORDINADOR_APROBADO_COL = 7;
    //private static final Tutor tutor = new Tutor();
    private static final Institucion institucion = new Institucion();


    public ServicioSocialDAO(Context ctx) {
        super(ctx);
        Log.i("DAO", "Dentro del constructor SERVICIO SOCIAL DAO");
    }

    /*
    * Con este metodo se construye el String para la creacion de la tabla
    */
    public static String crearTablaServicioSocial() {
        return "CREATE TABLE " + SERVICIO_SOCIAL_TABLE + " (" +
                ID_SERVICIO + " TEXT(5) NOT NULL, " +
                IDENTIFICADOR_INSTITUCION + " TEXT(10) NOT NULL, " +
                IDENTIFICADOR_MODALIDAD + " TEXT(5) NOT NULL, " +
                IDENTIFICADOR_TUTOR + " TEXT, " +
                TITULO + " TEXT(10), " +
                DESCRIPCION + " TEXT(30), " +
                DISPONIBLE + " INTEGER(1) NOT NULL " +
                COORDINADOR_APROBADO + " TEXT(5) NOT NULL " +
                "PRIMARY KEY(" + ID_SERVICIO + "), CONSTRAINT " +
                "fk_servicio_institucion FOREIGN KEY (" + IDENTIFICADOR_INSTITUCION + ")" +
                "REFERENCES institucion (ID_INSTITUCION) ON DELETE CASCADE ON UPDATE CASCADE, " +
                "CONSTRAINT fk_servicio_modalidad FOREIGN KEY (" + IDENTIFICADOR_MODALIDAD + ") REFERENCES modalidad ("
                + "IDENTIFICADOR_MODALIDAD ) ON DELETE CASCADE ON UPDATE CASCADE, " +
                "CONSTRAINT fk_servicio_tutor FOREIGN KEY (" + IDENTIFICADOR_TUTOR +
                ") REFERENCES tutor (IDENTIFICADOR_TUTOR) ON DELETE CASCADE ON UPDATE CASCADE, " +
                "CONSTRAINT fk_servicio_coordinador FOREIGN KEY (" + COORDINADOR_APROBADO +
                ") REFERENCES coordinador (id_coordinador) ON DELETE CASCADE ON UPDATE CASCADE);";
    }

    public static String eliminarTablaServicioSocial() {
        return "DROP TABLE IF EXISTS " + SERVICIO_SOCIAL_TABLE;
    }

    public long insertarServicioSocial(ServicioSocial servicioSocial) {
        //super.abrirDB();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ID_SERVICIO, servicioSocial.getIdServicio());
        contentValues.put(IDENTIFICADOR_INSTITUCION, servicioSocial.getIdentificadorInstitucion());
        contentValues.put(IDENTIFICADOR_TUTOR, servicioSocial.getIdentificadorTutor());
        contentValues.put(IDENTIFICADOR_MODALIDAD, servicioSocial.getIdentificadorModalidad());
        contentValues.put(TITULO, servicioSocial.getTitulo());
        contentValues.put(DESCRIPCION, servicioSocial.getTitulo());
        contentValues.put(String.valueOf(DISPONIBLE), servicioSocial.getDisponible());
        contentValues.put(COORDINADOR_APROBADO, servicioSocial.getCoordinadorAprobado());
        return mDatabase.insert(SERVICIO_SOCIAL_TABLE, null, contentValues);
    }

    public int actualizarServicioSocial(ServicioSocial servicioSocial) {
        //super.abrirDB();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ID_SERVICIO, servicioSocial.getIdServicio());
        contentValues.put(IDENTIFICADOR_INSTITUCION, servicioSocial.getIdentificadorInstitucion());
        contentValues.put(IDENTIFICADOR_TUTOR, servicioSocial.getIdentificadorTutor());
        contentValues.put(IDENTIFICADOR_MODALIDAD, servicioSocial.getIdentificadorModalidad());
        contentValues.put(TITULO, servicioSocial.getTitulo());
        contentValues.put(DESCRIPCION, servicioSocial.getTitulo());
        contentValues.put(String.valueOf(DISPONIBLE), servicioSocial.getDisponible());
        contentValues.put(COORDINADOR_APROBADO, servicioSocial.getCoordinadorAprobado());

        String where = ID_SERVICIO + "= ?";
        String[] whereArgs = {servicioSocial.getIdServicio()};

        return mDatabase.update(SERVICIO_SOCIAL_TABLE, contentValues, where, whereArgs);
    }

    public int eliminarServicioSocial(String idServicio) {
        // super.abrirDB();
        String where = ID_SERVICIO + "= ?";
        String[] whereArgs = {idServicio};
        return mDatabase.delete(SERVICIO_SOCIAL_TABLE, where, whereArgs);
    }

    public ArrayList<ServicioSocial> getListaServicioSocials() {
        // super.abrirDB();
        String query = "SELECT * FROM " + SERVICIO_SOCIAL_TABLE;
        Cursor cursor = mDatabase.rawQuery(query, null);
        ArrayList<ServicioSocial> servicioSocials = new ArrayList<ServicioSocial>();
        while (cursor.moveToNext()) {
            servicioSocials.add(getServicioSocialPorCursor(cursor));
        }

        if (cursor != null) {
            cursor.close();
        }

        return servicioSocials;

    }

    public ServicioSocial servicioSocial(String id) {
        //super.abrirDB();
        String where = ID_SERVICIO + "= ?";
        String whereArgs[] = {id};
        Cursor cursor = mDatabase.query(SERVICIO_SOCIAL_TABLE, null, where, whereArgs, null, null, null);
        cursor.moveToFirst();
        ServicioSocial temp = getServicioSocialPorCursor(cursor);

        if (cursor != null) {
            cursor.close();
        }
        return temp;
    }

    private static ServicioSocial getServicioSocialPorCursor(Cursor cursor) {
        if (cursor == null || cursor.getCount() == 0) {
            return null;
        } else {
            try {
                return new ServicioSocial(
                        cursor.getString(ID_SERVICIO_COL),
                        cursor.getString(ID_INSTITUCION_COL),
                        cursor.getString(ID_TUTOR_COL),
                        cursor.getString(ID_MODALIDAD_COL),
                        cursor.getString(TITULO_COL),
                        cursor.getString(DESCRIPCION_COL),
                        cursor.getInt(DISPONIBLE_COL),
                        cursor.getString(COORDINADOR_APROBADO_COL)
                );

            } catch (Exception e) {
                Log.i("EXE", e.toString());
                return null;

            }

        }
    }
}
