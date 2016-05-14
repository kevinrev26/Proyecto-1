package grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Controladores;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Controladores.TipoDeActividad.ActualizarTipoDeActividad;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Controladores.TipoDeActividad.AgregarTipoDeActividad;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Controladores.TipoDeActividad.EliminarTipoDeActividad;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Controladores.TipoDeActividad.SeleccionarTipoDeActividad;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.DAO.TipoDeActividadDAO;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Modelo.TipoDeActividad;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.R;

public class TipoDeActividadActivity extends AppCompatActivity implements View.OnClickListener {

    //TAG de la clase
    public static final String TAG = "TipoDeActividadActivity";
    private ArrayList<TipoDeActividad> tipoActividad = null;

    //Botones para controlar la app
    private Button BtnLlenarBD, BtnAgregar, BtnActualizar, BtnEliminar, BtnLeer;
    private TipoDeActividadDAO mTipoDeActividadDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipo_de_actividad);

        //Intanciando el DAO
        mTipoDeActividadDAO = new TipoDeActividadDAO(TipoDeActividadActivity.this);
        //Log.i("DAO", "Metodo on Create");

        //EnlazarWidgets
        anclarWidgets();
        //Establecer los listeners
        setListener();
    }

    private void anclarWidgets() {
        BtnLlenarBD = (Button) findViewById(R.id.btnLlenarTipAcDB);
        BtnActualizar = (Button) findViewById(R.id.btnActualizarTipoActividad);
        BtnAgregar = (Button) findViewById(R.id.btnAgregarTipoDeActividad);
        BtnEliminar = (Button) findViewById(R.id.btnEliminarTP);
        BtnLeer = (Button) findViewById(R.id.btnSeleccionarTP);
    }

    private void setListener() {
        BtnLeer.setOnClickListener(this);
        BtnEliminar.setOnClickListener(this);
        BtnAgregar.setOnClickListener(this);
        BtnActualizar.setOnClickListener(this);
        BtnLlenarBD.setOnClickListener(this);
    }

    private void cargarTipoActividad() {
        tipoActividad = mTipoDeActividadDAO.getListaTiposActividad();
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.btnLlenarTipAcDB:
                llenarDB();
                break;
            case R.id.btnAgregarTipoDeActividad:
                intent = new Intent(this.getApplicationContext(), AgregarTipoDeActividad.class);
                startActivity(intent);
                break;
            case R.id.btnActualizarTipoActividad:
                intent = new Intent(this.getApplicationContext(), ActualizarTipoDeActividad.class);
                startActivity(intent);
                break;
            case R.id.btnEliminarTP:
                intent = new Intent(this.getApplicationContext(), EliminarTipoDeActividad.class);
                startActivity(intent);
                break;
            case R.id.btnSeleccionarTP:
                cargarTipoActividad();
                intent = new Intent(this.getApplicationContext(), SeleccionarTipoDeActividad.class);
                intent.putExtra("tipos de actividades", tipoActividad);
                startActivity(intent);
                break;
        }
    }

    private void llenarDB() {
        if (mTipoDeActividadDAO.insertarTipoActividad(new TipoDeActividad("ABCDf", "Limpieza", 400, "Limpieza Impresora")) > 0) {
            Toast.makeText(TipoDeActividadActivity.this, "Registro Isertado con Exito", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(TipoDeActividadActivity.this, "Error al insertar", Toast.LENGTH_SHORT).show();
        }
    }
}


