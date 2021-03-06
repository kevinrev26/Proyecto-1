package grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Controladores;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Controladores.ServicioSocial.ActualizarServicioSocial;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Controladores.ServicioSocial.AgregarServicioSocial;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Controladores.ServicioSocial.EliminarServicioSocial;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Controladores.ServicioSocial.SeleccionarServicioSocial;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.DAO.ServicioSocialDAO;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Modelo.ServicioSocial;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.R;

public class ServicioSocialActivity extends AppCompatActivity implements View.OnClickListener{

    private ArrayList<ServicioSocial> servicioSociales = null;
    //TAG de la clase
    public static final String TAG = "ServicioSocialActivity";
    public static final int TOKEN = 60;

    //Botones para controlar la app
    private Button btnLlenarBD, btnAgregar, btnActualizar,
            btnEliminar, btnLeer;
    private ServicioSocialDAO mServicioSocialDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servicio_social);
        //Instanciando el DAO
        mServicioSocialDAO = new ServicioSocialDAO(ServicioSocialActivity.this);
        Log.i("DAO","Metodo on Create");

        //EnlazarWidgets
        enlazarWidgets();
        //Establecer los listeners
        setListeners();

    }

    private void enlazarWidgets(){
        btnLlenarBD = (Button) findViewById(R.id.btnLlenarDBSV);
        btnActualizar = (Button) findViewById(R.id.btnActualizarSV);
        btnAgregar = (Button) findViewById(R.id.btnAgregarSV);
        btnEliminar = (Button) findViewById(R.id.btnEliminarSV);
        btnLeer = (Button) findViewById(R.id.btnSeleccionarSV);
    }

    private void setListeners(){
        btnLeer.setOnClickListener(this);
        btnEliminar.setOnClickListener(this);
        btnAgregar.setOnClickListener(this);
        btnActualizar.setOnClickListener(this);
        btnLlenarBD.setOnClickListener(this);
    }

    private void cargarServiciosSociales(){
        servicioSociales = mServicioSocialDAO.getListaServicioSocials();
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()){
            case R.id.btnLlenarDBSV:
                //Llenar base de datos
                llenarDB();
                break;
            case R.id.btnAgregarSV:
                //Cargar activity para el formulario
                intent = new Intent(this.getApplicationContext(), AgregarServicioSocial.class);
                startActivity(intent);
                break;
            case R.id.btnActualizarSV:
                //Cargar activity para actualizar
                intent = new Intent(this.getApplicationContext(), ActualizarServicioSocial.class);
                startActivity(intent);
                break;
            case R.id.btnEliminarSV:
                //Cargar activity para eliminar un elemento
                intent = new Intent(this.getApplicationContext(), EliminarServicioSocial.class);
                startActivity(intent);
                break;
            case R.id.btnSeleccionarSV:
                //Cargar activity para ver todos los elementos
                cargarServiciosSociales();
                intent = new Intent(this.getApplicationContext(), SeleccionarServicioSocial.class);
                intent.putExtra("servicios_sociales",servicioSociales);
                startActivity(intent);

        }
    }

    /*
    *
    * Metodo harcodeado para agregar Estudiantes, se incova al cliquear el button "Llenar BD"
    * */

    private void llenarDB(){
        ServicioSocial temp;
        int validador;
        temp = new ServicioSocial();
        temp.setTitulo("Reparar");
        temp.setDescripcion("Arreglar");
        temp.setDisponible(1);
        temp.setCoordinadorAprobado(1);
        temp.setIdentificadorInstitucion(1);
        temp.setIdentificadorModalidad(1);
        temp.setIdentificadorTutor(1);
        validador = (int) mServicioSocialDAO.insertarServicioSocial(temp);
        temp = new ServicioSocial();
        temp.setTitulo("Reparar");
        temp.setDescripcion("Arreglar");
        temp.setDisponible(1);
        temp.setCoordinadorAprobado(1);
        temp.setIdentificadorInstitucion(1);
        temp.setIdentificadorModalidad(1);
        temp.setIdentificadorTutor(1);
        validador += (int) mServicioSocialDAO.insertarServicioSocial(temp);

        if (validador>0){
            Toast.makeText(ServicioSocialActivity.this, "Se ingresaron los registros", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(ServicioSocialActivity.this, "No se ingresaron los registros" , Toast.LENGTH_SHORT).show();
        }
    }
}

