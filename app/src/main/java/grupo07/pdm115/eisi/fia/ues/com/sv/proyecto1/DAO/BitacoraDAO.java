package grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import java.util.ArrayList;

import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Modelo.Bitacora;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.DAO.CoordinadorDAO;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Modelo.Coordinador;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Modelo.Tutor;

/**
 * Created by Gabriel on 07/05/2016.
 */
public class BitacoraDAO extends MasterDAO {

    public static final String TABLA_BITACORA = "bitacora";
    public static final String IDENTIFICADOR_BITACORA = "id_bitacora";
    public static final int ID_BITACORA_COL = 0;
    public static final String FECHA_INICIO = "fecha_inicio";
    public static final int FECH_INICIO_COL = 1;
    public static final String FECHA_FIN = "fecha_finale";
    public static final int FECH_FINALE_COL = 2;
    public static final String REVI_COORDINADOR = "revision_coordinador";
    public static final int REV_COORDINADOR_COL = 3;
    public static final String REVI_TUTOR = "revision_tutor";
    public static final int REV_TUTOR_COL = 4;
    public static final String ID_TIPO_ACTIVIDAD = "id_actividad";
    public static final int ID_TIPOACT_COL = 5;


    public BitacoraDAO(Context ctx){
        super(ctx);
    }

    public static String crearTablaBitacora(){

        return "CREATE TABLE " + TABLA_BITACORA + " (" +
                IDENTIFICADOR_BITACORA + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                FECHA_INICIO + " TEXT(10) NOT NULL, " +
                FECHA_FIN + " TEXT(10) NOT NULL, " +
                REVI_COORDINADOR + " INTEGER NOT NULL, " +
                REVI_TUTOR + " INTEGER NOT NULL, " +
                ID_TIPO_ACTIVIDAD + " TEXT(5) NOT NULL, " +
                "CONSTRAINT " +
                "fk_bitacora_coordinador FOREIGN KEY (" + REVI_COORDINADOR + ") " +
                "REFERENCES " + CoordinadorDAO.COORDINADOR_TABLE  + "(" + CoordinadorDAO.IDENTIFICADOR_COORDINADOR + ")" + " ON DELETE CASCADE ON UPDATE CASCADE, " +
                "CONSTRAINT fk_bitacora_tutor FOREIGN KEY (" + REVI_TUTOR + ") REFERENCES " + TutorDAO.TUTOR_TABLE + "(" + TutorDAO.IDENTIFICADOR_TUTOR + ")" + " ON DELETE CASCADE ON UPDATE CASCADE, " +
                "CONSTRAINT fk_bitacora_actividad FOREIGN KEY (" + ID_TIPO_ACTIVIDAD + ") REFERENCES " + TipoDeActividadDAO.TIPOACTIVIDAD_TABLE +  "(" + TipoDeActividadDAO.ID_TIPO_ACTIVIDAD +")" + " ON DELETE CASCADE ON UPDATE CASCADE " +
        ");";

    }

    public static String eliminarTablaBitacora(){
        return "DROP TABLE IF EXISTS " + TABLA_BITACORA;
    }

    public long insertarBitacora(Bitacora bitacora){
        ContentValues contentValues = new ContentValues();
        //contentValues.put(IDENTIFICADOR_BITACORA,bitacora.getId_bitacora());
        contentValues.put(FECHA_INICIO,bitacora.getFecha_inicio());
        contentValues.put(FECHA_FIN, bitacora.getFecha_fin());
        contentValues.put(REVI_COORDINADOR,bitacora.getRevision_coordinador());
        contentValues.put(REVI_TUTOR, bitacora.getRevision_tutor());
        contentValues.put(ID_TIPO_ACTIVIDAD, bitacora.getIdentificador_actividad());
        return mDatabase.insert(TABLA_BITACORA,null,contentValues);

    }

    public int actualizarBitacora(Bitacora bitacora){
        ContentValues contentValues = new ContentValues();

        contentValues.put(IDENTIFICADOR_BITACORA,bitacora.getId_bitacora());
        contentValues.put(FECHA_INICIO,bitacora.getFecha_inicio());
        contentValues.put(FECHA_FIN, bitacora.getFecha_fin());
        contentValues.put(REVI_COORDINADOR,bitacora.getRevision_coordinador());
        contentValues.put(REVI_TUTOR, bitacora.getRevision_tutor());
        contentValues.put(ID_TIPO_ACTIVIDAD, bitacora.getIdentificador_actividad());

        String where = IDENTIFICADOR_BITACORA + "= ?";
        String[] whereArgs = {String.valueOf(bitacora.getId_bitacora())};

        return mDatabase.update(TABLA_BITACORA, contentValues, where, whereArgs);

    }

    public int eliminarBitacora(int id){
        String where = IDENTIFICADOR_BITACORA + "= ?";
        String[] whereArgs={String.valueOf(id)};

        return mDatabase.delete(TABLA_BITACORA, where, whereArgs);
    }


    private static Bitacora getBitacoraPorCursor(Cursor cursor){
        if (cursor == null || cursor.getCount() ==0) {
            return null;
        } else {
            try {
                return new Bitacora(
                        cursor.getInt(ID_BITACORA_COL),
                        cursor.getString(FECH_INICIO_COL),
                        cursor.getString(FECH_FINALE_COL),
                        cursor.getInt(REV_COORDINADOR_COL),
                        cursor.getInt(REV_TUTOR_COL),
                        cursor.getString(ID_TIPOACT_COL)
                );
            } catch (Exception e){
                Log.i("EXE", e.toString());
                return null;
            }
        }

    }


    public Bitacora Bitacora(int id){
        String where = IDENTIFICADOR_BITACORA + "= ?";
        String[] whereArgs = {String.valueOf(id)};
        Cursor cursor = mDatabase.query(TABLA_BITACORA,null,where,whereArgs,null,null,null);
        cursor.moveToFirst();
        Bitacora temp = getBitacoraPorCursor(cursor);
        if (cursor!=null){
            cursor.close();
        }

        return temp;
    }

    public ArrayList<Bitacora> getListaBitacoras(){
        String query = "SELECT * FROM " + TABLA_BITACORA;
        Cursor cursor = mDatabase.rawQuery(query,null);
        ArrayList<Bitacora> bitacoras = new ArrayList<Bitacora>();
        while(cursor.moveToNext()){
            bitacoras.add(getBitacoraPorCursor(cursor));
        }

        if (cursor !=null){
            cursor.close();
        }
        return bitacoras;
    }


}



