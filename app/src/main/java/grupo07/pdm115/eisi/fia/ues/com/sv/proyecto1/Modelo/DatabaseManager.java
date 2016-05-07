package grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Modelo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Creado por Kevin Rivera, 05-07-16.
 * Puede usar, modificar y compartir este archivo
 * Consultas y mas: kevinrev26@gmail.com
 */
public class DatabaseManager extends SQLiteOpenHelper{

    //Constantes para la base de datos
    private static final String DB_NAME = "grupo07_pdm.db";
    private static final int DB_VERSION = 1;
    private static final String LLAVE_FORANEA = "PRAGMA foreign_keys=ON;";

    //Clase con una instancia en si misma, para controlar la creacion de objetos
    private static DatabaseManager mInstance;

    //metodo que devuelve la misma instancia de la clase Helper, para prevenir
    //fallos en la ejecucion
    public static synchronized DatabaseManager getInstance(Context context){

        if (mInstance !=null){
            mInstance = new DatabaseManager(context,DB_NAME,null,DB_VERSION);
        }
            return mInstance;

    }

    private DatabaseManager(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public synchronized void close() {
        super.close();
    }


    /*
    * Este metodo se invoca cuando se crea por primera vez la base de datos.
    * Es aqui donde se llaman los metodos estaticos de las clases entidades de nuestro
    * modelo
    */
    @Override
    public void onCreate(SQLiteDatabase db) {
        //Llamadas a los metodos estaticos
        //Cuidado con aquellas entidades con llaves foraneas, esas deben crearse al final
        db.execSQL(Coordinador.crearTablaCoordinador());
        db.execSQL(Estudiante.crearTablaEstudiante());
    }


    /*
    * Este metodo es invocado con Android cuando se abre la base de datos, aqui se realizan
    * configuraciones adicionales, para nuestro caso, se deben activar las llaves foraneas
    */
    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        //Se verifica si la base de datos no esta como solo lectura, de ser asi, no hay necesidad
        //para activar las llaves foraneas ya que no se escribira nada
        if (!db.isReadOnly()){
            db.execSQL(LLAVE_FORANEA);
        }

    }


    /*
    * Este metodo es invocado por Android cuando la version de la base de datos ha cambiado
    * Si ha cambiado la version, es porque la definicion del modelo de datos ha cambiado
    * (Se agregado/eliminado una llave primaria, editado algun otro campo, etc ...)
    *
    */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Se ha modificado de la version oldVersion a newVersion
        //Se ejecutan los metodos estaticos para eliminar las tablas de las entidades
        db.execSQL(Coordinador.eliminarTablaCoordinador());
        db.execSQL(Estudiante.eliminarTablaEstudiante());
        //Luego se manda a llamar el metodo para crear la base
        onCreate(db);

    }


}
