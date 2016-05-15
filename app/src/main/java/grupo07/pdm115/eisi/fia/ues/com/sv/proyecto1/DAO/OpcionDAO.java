package grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.DAO;

import android.content.ContentValues;
import android.content.Context;

import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Controladores.BitacoraActivity;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Controladores.CoordinadorActivity;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Controladores.EstudianteActivity;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Controladores.InstitucionActivity;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Controladores.ModalidadActivity;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Controladores.ServicioSocialActivity;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Controladores.TipoDeActividadActivity;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Controladores.TutorActivity;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Modelo.Institucion;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Modelo.Opcion;

/**
 * Creado por Kevin Rivera, 05-12-16.
 * Puede usar, modificar y compartir este archivo
 * Consultas y mas: kevinrev26@gmail.com
 */
public class OpcionDAO  extends MasterDAO{

    //Constantes para las tablas
    public static final String OPCION_TABLE = "opcion";
    public static final String DESCRIPCION_OPCION = "desc_opcion";
    public static final int DESCRIPCION_OPCION_COL = 1;
    public static final String TOKEN = "token";
    public static final int TOKEN_COL = 0;

    public OpcionDAO(Context ctx) {
        super(ctx);
    }


    public static String crearTablaOpcion(){
        return "CREATE TABLE " + OPCION_TABLE + " (" +
                TOKEN + " INTEGER PRIMARY KEY NOT NULL, " +
                DESCRIPCION_OPCION + " TEXT " +
                ");";
    }


    public static String eliminarTablaOpcion(){
        return  "DROP TABLE IF EXISTS " + OPCION_TABLE;
    }

    public long insertarOpcion(Opcion opcion){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DESCRIPCION_OPCION,opcion.getDescripcionOpcion());
        contentValues.put(TOKEN,opcion.getToken());

        return mDatabase.insert(OPCION_TABLE,null,contentValues);
    }

    public int llenarOpciones(){
        long bandera =0;
        bandera += insertarOpcion(new Opcion(10, EstudianteActivity.TAG));
        bandera += insertarOpcion(new Opcion(20, CoordinadorActivity.TAG));
        bandera += insertarOpcion(new Opcion(30, TipoDeActividadActivity.TAG));
        bandera += insertarOpcion(new Opcion(40, BitacoraActivity.TAG));
        bandera += insertarOpcion(new Opcion(50, TutorActivity.TAG));
        bandera += insertarOpcion(new Opcion(60, ServicioSocialActivity.TAG));
        bandera += insertarOpcion(new Opcion(70, ModalidadActivity.TAG));
        //bandera += insertarOpcion(new Opcion(80, Especialidad.TAG));
        //bandera += insertarOpcion(new Opcion(90, DetalleEspecialidad.TAG));
        //bandera += insertarOpcion(new Opcion(100, DetalleServicioSocial.TAG));
        bandera += insertarOpcion(new Opcion(110, InstitucionActivity.TAG));

        //Estudiante
        bandera += insertarOpcion(new Opcion(11, "Llenar Base Estudiante"));
        bandera += insertarOpcion(new Opcion(12, "Crear estudiante"));
        bandera += insertarOpcion(new Opcion(13, "Seleccionar estudiante"));
        bandera += insertarOpcion(new Opcion(14, "Actualizar Estudiante"));
        bandera += insertarOpcion(new Opcion(15, "Eliminar Estudiante"));

        //Coordinador
        bandera += insertarOpcion(new Opcion(21, "Llenar Base Coordinador"));
        bandera += insertarOpcion(new Opcion(22, "Crear Coordinador"));
        bandera += insertarOpcion(new Opcion(23, "Seleccionar Coordinador"));
        bandera += insertarOpcion(new Opcion(24, "Actualizar Coordinador"));
        bandera += insertarOpcion(new Opcion(25, "Eliminar Coordinador"));

        //TipoDeActividad
        bandera += insertarOpcion(new Opcion(31, "Llenar Base Tipo de Actividad"));
        bandera += insertarOpcion(new Opcion(32, "Crear Tipo de Actividad"));
        bandera += insertarOpcion(new Opcion(33, "Seleccionar Tipo de Actividad"));
        bandera += insertarOpcion(new Opcion(34, "Actualizar Tipo de Actividad"));
        bandera += insertarOpcion(new Opcion(35, "Eliminar Tipo de Actividad"));

        //Bitacora
        bandera += insertarOpcion(new Opcion(41, "Llenar Base Bitacora"));
        bandera += insertarOpcion(new Opcion(42, "Crear Bitacora"));
        bandera += insertarOpcion(new Opcion(43, "Seleccionar Bitacora"));
        bandera += insertarOpcion(new Opcion(44, "Actualizar Bitacora"));
        bandera += insertarOpcion(new Opcion(45, "Eliminar Bitacora"));


        //Tutor
        bandera += insertarOpcion(new Opcion(51, "Llenar Base Tutor"));
        bandera += insertarOpcion(new Opcion(52, "Crear Tutor"));
        bandera += insertarOpcion(new Opcion(53, "Seleccionar Tutor"));
        bandera += insertarOpcion(new Opcion(54, "Actualizar Tutor"));
        bandera += insertarOpcion(new Opcion(55, "Eliminar Tutor"));

        //ServicioSocial
        bandera += insertarOpcion(new Opcion(61, "Llenar Base Servicio Social"));
        bandera += insertarOpcion(new Opcion(62, "Crear Servicio Social"));
        bandera += insertarOpcion(new Opcion(63, "Seleccionar Servicio Social"));
        bandera += insertarOpcion(new Opcion(64, "Actualizar Servicio Social"));
        bandera += insertarOpcion(new Opcion(65, "Eliminar Servicio Social"));

        //Modalidad
        bandera += insertarOpcion(new Opcion(71, "Llenar Base Modalidad"));
        bandera += insertarOpcion(new Opcion(72, "Crear Modalidad"));
        bandera += insertarOpcion(new Opcion(73, "Seleccionar Modalidad"));
        bandera += insertarOpcion(new Opcion(74, "Actualizar Modalidad"));
        bandera += insertarOpcion(new Opcion(75, "Eliminar Modalidad"));

        //Especialidad

        //DetalleEspecialidad

        //DetalleServicioSocial

        //Institucion
        bandera += insertarOpcion(new Opcion(111, "Llenar Base Institucion"));
        bandera += insertarOpcion(new Opcion(112, "Crear Institucion"));
        bandera += insertarOpcion(new Opcion(113, "Seleccionar Institucion"));
        bandera += insertarOpcion(new Opcion(114, "Actualizar Institucion"));
        bandera += insertarOpcion(new Opcion(115, "Eliminar Institucion"));

        return(int)bandera;
    }
}
