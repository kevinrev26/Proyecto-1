package grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.DAO;


import android.content.Context;
import android.util.Log;

import java.util.ArrayList;

import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Modelo.TipoDeActividad;
/**
 * Created by Gabriel on 07/05/2016.
 */
public class TipoDeActividadDAO  extends MasterDAO
{
    private static final String TIPOACTIVIDAD_TABLE = "tipo_actividad";
    private static final String ID_TIPO_ACTIVIDAD = "id_tipo_actividad";
    private static final int ID_COL = 0;
    private static final String NOMBRE_ACTIVIDAD = "nombre_actividad";
    private static final int NOMBRE_COL = 1;
    private static final int HORAS = 0;
    private static final int HORAS_COL = 2;
    private static final String DESCRIPCION = "descripcion";
    private static final int DESCRIP_COL = 3;

    
    public TipoDeActividadDAO(Context ctx)
    {
        super(ctx);
        Log.i("DAO", "Dentro del constructor TipoDeActividad DAO");
    }

}
