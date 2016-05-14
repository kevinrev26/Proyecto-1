package grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Controladores.Tutor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.DAO.TutorDAO;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Modelo.Tutor;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.R;

public class AgregarTutor extends AppCompatActivity implements View.OnClickListener{

    //wdigets
    private EditText editTextNombre, editTextTelefono, editTextCorreo;
    private Button btnAgregarTutor;

    //DAO
    TutorDAO mTutorDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_tutor);
        mTutorDAO = new TutorDAO(AgregarTutor.this);
        //EnlazarWidgets
        enlazarWidgets();
        //SetListeners
        setListeners();


    }

    private void enlazarWidgets(){
        editTextCorreo = (EditText) findViewById(R.id.editTextCorreoTutor);
        editTextNombre = (EditText) findViewById(R.id.editTextNombreTutor);
        editTextTelefono = (EditText) findViewById(R.id.editTextTelefonoTutor);

        btnAgregarTutor = (Button) findViewById(R.id.btnAgregarNuevoTutor);
    }


    private void setListeners(){
        btnAgregarTutor.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if (!validarVacios()){
            Toast.makeText(AgregarTutor.this, "Algun campo esta vacio,", Toast.LENGTH_SHORT).show();
        } else {
            if (validarTelefono()){
                Toast.makeText(AgregarTutor.this, "El telefono no es valido", Toast.LENGTH_SHORT).show();
            } else {

                Tutor temp = new Tutor();
                temp.setNombre(editTextNombre.getText().toString());
                temp.setEmail(editTextCorreo.getText().toString());
                temp.setTelefono(editTextTelefono.getText().toString());

                if (mTutorDAO.insertarTutor(temp)>0){
                    Toast.makeText(AgregarTutor.this, "Tutor agregado con exito", Toast.LENGTH_SHORT).show();
                    this.finish();
                } else {
                    Toast.makeText(AgregarTutor.this, "Ocurrio algun problema al agregar", Toast.LENGTH_SHORT).show();
                }
            }
        }

    }


    //Validaciones
    public boolean validarVacios(){
        if (editTextCorreo.getText().toString().equals("") ||
                editTextTelefono.getText().toString().equals("") ||
                editTextNombre.getText().toString().equals("")){
            return false;

        } else {
            return true;
        }
    }

    public boolean validarTelefono(){
        if (editTextTelefono.getText().length() < 8){
            return true;
        } else {
            return false;
        }
    }
}
