package grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Controladores.Modalidad;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.DAO.ModalidadDAO;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Modelo.Modalidad;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.R;

public class AgregarModalidad extends AppCompatActivity implements View.OnClickListener{

    //wdigets
    private EditText editTextNombre, editTextIdentificador;
    private Button btnAgregar;

    //DAO
    ModalidadDAO ModDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_modalidad);
        ModDAO = new ModalidadDAO(AgregarModalidad.this);
        //EnlazarWidgets
        enlazarWidgets();
        //SetListeners
        setListeners();


    }

    private void enlazarWidgets(){
        editTextNombre = (EditText) findViewById(R.id.editTextNombreModalidad);

        btnAgregar = (Button) findViewById(R.id.btnAgregarNuevaModalidad);
    }


    private void setListeners(){
        btnAgregar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if (!validarVacios()){
            Toast.makeText(AgregarModalidad.this, "Algun campo esta vacio,", Toast.LENGTH_SHORT).show();
        } else {

                Modalidad temp = new Modalidad();
                temp.setNombre(editTextNombre.getText().toString());

                if (ModDAO.insertarModalidad(temp)>0){
                    Toast.makeText(AgregarModalidad.this, "Modalidad agregado con exito", Toast.LENGTH_SHORT).show();
                    this.finish();
                } else {
                    Toast.makeText(AgregarModalidad.this, "Ocurrio algun problema al agregar", Toast.LENGTH_SHORT).show();
                }

        }

    }


    //Validaciones
    public boolean validarVacios(){
        if (editTextNombre.getText().toString().equals("")){
            return false;

        } else {
            return true;
        }
    }

}
