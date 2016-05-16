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
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Controladores.Estudiante.ActualizarEstudiante;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Controladores.Estudiante.AgregarEstudiante;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Controladores.Estudiante.EliminarEstudiante;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Controladores.Estudiante.SeleccionarEstudiante;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.DAO.EstudianteDAO;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Modelo.Estudiante;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.R;

public class EstudianteActivity extends AppCompatActivity implements View.OnClickListener{

    //TAG de la clase
    public static final String TAG = "EstudianteActivity";
    public static final int TOKEN = 10;

    //Constantes para permisos
    private static final int BTNLLENAR = 21;
    private static final int BTNAGREGAR = 22;
    private static final int BTNSELECCIONAR = 23;
    private static final int BTNACTUALIZAR = 24;
    private static final int BTNELIMINAR = 25;

    //Referencia a la sesion
   // private SesionPermisos sesion;

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
       // Log.i("DAO", "Metodo on Create");

        //EnlazarWidgets
        enlazarWidgets();
        //Establecer los listeners
        setListeners();
        //Referenciando la sesion
        //getSesion();




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
    /*
    private void getSesion(){
        Intent i = this.getIntent();
        sesion = (SesionPermisos) i.getSerializableExtra("sesion");
    } */

    private void cargarEstudiantes(){
        estudiantes = mEstudianteDAO.getListaEstudiantes();
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()){

            case R.id.btnLlenarDB:
                //Llenar base de datos
                if (SesionPermisos.getPermiso(BTNLLENAR)!=0) {
                    llenarDB();
                } else {
                    toast("No tiene permisos para llenar la base de datos");
                }
                break;
            case R.id.btnAgregarEstudiante:
                if (SesionPermisos.getPermiso(BTNAGREGAR)!=0) {
                    intent = new Intent(this.getApplicationContext(), AgregarEstudiante.class);
                    startActivity(intent);
                } else {
                    toast("No tiene permisos para agregar estudiante");
                }
                break;
            case R.id.btnActualizar:
                //Cargar activity para actualizar
                if(SesionPermisos.getPermiso(BTNACTUALIZAR)!=0) {
                    intent = new Intent(this.getApplicationContext(), ActualizarEstudiante.class);
                    startActivity(intent);
                } else {
                    toast("Usted ni tiene permisos para actualizar estudiante");
                }
                break;
            case R.id.btnEliminar:
                //Cargar activity para eliminar un elemento
                if(SesionPermisos.getPermiso(BTNELIMINAR)!=0) {
                    intent = new Intent(this.getApplicationContext(), EliminarEstudiante.class);
                    startActivity(intent);
                } else {
                    toast("No tiene permisos para eliminar estudiante");
                }
                break;
            case R.id.btnSeleccionar:
                //Cargar activity para ver todos los elementos
                if(SesionPermisos.getPermiso(BTNSELECCIONAR)!=0) {
                    cargarEstudiantes();
                    intent = new Intent(this.getApplicationContext(), SeleccionarEstudiante.class);
                    intent.putExtra("estudiantes", estudiantes);
                    startActivity(intent);
                } else {
                    toast("No tiene permisos para ver todos los estudiantes");
                }
                break;

        }
    }

    /*
    * Metodo para mostrar el toast
    *
    */
    private void toast(String msg){
        Toast.makeText(EstudianteActivity.this, msg, Toast.LENGTH_SHORT).show();
    }

    /*
    *
    * Metodo harcodeado para agregar Estudiantes, se incova al cliquear el button "Llenar BD"
    * */
    private void llenarDB(){
        if (mEstudianteDAO.insertarEstudiante(new Estudiante("RM11014","Ingenieria de Sistemas",
                                            "kevinrev26@gmail.com","70186743","Kevin Rivera")) > 0){
            Toast.makeText(EstudianteActivity.this, "Registro Insertado", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(EstudianteActivity.this, "Error al insertar ", Toast.LENGTH_SHORT).show();
        }
    }
}
