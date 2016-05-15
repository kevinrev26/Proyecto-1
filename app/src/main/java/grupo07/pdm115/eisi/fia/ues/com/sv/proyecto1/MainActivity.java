package grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1;
/*
* ---------------------------------------------------------------
*               Descripcion de los paquetes
* ---------------------------------------------------------------
*
*   Apoyo: En este paquete se colocan aquellas clases que funcionan
*          o dan apoyo a las activities, otras clases, etc.
*
*   Controladores: En este paquete se colocaran las clases que controlan
*          las views o layouts de las activities.
*          Ademas se incluyen sub paquetes para manejar las activities
*          de cada opcion del CRUD
*
*   Modelo: Aqui se encontraran con los POJO de cada una de las entidades y con
*          el manejador de la base de datos.
*
*   DAO: En este paquete se encuentran los manejadores para cada una de las entidades
*       de la base de datos, cada debe extender de una clase madre, para implementar
*       algunas caracteristicas propias de cada una de las entidades.
*
*
*
*
*/
import android.content.Intent;
import android.app.AlertDialog;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Apoyo.Adapter;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Apoyo.Clase;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Apoyo.Sesion;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Apoyo.SesionPermisos;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Controladores.BitacoraActivity;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Controladores.CoordinadorActivity;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Controladores.EstudianteActivity;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Controladores.InstitucionActivity;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Controladores.ModalidadActivity;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Controladores.ServicioSocialActivity;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Controladores.TipoDeActividadActivity;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Controladores.TutorActivity;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.DAO.MasterDAO;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.DAO.OpcionDAO;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.DAO.PermisoDAO;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.DAO.UsuarioDAO;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Modelo.Institucion;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Modelo.Permiso;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Modelo.TipoDeActividad;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Modelo.Usuario;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    //Widgets
    private ListView mLista;

    //Adaptador que implementa el comportamiento del llenado de cada item de la lista
    private Adapter mAdapter;


    //DAO
    UsuarioDAO mUsuarioDAO;
    OpcionDAO  mOpcionDAO;
    PermisoDAO mPermisoDAO;
    MasterDAO master;

    //Sesion actual
    Sesion sesionActual;
    SesionPermisos sesion;

    private int usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Enlazando los widgets
        bindWidgets();
        //Enlanzado el adapter para la listView
        mLista.setAdapter(mAdapter = new Adapter(this.getApplicationContext()));
        //Sesiones
        sesionActual = new Sesion(this.getApplicationContext());
        sesion = new SesionPermisos(this.getApplicationContext());
        //Verificar primera vez en la app
        mUsuarioDAO = new UsuarioDAO(this.getApplicationContext());
        mPermisoDAO = new PermisoDAO(this.getApplicationContext());
        mOpcionDAO = new OpcionDAO(this.getApplicationContext());
        verificarInicio();
        //Verificando login
        sesion.checkLogin();
        //Configurando los escuchadores
        setListeners();
        //Creando las opciones del menu
        crearClases();



        //Agregar permisos
        agregarPermisos();

    }

    private void bindWidgets(){
        mLista = (ListView) findViewById(R.id.listaActivities);

    }

    private void setListeners(){
        mLista.setOnItemClickListener(this);

    }

    private void verificarInicio(){
        if (!sesionActual.isFirstTime()){
            //crearAlerta(master.versionDB());
            mUsuarioDAO.llenarUsuarios();
            mOpcionDAO.llenarOpciones();
            mPermisoDAO.llenarPermisos();
            //Editando la primera vez
            sesionActual.editFirstTime();
        }


    }

    private void agregarPermisos(){
        Intent i = this.getIntent();
        usuario = i.getIntExtra("usuario",0);
        for(Permiso p: mPermisoDAO.getPermisos(usuario)){
            Log.i("MainActivity",p.toString());
        }
        sesion.configurarPermisos(mPermisoDAO.getPermisos(usuario));
    }

    /*
    * Este metodo crea un objeto de la clase Clase para agregar su descripcion
    * y titulo. El titulo lo provee el nombre de los controladores y la descripcion
    * existe en el archivo Strings, para su posible traduccion
    *
    * */
    private void crearClases(){
        Clase temp;
        temp = new Clase(getResources().getString(R.string.CoordinadorActivity), CoordinadorActivity.TAG,CoordinadorActivity.TOKEN);
        mAdapter.addClase(temp);
        temp = new Clase(getResources().getString(R.string.EstudianteActivity),EstudianteActivity.TAG, EstudianteActivity.TOKEN);
        mAdapter.addClase(temp);

        temp = new Clase(getResources().getString(R.string.BitacoraActivity), BitacoraActivity.TAG, BitacoraActivity.TOKEN);
        mAdapter.addClase(temp);
        temp = new Clase(getResources().getString(R.string.TipoDeActividadActivity), TipoDeActividadActivity.TAG, TipoDeActividadActivity.TOKEN);
        mAdapter.addClase(temp);

        temp = new Clase(getResources().getString(R.string.InstitucionActivity), InstitucionActivity.TAG,InstitucionActivity.TOKEN);
        mAdapter.addClase(temp);
        temp = new Clase(getResources().getString(R.string.ServicioSocialActivity), ServicioSocialActivity.TAG, ServicioSocialActivity.TOKEN);
        mAdapter.addClase(temp);

        temp = new Clase(getResources().getString(R.string.ModalidadActivity), ModalidadActivity.TAG, ModalidadActivity.TOKEN);
        mAdapter.addClase(temp);
        temp = new Clase(getResources().getString(R.string.TutorActivity), TutorActivity.TAG, TutorActivity.TOKEN);
        mAdapter.addClase(temp);

    }

    private void crearAlerta(String version){

            AlertDialog.Builder show = new AlertDialog.Builder(MainActivity.this);
            show.setTitle("Version de la base de datos");
            show.setMessage(getResources().getString(R.string.AlertaBaseDeDatos)+ "\n\n"+
            getResources().getString(R.string.Version) + " " + version);
            show.show();

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Clase temp = mAdapter.getItem(position);

        try{
            Class<?> clase = Class.forName("grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Controladores." +temp.getNombreClase());
            int token = sesion.getPermiso(temp.getToken());
            Log.i("MainActivity",String.valueOf(token));
            if (token!=0) {
                Intent intent = new Intent(this.getApplicationContext(), clase);
                this.startActivity(intent);
                //Log.i("MainActivity","Llamado de la clase");
            } else {
                Toast.makeText(MainActivity.this, "No se tienen permisos para acceder a este recurso", Toast.LENGTH_SHORT).show();
            }
        } catch (ClassNotFoundException e){
            Log.i("EXE",e.toString());
        }

    }

    //Inflando las opciones del menu

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.servicio_social_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //
        switch (item.getItemId()){
            case R.id.menu_cerrarSesion:
                sesion.logout();
                //this.finish();
                return true;
                //break;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}