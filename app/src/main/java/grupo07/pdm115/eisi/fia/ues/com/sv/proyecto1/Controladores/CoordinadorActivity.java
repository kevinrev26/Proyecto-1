package grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Controladores;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Apoyo.SesionPermisos;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Controladores.Coordinador.ActualizarCoordinador;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Controladores.Coordinador.AgregarCoordinador;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Controladores.Coordinador.EliminarCoordinador;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Controladores.Coordinador.SeleccionarCoordinador;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.DAO.CoordinadorDAO;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Modelo.Coordinador;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.R;

public class CoordinadorActivity extends AppCompatActivity implements View.OnClickListener{


    //TAG de la clase
    public static final String TAG = "CoordinadorActivity";
    public static final int TOKEN = 20;

    //Constantes para permisos
    private static final int BTNLLENAR = 21; //Cambiada por objeto de prueba
    private static final int BTNAGREGAR = 22;
    private static final int BTNSELECCIONAR = 23;
    private static final int BTNACTUALIZAR = 24;
    private static final int BTNELIMINAR = 25;

    //Referencia de la sesion:
   // private SesionPermisos sesion;

    //Widgets
    private Button btnAgregar, btnActualizar, btnLlenar, btnEliminar, btnVer;

    //Referencia al Dao
    private CoordinadorDAO mCoordiandorDAO;

    //Lista para cargar en memoria
    private ArrayList<Coordinador> coordinadores;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinador);
        mCoordiandorDAO = new CoordinadorDAO(CoordinadorActivity.this);
        //EnlazandoWidgets
        enlazarWdigets();
        //SetListeners
        setListeners();
        //Log.i(this.TAG,"Valor del objeto mCoodinadorDAO: " + mCoordiandorDAO);
       // getSesion();


    }

    private void enlazarWdigets(){
        btnAgregar = (Button) findViewById(R.id.btnAgregarCoordinador);
        btnActualizar = (Button) findViewById(R.id.btnActualizarCoordinador);
        btnLlenar = (Button) findViewById(R.id.btnLlenarBase);
        btnEliminar = (Button) findViewById(R.id.btnEliminarCoordinador);
        btnVer = (Button) findViewById(R.id.btnVerCoordinadores);
    }

    private void setListeners(){
        btnAgregar.setOnClickListener(this);
        btnActualizar.setOnClickListener(this);
        btnLlenar.setOnClickListener(this);
        btnEliminar.setOnClickListener(this);
        btnVer.setOnClickListener(this);
    }

   /*
    private void getSesion(){
        Intent i = this.getIntent();
        sesion = (SesionPermisos) i.getSerializableExtra("sesion");
    }
    */


    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.btnLlenarBase:
                if(SesionPermisos.getPermiso(BTNLLENAR)!=0) {
                    llenarCoordinadores();
                } else {
                    toast("No tiene permisos para llenar la base de datos");
                }
                break;
            case R.id.btnAgregarCoordinador:
                if (SesionPermisos.getPermiso(BTNAGREGAR)!=0) {
                    intent = new Intent(this.getApplicationContext(), AgregarCoordinador.class);
                    startActivity(intent);
                } else {
                    toast("No tiene permisos para agregar coordinador");
                }
                break;
            case R.id.btnActualizarCoordinador:
                if (SesionPermisos.getPermiso(BTNACTUALIZAR)!=0) {
                    intent = new Intent(this.getApplicationContext(), ActualizarCoordinador.class);
                    startActivity(intent);
                } else {
                    toast("No tiene permisos para actualizar coordinador");
                }
                break;
            case R.id.btnEliminarCoordinador:
                if(SesionPermisos.getPermiso(BTNELIMINAR)!=0) {
                    intent = new Intent(this.getApplicationContext(), EliminarCoordinador.class);
                    startActivity(intent);
                } else {
                    toast("No tiene permisos para eliminar coordinador");
                }
                break;
            case R.id.btnVerCoordinadores:
                if (SesionPermisos.getPermiso(BTNSELECCIONAR)!=0) {
                    cargarCoordinadores();
                    intent = new Intent(this.getApplicationContext(), SeleccionarCoordinador.class);
                    intent.putExtra("coordinadores", coordinadores);
                    startActivity(intent);
                } else {
                    toast("No tiene permisos para ver los coordinadores");
                }
                break;

        }
    }

    private void toast(String msg){
        Toast.makeText(CoordinadorActivity.this, msg, Toast.LENGTH_SHORT).show();
    }

    private void cargarCoordinadores(){
        coordinadores = mCoordiandorDAO.getListaCoordinadores();
    }


    private void llenarCoordinadores(){
        Coordinador temp;
        int validador;
        temp = new Coordinador();
        temp.setNombre("Lic Nuila");
        temp.setEmail("nuila@example.com");
        temp.setTelefono("77661122");
        validador = (int) mCoordiandorDAO.insertarCoordinador(temp);
        temp = new Coordinador();
        temp.setNombre("Mr Elastico");
        temp.setEmail("elastico@example.com");
        temp.setTelefono("76761188");
        validador += (int) mCoordiandorDAO.insertarCoordinador(temp);

        if (validador>0){
            Toast.makeText(CoordinadorActivity.this, "Se ingresaron los registros", Toast.LENGTH_SHORT).show();
        }
    }
}
