package grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Controladores;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.DAO.EstudianteDAO;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Modelo.Estudiante;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.R;

public class EstudianteActivity extends AppCompatActivity implements View.OnClickListener{

    //TAG de la clase
    public static final String TAG = "EstudianteActivity";

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
        Log.i("DAO","Metodo on Create");

        //EnlazarWidgets
        enlazarWidgets();
        //Establecer los listeners
        setListeners();

    }

    private void enlazarWidgets(){
        btnLlenarBD = (Button) findViewById(R.id.btnLlenarDB);
        btnActualizar = (Button) findViewById(R.id.btnActualizar);
        btnAgregar = (Button) findViewById(R.id.btnAgregar);
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

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnLlenarDB:
                //Llenar base de datos
                llenarDB();
                break;
            case R.id.btnAgregar:
                //Cargar activity para el formulario
                Toast.makeText(EstudianteActivity.this, "Proximamente Agregar", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnActualizar:
                //Cargar activity para actualizar
                Toast.makeText(EstudianteActivity.this, "Proximamente Actualizar", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnEliminar:
                //Cargar activity para eliminar un elemento
                Toast.makeText(EstudianteActivity.this, "Proximamente eliminar", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnSeleccionar:
                //Cargar activity para ver todos los elementos
                ArrayList<Estudiante> estudiantes = mEstudianteDAO.getListaEstudiantes();
                for(Estudiante e : estudiantes){
                    Log.i("DAO",e.toString());
                }
                Toast.makeText(EstudianteActivity.this, "Revisar LOGCAT", Toast.LENGTH_SHORT).show();
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
