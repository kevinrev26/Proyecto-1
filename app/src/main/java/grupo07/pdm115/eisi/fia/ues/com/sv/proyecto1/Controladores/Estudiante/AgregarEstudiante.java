package grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Controladores.Estudiante;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.R;

public class AgregarEstudiante extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener{

    //Widgets
    private EditText mCarnetText, mNombreText, mTelText, mCorreoText;
    private Spinner mSpinnerCarreras;
    private Button mBtnAgregar;

    //Variable para controlar la seleccion del spinner;
    private String seleccion;

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
}
