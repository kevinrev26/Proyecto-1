package grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Controladores;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Controladores.Tutor.ActualizarTutor;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Controladores.Tutor.AgregarTutor;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Controladores.Tutor.EliminarTutor;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Controladores.Tutor.SeleccionarTutor;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.DAO.TutorDAO;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Modelo.Tutor;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.R;

public class TutorActivity extends AppCompatActivity implements View.OnClickListener{


    //TAG de la clase
    public static final String TAG = "TutorActivity";
    public static final int TOKEN = 50;

    //Widgets
    private Button btnAgregar, btnActualizar, btnLlenar, btnEliminar, btnVer;

    //Referencia al Dao
    private TutorDAO mTutorDAO;

    //Lista para cargar en memoria
    private ArrayList<Tutor> tutores;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutor);
        mTutorDAO = new TutorDAO(TutorActivity.this);
        //EnlazandoWidgets
        enlazarWdigets();
        //SetListeners
        setListeners();
        Log.i(this.TAG, "Valor del objeto mTutorDAO: " + mTutorDAO);

    }

    private void enlazarWdigets(){
        btnAgregar = (Button) findViewById(R.id.btnAgregarTutor);
        btnActualizar = (Button) findViewById(R.id.btnModificarTutor);
        btnLlenar = (Button) findViewById(R.id.btnLlenarBaseTutor);
        btnEliminar = (Button) findViewById(R.id.btnEliminarTutor);
        btnVer = (Button) findViewById(R.id.btnTodosTutores);
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
            case R.id.btnLlenarBaseTutor:

                llenarTutores();
                Toast.makeText(TutorActivity.this, "llenado de la base de datos, verificar...", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnAgregarTutor:
                //Toast.makeText(CoordinadorActivity.this, "Activity agregar coordinador", Toast.LENGTH_SHORT).show();
                intent = new Intent(this.getApplicationContext(), AgregarTutor.class);
                startActivity(intent);
                break;
            case R.id.btnModificarTutor:
                intent = new Intent(this.getApplicationContext(), ActualizarTutor.class);
                startActivity(intent);
                //Toast.makeText(TutorActivity.this, "Activity actualizar tutor", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnEliminarTutor:
                //Toast.makeText(TutorActivity.this, "Activity eliminar tutor", Toast.LENGTH_SHORT).show();
                intent = new Intent(this.getApplicationContext(), EliminarTutor.class);
                startActivity(intent);
                break;
            case R.id.btnTodosTutores:
                cargarTutores();
                intent = new Intent(this.getApplicationContext(), SeleccionarTutor.class);
                intent.putExtra("tutores",tutores);
                startActivity(intent);


                //Toast.makeText(TutorActivity.this, "Revisar LOGCAT", Toast.LENGTH_SHORT).show();
                break;

        }
    }

    private void cargarTutores(){
        tutores = mTutorDAO.getListaTutores();
    }


    private void llenarTutores(){
        Tutor temp;
        int validador;
        temp = new Tutor();
        temp.setNombre("Lic Otilia");
        temp.setEmail("Otilia@example.com");
        temp.setTelefono("75646132");
        validador = (int) mTutorDAO.insertarTutor(temp);
        temp = new Tutor();
        temp.setNombre("Mr Tom");
        temp.setEmail("tom@example.com");
        temp.setTelefono("75962378");
        validador += (int) mTutorDAO.insertarTutor(temp);

        if (validador>0){
            Toast.makeText(TutorActivity.this, "Se ingresaron los registros", Toast.LENGTH_SHORT).show();
        }
    }
}

