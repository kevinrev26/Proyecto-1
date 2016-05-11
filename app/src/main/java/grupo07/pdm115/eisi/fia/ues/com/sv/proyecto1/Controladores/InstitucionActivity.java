package grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Controladores;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.DAO.InstitucionDAO;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Modelo.Institucion;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.R;

public class InstitucionActivity extends AppCompatActivity implements View.OnClickListener{

    //TAG de la clase
    public static final String TAG = "InstitucionActivity";

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

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnLlenarDBIns:
                //Llenar base de datos
                llenarDB();
                break;
            case R.id.btnAgregarIns:
                //Cargar activity para el formulario
                Toast.makeText(InstitucionActivity.this, "Proximamente Agregar", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnActualizarIns:
                //Cargar activity para actualizar
                Toast.makeText(InstitucionActivity.this, "Proximamente Actualizar", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnEliminarIns:
                //Cargar activity para eliminar un elemento
                Toast.makeText(InstitucionActivity.this, "Proximamente eliminar", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnSeleccionarIns:
                //Cargar activity para ver todos los elementos
                ArrayList<Institucion> instituciones = mInstitucionDAO.getListaInstitucion();
                for(Institucion i : instituciones){
                    Log.i("DAO",i.toString());
                }
                Toast.makeText(InstitucionActivity.this, "Revisar LOGCAT", Toast.LENGTH_SHORT).show();
                break;

        }
    }

    /*
    *
    * Metodo harcodeado para agregar Instituciones, se incova al cliquear el button "Llenar BD"
    * */
    private void llenarDB(){
        if (mInstitucionDAO.insertarInstitucion(new Institucion("00002","EIQUIA",
                "eiquia@gmail.com","Ingra. Tania","2222-2222","")) > 0){
            Toast.makeText(InstitucionActivity.this, "Registro Insertado", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(InstitucionActivity.this, "Error al insertar ", Toast.LENGTH_SHORT).show();
        }
    }
}
