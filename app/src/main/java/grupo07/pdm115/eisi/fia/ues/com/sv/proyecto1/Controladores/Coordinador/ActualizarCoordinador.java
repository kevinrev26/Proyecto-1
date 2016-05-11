package grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Controladores.Coordinador;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.DAO.CoordinadorDAO;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Modelo.Coordinador;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.R;

public class ActualizarCoordinador extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener{

    //Widgets
    private EditText editNombreCoordinador, editTelefonoCoordinador, editCorreoCoordinador;
    private Spinner mSpinner;
    private Button  btnActualizarCoordinador;

    //referencia a coordinador
    Coordinador c;


    //DAO
    private CoordinadorDAO mCoordinadorDAO;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar_coordinador);
        mCoordinadorDAO = new CoordinadorDAO(ActualizarCoordinador.this);
        //EnlazarWidgets
        enlazarWidgets();

        //configurar spinner
        configurarSpinner();

        //setListeners
        setListeners();


    }

    private void enlazarWidgets(){
        editCorreoCoordinador = (EditText) findViewById(R.id.editTextActualizarCorreoCoordinador);
        editTelefonoCoordinador = (EditText) findViewById(R.id.editTextActualizarTelefonoCoordinador);
        editNombreCoordinador = (EditText) findViewById(R.id.editTextActutalizarNombreCoordinador);

        mSpinner = (Spinner) findViewById(R.id.spinnerActualizarCoordinador);
        btnActualizarCoordinador = (Button) findViewById(R.id.btnActualizarCoordinador);
    }

    private void configurarSpinner(){
        ArrayAdapter<Coordinador> adapter = new ArrayAdapter<Coordinador>(this,android.R.layout.simple_spinner_item,
                mCoordinadorDAO.getListaCoordinadores());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinner.setAdapter(adapter);
    }

    private void setListeners(){
        btnActualizarCoordinador.setOnClickListener(this);
        mSpinner.setOnItemSelectedListener(this);
    }
    //TODO validar campos coordinador
    @Override
    public void onClick(View v) {
        AlertDialog show = new AlertDialog.Builder(this)
                .setTitle("Actualizar coordinador")
                .setMessage("Se actualizara: " + c.getNombre() + ", ¿Esta seguro?")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        c.setNombre(editNombreCoordinador.getText().toString());
                        c.setTelefono(editTelefonoCoordinador.getText().toString());
                        c.setEmail(editCorreoCoordinador.getText().toString());

                        if (mCoordinadorDAO.actualizarCoordinador(c) == 1) {
                            Toast.makeText(ActualizarCoordinador.this, "Estudiante actualizado", Toast.LENGTH_SHORT).show();
                            ActualizarCoordinador.this.finish();
                        }
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // do nothing
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        c = (Coordinador) parent.getItemAtPosition(position);
        editCorreoCoordinador.setText(c.getEmail());
        editNombreCoordinador.setText(c.getNombre());
        editTelefonoCoordinador.setText(c.getTelefono());
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
