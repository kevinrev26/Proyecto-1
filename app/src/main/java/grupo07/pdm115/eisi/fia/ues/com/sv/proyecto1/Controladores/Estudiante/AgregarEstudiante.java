package grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Controladores.Estudiante;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.regex.Pattern;

import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.DAO.EstudianteDAO;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Modelo.Estudiante;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.R;

public class AgregarEstudiante extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener{

    //Widgets
    private EditText mCarnetText, mNombreText, mTelText, mCorreoText;
    private Spinner mSpinnerCarreras;
    private Button mBtnAgregar;

    //Variable para controlar la seleccion del spinner;
    private String seleccion;

    //Objeto para manejar el ingreso del nuevo estudiante
    private EstudianteDAO  mEstudianteDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_estudiante);
        //Enlanzando los widgets
        enlazarWidgets();
        //Estableciendo los escuchadores
        setListeners();
        //configurando el spinner
        configurarSpinner();
        //Referenciando el DAO
        mEstudianteDAO = new EstudianteDAO(AgregarEstudiante.this);
    }



    private void enlazarWidgets(){
        mCarnetText = (EditText) findViewById(R.id.carnetEdit);
        mNombreText = (EditText) findViewById(R.id.nombreEdit);
        mTelText = (EditText) findViewById(R.id.telEdit);
        mCorreoText = (EditText) findViewById(R.id.correoEdit);
        mSpinnerCarreras = (Spinner) findViewById(R.id.spinnerCarreras);
        mBtnAgregar = (Button) findViewById(R.id.btnAgregarNuevoEstudiante);
    }

    private void setListeners(){

        mBtnAgregar.setOnClickListener(this);
        mSpinnerCarreras.setOnItemSelectedListener(this);
    }

    /*
     * Configuracion del spinner
     */
    private void configurarSpinner(){
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.carreras_array,
                android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinnerCarreras.setAdapter(adapter);


    }

    @Override
    public void onClick(View v) {
        if (!validarVacios()){
            Toast.makeText(AgregarEstudiante.this, "Algun campo esta vacio", Toast.LENGTH_SHORT).show();
        } else {
            if (validarCarnet()){
                Toast.makeText(AgregarEstudiante.this, "El carnet debe comenzar con dos letras", Toast.LENGTH_SHORT).show();
            } else {
                Estudiante temp = new Estudiante(mCarnetText.getText().toString(),
                        mCarnetText.getText().toString().toUpperCase(),
                        mCorreoText.getText().toString(),
                        mTelText.getText().toString(),
                        mNombreText.getText().toString());
                if (mEstudianteDAO.insertarEstudiante(temp)>0){
                    Toast.makeText(AgregarEstudiante.this, "Estudiante agregado con exito", Toast.LENGTH_SHORT).show();
                    this.finish();
                } else {
                    Toast.makeText(AgregarEstudiante.this, "Ocurrio algun error al agregar el nuevo estudiante", Toast.LENGTH_SHORT).show();
                }
            } //Else validar carnet

        }//Else validar vacios

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        seleccion = parent.getItemAtPosition(position).toString();
        //Toast.makeText(AgregarEstudiante.this, "Seleccionado: " + seleccion, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        //Nothing
    }


    //Validaciones
    public boolean validarVacios(){
        if (mCarnetText.getText().toString().equals("") ||
                mNombreText.getText().toString().equals("") ||
                mCorreoText.getText().toString().equals("")){
            return false;

        } else {
            return true;
        }
    }

    public boolean validarCarnet(){
        if (mCarnetText.getText().toString().matches("^[A-Za-z]{2}\\d{5}$")){
            return false;
        } else {
           return true;
        }

    }
}


