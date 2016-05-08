package grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Controladores;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Controladores.Estudiante.AgregarEstudiante;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Controladores.Estudiante.EliminarEstudiante;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Controladores.Estudiante.SeleccionarEstudiante;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.DAO.EstudianteDAO;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Modelo.Estudiante;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.R;

public class EstudianteActivity extends AppCompatActivity implements View.OnClickListener{

    //TAG de la clase
    public static final String TAG = "EstudianteActivity";


    private ArrayList<Estudiante> estudiantes = null;
    //Botones para controlar la app
    private Button btnLlenarBD, btnAgregar, btnActualizar,
                   btnEliminar, btnLeer;
    private EstudianteDAO mEstudianteDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estudiante);
        //Instanciando el DAO
        mEstudianteDAO = new EstudianteDAO(EstudianteActivity.this);
        Log.i("DAO", "Metodo on Create");

        //EnlazarWidgets
        enlazarWidgets();
        //Establecer los listeners
        setListeners();



    }

    private void enlazarWidgets(){
        btnLlenarBD = (Button) findViewById(R.id.btnLlenarDB);
        btnActualizar = (Button) findViewById(R.id.btnActualizar);
        btnAgregar = (Button) findViewById(R.id.btnAgregarEstudiante);
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

    private void cargarEstudiantes(){
        estudiantes = mEstudianteDAO.getListaEstudiantes();
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()){

            case R.id.btnLlenarDB:
                //Llenar base de datos
                llenarDB();
                break;
            case R.id.btnAgregarEstudiante:
                //Cargar activity para el formulario
                intent = new Intent(this.getApplicationContext(), AgregarEstudiante.class);
                startActivity(intent);
                break;
            case R.id.btnActualizar:
                //Cargar activity para actualizar
                Toast.makeText(EstudianteActivity.this, "Proximamente Actualizar", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnEliminar:
                //Cargar activity para eliminar un elemento
                //Toast.makeText(EstudianteActivity.this, "Proximamente eliminar", Toast.LENGTH_SHORT).show();
                intent = new Intent(this.getApplicationContext(), EliminarEstudiante.class);
                startActivity(intent);
                break;
            case R.id.btnSeleccionar:
                //Cargar activity para ver todos los elementos
                cargarEstudiantes();
                //Toast.makeText(EstudianteActivity.this, "Revisar LOGCAT", Toast.LENGTH_SHORT).show();
                intent = new Intent(this.getApplicationContext(), SeleccionarEstudiante.class);
                intent.putExtra("estudiantes",estudiantes);
                startActivity(intent);
                break;

        }
    }

    /*
    *
    * Metodo harcodeado para agregar Estudiantes, se incova al cliquear el button "Llenar BD"
    * */
    private void llenarDB(){
        if (mEstudianteDAO.insertarEstudiante(new Estudiante("RM11014","Sistemas Informaticos",
                                            "kevinrev26@gmail.com","7018-6743","Kevin Rivera")) > 0){
            Toast.makeText(EstudianteActivity.this, "Registro Insertado", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(EstudianteActivity.this, "Error al insertar ", Toast.LENGTH_SHORT).show();
        }
    }
}
