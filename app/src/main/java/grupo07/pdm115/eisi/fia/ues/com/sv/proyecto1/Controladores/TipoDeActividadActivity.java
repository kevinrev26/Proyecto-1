package grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Controladores;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.DAO.TipoDeActividadDAO;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Modelo.TipoDeActividad;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.R;

public class TipoDeActividadActivity extends AppCompatActivity implements View.OnClickListener {

    //TAG de la clase
    public static final String TAG = "TipoDeActividadActivity";
    private ArrayList<TipoDeActividad> tipoActividad = null;

    //Botones para controlar la app
    private Button btnLlenarBD, btnAgregar, btnActualizar, btnEliminar, btnLeer;
    private TipoDeActividadDAO mTipoDeActividadDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipo_de_actividad);

        //Intanciando el DAO
        mTipoDeActividadDAO= new TipoDeActividadDAO(TipoDeActividadActivity.this);
        Log.i("DAO", "Metodo on Create");

        //EnlazarWidgets
        enlazarWidgets();
        //Establecer los listeners
        setListeners();
    }

    private void enlazarWidgets(){
        btnLlenarBD = (Button) findViewById(R.id.btnLlenarDB);
        btnActualizar = (Button) findViewById(R.id.btnActualizar);
        //btnAgregar = (Button) findViewById(R.id.btnAgregarTipoActividad);
        btnEliminar = (Button) findViewById(R.id.btnEliminar);
        btnLeer = (Button) findViewById(R.id.btnSeleccionar);
    }

    private void setListeners(){
        btnLeer.setOnClickListener(this);
        btnEliminar.setOnClickListener(this);
        btnAgregar.setOnClickListener(this);
        btnActualizar.setOnClickListener(this);
        btnLlenarBD.setOnClickListener(this);
    }

    private void cargarTipoActividad()
    {
        tipoActividad = mTipoDeActividadDAO.getListaTiposActividad();
    }

    @Override
    public void onClick(View v){
        Intent intent=null;
        switch (v.getId()){
            case R.id.btnLlenarDB:
               // llenarDB();
                break;
            //case R.id.
        }
    }

}
