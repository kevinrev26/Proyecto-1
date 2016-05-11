package grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Controladores;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Controladores.Coordinador.ActualizarCoordinador;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Controladores.Coordinador.AgregarCoordinador;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Controladores.Coordinador.EliminarCoordinador;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.DAO.CoordinadorDAO;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Modelo.Coordinador;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.R;

public class CoordinadorActivity extends AppCompatActivity implements View.OnClickListener{


    //TAG de la clase
    public static final String TAG = "CoordinadorActivity";

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


    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.btnLlenarBase:

                llenarCoordinadores();
                Toast.makeText(CoordinadorActivity.this, "llenado de la base de datos, verificar...", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnAgregarCoordinador:
                //Toast.makeText(CoordinadorActivity.this, "Activity agregar coordinador", Toast.LENGTH_SHORT).show();
                intent = new Intent(this.getApplicationContext(), AgregarCoordinador.class);
                startActivity(intent);
                break;
            case R.id.btnActualizarCoordinador:
                intent = new Intent(this.getApplicationContext(), ActualizarCoordinador.class);
                startActivity(intent);
                //Toast.makeText(CoordinadorActivity.this, "Activity actualizar coordinador", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnEliminarCoordinador:
                //Toast.makeText(CoordinadorActivity.this, "Activity eliminar coordinador", Toast.LENGTH_SHORT).show();
                intent = new Intent(this.getApplicationContext(), EliminarCoordinador.class);
                startActivity(intent);
                break;
            case R.id.btnVerCoordinadores:
                cargarCoordinadores();
                for (Coordinador c : coordinadores){
                    Log.i(TAG,c.toString());
                }
                Toast.makeText(CoordinadorActivity.this, "Revisar LOGCAT", Toast.LENGTH_SHORT).show();
                break;

        }
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
