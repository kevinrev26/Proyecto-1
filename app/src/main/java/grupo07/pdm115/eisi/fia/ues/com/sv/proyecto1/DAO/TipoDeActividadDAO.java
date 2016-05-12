package grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.DAO;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import java.util.ArrayList;

import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Modelo.TipoDeActividad;
/**
 * Created by Gabriel on 07/05/2016.
 */
public class TipoDeActividadDAO  extends MasterDAO
{
    //Constantes para las tablas
    static final String TIPOACTIVIDAD_TABLE = "tipo_actividad";
    static final String ID_TIPO_ACTIVIDAD = "id_tipo_actividad";
    private static final int ID_COL = 0;
    private static final String NOMBRE_ACTIVIDAD = "nombre_actividad";
    private static final int NOMBRE_COL = 1;
    private static final String HORAS = "cantidad_horas";
    private static final int HORAS_COL = 2;
    private static final String DESCRIPCION = "descripcion";
    private static final int DESCRIP_COL = 3;


    public TipoDeActividadDAO(Context ctx)
    {
        super(ctx);
        //Log.i("DAO", "Dentro del constructor TipoDeActividad DAO");
    }

    /** Con este metodo se construye el String para la creacion de la tabla*/

    public static  String crearTablaTipoDeActividad()
    {
        return "CREATE TABLE " + TIPOACTIVIDAD_TABLE + " (" +
                ID_TIPO_ACTIVIDAD + " TEXT(5) NOT NULL, " +
                NOMBRE_ACTIVIDAD + " TEXT (10) NOT NULL, " +
                HORAS + " INTEGER(2) NOT NULL, " +
                DESCRIPCION + " TEXT(5), " +
                "PRIMARY KEY(" +ID_TIPO_ACTIVIDAD +") " +
                ");" ;
    }

    public static String eliminarTablaDeActividad(){
        return "DROP TABLE IF EXISTS " + TIPOACTIVIDAD_TABLE;
    }

    public long insertarTipoActividad(TipoDeActividad tipoActividad){
        ContentValues contentValues= new ContentValues();

        contentValues.put(ID_TIPO_ACTIVIDAD,tipoActividad.getId_tipo_actividad());
        contentValues.put(NOMBRE_ACTIVIDAD,tipoActividad.getNombre_actividad());
        contentValues.put(HORAS,tipoActividad.getCantidad_horas()); //dudas ahi ?????
        contentValues.put(DESCRIPCION,tipoActividad.getDescripcion());

        return mDatabase.insert(TIPOACTIVIDAD_TABLE,null,contentValues);
    }

    public int actualizarTipoActividad(TipoDeActividad tipoActividad){
        ContentValues contentValues= new ContentValues();

        contentValues.put(ID_TIPO_ACTIVIDAD,tipoActividad.getId_tipo_actividad());
        contentValues.put(NOMBRE_ACTIVIDAD,tipoActividad.getNombre_actividad());
        contentValues.put(HORAS,tipoActividad.getCantidad_horas()); //dudas ahi ???????
        contentValues.put(DESCRIPCION,tipoActividad.getDescripcion());

        String where=ID_TIPO_ACTIVIDAD + "= ?";
        String[] whereArgs = {tipoActividad.getId_tipo_actividad() };
        return mDatabase.update(TIPOACTIVIDAD_TABLE, contentValues, where, whereArgs);
    }

    public int eliminarTipoActividad(String id_tipo_actividad){
        String where = ID_TIPO_ACTIVIDAD + "= ?";
        String[] whereArgs={id_tipo_actividad};

        return mDatabase.delete(TIPOACTIVIDAD_TABLE, where, whereArgs);
    }

    public ArrayList<TipoDeActividad> getListaTiposActividad(){
        String query = "SELECT * FROM " + TIPOACTIVIDAD_TABLE;
        Cursor cursor = mDatabase.rawQuery(query,null);

        ArrayList<TipoDeActividad> tiposActividades = new ArrayList<TipoDeActividad>();
        while (cursor.moveToNext()){
            tiposActividades.add(getTiposActividadesPorCursor(cursor));
        }
        if (cursor!=null){
            cursor.close();
        }
        return tiposActividades;
    }

    public TipoDeActividad getTipoDeActividad(String id_tipo_actividad){
        String where = ID_TIPO_ACTIVIDAD + "= ?";
        String whereArgs[] = {id_tipo_actividad};

        Cursor cursor=mDatabase.query(TIPOACTIVIDAD_TABLE, null, where, whereArgs, null, null, null);
        cursor.moveToFirst();
        TipoDeActividad temp = getTiposActividadesPorCursor(cursor);
        if (cursor!=null){
            cursor.close();
        }
        return temp;
    }

    private static TipoDeActividad getTiposActividadesPorCursor(Cursor cursor){
        if (cursor==null || cursor.getCount()==0){
            return null;
        }else {
            try {
                return new TipoDeActividad(
                        cursor.getString(ID_COL),
                        cursor.getString(NOMBRE_COL),
                        cursor.getInt(HORAS_COL), //dudas ?????
                        cursor.getString(DESCRIP_COL));
            }catch (Exception e){
                Log.i("EXE",e.toString());
                return null;
            }
        }
    }
}
