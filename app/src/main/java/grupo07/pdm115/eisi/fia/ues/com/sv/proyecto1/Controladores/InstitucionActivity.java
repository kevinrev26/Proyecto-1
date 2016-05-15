package grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Controladores;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Controladores.Institucion.ActualizarInstitucion;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Controladores.Institucion.AgregarInstitucion;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Controladores.Institucion.EliminarInstitucion;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Controladores.Institucion.SeleccionarInstitucion;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.DAO.InstitucionDAO;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Modelo.Institucion;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.R;

public class InstitucionActivity extends AppCompatActivity implements View.OnClickListener{

    //TAG de la clase
    public static final String TAG = "InstitucionActivity";
    public static final int TOKEN = 110;

    private ArrayList<Institucion> instituciones = null;
    //Botones para controlar la app
    private Button btnLlenarBD, btnAgregar, btnActualizar,
            btnEliminar, btnLeer;
    private InstitucionDAO mInstitucionDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_institucion);
        //Instanciando el DAO
        mInstitucionDAO = new InstitucionDAO(InstitucionActivity.this);
        Log.i("DAO","Metodo on Create");

        //EnlazarWidgets
        enlazarWidgets();
        //Establecer los listeners
        setListeners();

    }

    private void enlazarWidgets(){
        btnLlenarBD = (Button) findViewById(R.id.btnLlenarDBIns);
        btnActualizar = (Button) findViewById(R.id.btnActualizarIns);
        btnAgregar = (Button) findViewById(R.id.btnAgregarIns);
        btnEliminar = (Button) findViewById(R.id.btnEliminarIns);
        btnLeer = (Button) findViewById(R.id.btnSeleccionarIns);
    }

    private void setListeners(){
        btnLeer.setOnClickListener(this);
        btnEliminar.setOnClickListener(this);
        btnAgregar.setOnClickListener(this);
        btnActualizar.setOnClickListener(this);
        btnLlenarBD.setOnClickListener(this);
    }

    private void cargarInstituciones(){instituciones = mInstitucionDAO.getListaInstitucion();
    }

    @Override
    public void onClick(View v) {
        Intent intent=null;
        switch (v.getId()){
            case R.id.btnLlenarDBIns:
                //Llenar base de datos
                llenarInstituciones();
                break;
            case R.id.btnAgregarIns:
                //Cargar activity para el formulario
                intent = new Intent(this.getApplicationContext(), AgregarInstitucion.class);
                startActivity(intent);
                break;
            case R.id.btnActualizarIns:
                //Cargar activity para actualizar
                intent = new Intent(this.getApplicationContext(), ActualizarInstitucion.class);
                startActivity(intent);
            case R.id.btnEliminarIns:
                //Cargar activity para eliminar un elemento
                intent = new Intent(this.getApplicationContext(), EliminarInstitucion.class);
                startActivity(intent);
                break;
            case R.id.btnSeleccionarIns:
                //Cargar activity para ver todos los elementos
                cargarInstituciones();
                intent = new Intent(this.getApplicationContext(), SeleccionarInstitucion.class);
                intent.putExtra("instituciones",instituciones);
                startActivity(intent);
                break;
        }
    }

    /*
    *
    * Metodo harcodeado para agregar Instituciones, se incova al cliquear el button "Llenar BD"
    * */
    private void llenarInstituciones(){
        Institucion temp;
        int validador;
        temp = new Institucion();
        temp.setNombreInstitucion("Quimica");
        temp.setEmailInstitucion("q@gmail.com");
        temp.setNombreEncargado("Tania");
        temp.setTelefono1("22222222");
        temp.setTelefono2("");
        validador = (int) mInstitucionDAO.insertarInstitucion(temp);
        temp = new Institucion();
        temp.setNombreInstitucion("EIM");
        temp.setEmailInstitucion("eiq@gmail.com");
        temp.setNombreEncargado("Gerson");
        temp.setTelefono1("22222222");
        temp.setTelefono2("");
        validador += (int) mInstitucionDAO.insertarInstitucion(temp);

        if (validador>0){
            Toast.makeText(InstitucionActivity.this, "Se ingresaron los registros", Toast.LENGTH_SHORT).show();
        }
    }
}
