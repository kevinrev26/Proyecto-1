package grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Controladores;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Controladores.Modalidad.ActualizarModalidad;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Controladores.Modalidad.AgregarModalidad;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Controladores.Modalidad.EliminarModalidad;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Controladores.Modalidad.SeleccionarModalidad;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.DAO.ModalidadDAO;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Modelo.Modalidad;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.R;

public class ModalidadActivity extends AppCompatActivity implements View.OnClickListener{


    //TAG de la clase
    public static final String TAG = "ModalidadActivity";

    //Widgets
    private Button btnAgregar, btnActualizar, btnLlenar, btnEliminar, btnVer;

    //Referencia al Dao
    private ModalidadDAO ModDAO;

    //Lista para cargar en memoria
    private ArrayList<Modalidad> modalidades;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modalidad);
        ModDAO = new ModalidadDAO(ModalidadActivity.this);
        //EnlazandoWidgets
        enlazarWdigets();
        //SetListeners
        setListeners();


    }

    private void enlazarWdigets(){
        btnAgregar = (Button) findViewById(R.id.btnAgregarModalidad);
        btnActualizar = (Button) findViewById(R.id.btnActualizarModalidad);
        btnLlenar = (Button) findViewById(R.id.btnLlenarBaseModalidad);
        btnEliminar = (Button) findViewById(R.id.btnEliminarModalidad);
        btnVer = (Button) findViewById(R.id.btnTodasModalidades);
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
            case R.id.btnLlenarBaseModalidad:

                llenarModalidad();
                Toast.makeText(ModalidadActivity.this, "llenado de la base de datos, verificar...", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnAgregarModalidad:
                //Toast.makeText(ModalidadActivity.this, "Activity agregar modalidad", Toast.LENGTH_SHORT).show();
                intent = new Intent(this.getApplicationContext(), AgregarModalidad.class);
                startActivity(intent);
                break;
            case R.id.btnActualizarModalidad:
                intent = new Intent(this.getApplicationContext(), ActualizarModalidad.class);
                startActivity(intent);
                //Toast.makeText(ModalidadActivity.this, "Activity actualizar modalidad", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnEliminarModalidad:
                //Toast.makeText(ModalidadActivity.this, "Activity eliminar modalidad", Toast.LENGTH_SHORT).show();
                intent = new Intent(this.getApplicationContext(), EliminarModalidad.class);
                startActivity(intent);
                break;
            case R.id.btnTodasModalidades:
                cargarModalidad();
                intent = new Intent(this.getApplicationContext(), SeleccionarModalidad.class);
                intent.putExtra("modalidades",modalidades);
                startActivity(intent);


                //Toast.makeText(ModalidadActivity.this, "Revisar LOGCAT", Toast.LENGTH_SHORT).show();
                break;

        }
    }

    private void cargarModalidad(){
        modalidades = ModDAO.getListaModalidades();
    }


    private void llenarModalidad(){
        Modalidad temp;
        int validador;
        temp = new Modalidad();
        temp.setIdModalidad(123);
        temp.setNombre("Pasantia");
        validador = (int) ModDAO.insertarModalidad(temp);
        temp = new Modalidad();
        temp.setIdModalidad(321);
        temp.setNombre("Ayudantia");
        validador += (int) ModDAO.insertarModalidad(temp);

        if (validador>0){
            Toast.makeText(ModalidadActivity.this, "Se ingresaron los registros", Toast.LENGTH_SHORT).show();
        }
    }
}

