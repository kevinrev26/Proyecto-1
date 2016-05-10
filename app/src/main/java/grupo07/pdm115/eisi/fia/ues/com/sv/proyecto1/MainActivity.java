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
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Apoyo.Adapter;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Apoyo.Clase;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Controladores.BitacoraActivity;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Controladores.CoordinadorActivity;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Controladores.EstudianteActivity;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Controladores.TipoDeActividadActivity;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Modelo.TipoDeActividad;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    //Widgets
    private ListView mLista;

    //Adaptador que implementa el comportamiento del llenado de cada item de la lista
    private Adapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Enlazando los widgets
        bindWidgets();
        //Enlanzado el adapter para la listView
        mLista.setAdapter(mAdapter = new Adapter(this.getApplicationContext()));
        //Configurando los escuchadores
        setListeners();
        //Creando las opciones del menu
        crearClases();


    }

    private void bindWidgets(){
        mLista = (ListView) findViewById(R.id.listaActivities);

    }

    private void setListeners(){
        mLista.setOnItemClickListener(this);

    }

    /*
    * Este metodo crea un objeto de la clase Clase para agregar su descripcion
    * y titulo. El titulo lo provee el nombre de los controladores y la descripcion
    * existe en el archivo Strings, para su posible traduccion
    *
    * */
    private void crearClases(){
        Clase temp;
        temp = new Clase(getResources().getString(R.string.CoordinadorActivity), CoordinadorActivity.TAG);
        mAdapter.addClase(temp);
        temp = new Clase(getResources().getString(R.string.EstudianteActivity),EstudianteActivity.TAG);
        mAdapter.addClase(temp);
        temp = new Clase(getResources().getString(R.string.BitacoraActivity), BitacoraActivity.TAG);
        mAdapter.addClase(temp);
        temp = new Clase(getResources().getString(R.string.TipoDeActividadActivity), TipoDeActividadActivity.TAG);
        mAdapter.addClase(temp);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Clase temp = mAdapter.getItem(position);
        Toast.makeText(MainActivity.this, "Seleccionado: " + temp.getNombreClase(), Toast.LENGTH_SHORT).show();
        try{
            Class<?> clase = Class.forName("grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Controladores." +temp.getNombreClase());
            Intent intent = new Intent(this,clase);
            this.startActivity(intent);
        } catch (ClassNotFoundException e){
            Log.i("EXE",e.toString());
        }
    }
}