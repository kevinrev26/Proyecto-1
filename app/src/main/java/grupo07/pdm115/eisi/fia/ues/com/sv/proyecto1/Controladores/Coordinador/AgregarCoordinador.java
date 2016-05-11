package grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Controladores.Coordinador;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.DAO.CoordinadorDAO;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Modelo.Coordinador;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.R;

public class AgregarCoordinador extends AppCompatActivity implements View.OnClickListener{

    //wdigets
    private EditText editTextNombre, editTextTelefono, editTextCorreo;
    private Button btnAgregar;

    //DAO
    CoordinadorDAO mCoordinadorDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_coordinador);
        mCoordinadorDAO = new CoordinadorDAO(AgregarCoordinador.this);
        //EnlazarWidgets
        enlazarWidgets();
        //SetListeners
        setListeners();


    }

    private void enlazarWidgets(){
        editTextCorreo = (EditText) findViewById(R.id.editTextCorreoCoordinador);
        editTextNombre = (EditText) findViewById(R.id.editTextNombreCoordinador);
        editTextTelefono = (EditText) findViewById(R.id.editTextTelefonoCoordinador);

        btnAgregar = (Button) findViewById(R.id.btnAgregarCoordinador);
    }


    private void setListeners(){
        btnAgregar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if (!validarVacios()){
            Toast.makeText(AgregarCoordinador.this, "Algun campo esta vacio,", Toast.LENGTH_SHORT).show();
        } else {
            if (validarTelefono()){
                Toast.makeText(AgregarCoordinador.this, "El telefono no es valido", Toast.LENGTH_SHORT).show();
            } else {

                Coordinador temp = new Coordinador();
                temp.setNombre(editTextNombre.getText().toString());
                temp.setEmail(editTextCorreo.getText().toString());
                temp.setTelefono(editTextTelefono.getText().toString());

                if (mCoordinadorDAO.insertarCoordinador(temp)>0){
                    Toast.makeText(AgregarCoordinador.this, "Coordinador agregado con exito", Toast.LENGTH_SHORT).show();
                    this.finish();
                } else {
                    Toast.makeText(AgregarCoordinador.this, "Ocurrio algun problema al agregar", Toast.LENGTH_SHORT).show();
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
