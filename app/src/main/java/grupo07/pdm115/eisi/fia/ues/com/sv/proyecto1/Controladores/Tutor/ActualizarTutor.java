package grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Controladores.Tutor;

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

import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.DAO.TutorDAO;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Modelo.Tutor;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.R;

public class ActualizarTutor extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener{

    //Widgets
    private EditText editNombreTutor, editTelefonoTutor, editCorreoTutor;
    private Spinner mSpinner;
    private Button btnActualizarTutor;

    //referencia a tutor
    Tutor t;


    //DAO
    private TutorDAO mTutorDAO;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar_tutor);
        mTutorDAO = new TutorDAO(ActualizarTutor.this);
        //EnlazarWidgets
        enlazarWidgets();

        //configurar spinner
        configurarSpinner();

        //setListeners
        setListeners();


    }

    private void enlazarWidgets(){
        editCorreoTutor = (EditText) findViewById(R.id.editTextActualizarCorreoTutor);
        editTelefonoTutor = (EditText) findViewById(R.id.editTextActualizarTelefonoTutor);
        editNombreTutor = (EditText) findViewById(R.id.editTextActualizarNombreTutor);

        mSpinner = (Spinner) findViewById(R.id.spinnerActualizarTutor);
        btnActualizarTutor = (Button) findViewById(R.id.btnActualizarTutor);
    }

    private void configurarSpinner(){
        ArrayAdapter<Tutor> adapter = new ArrayAdapter<Tutor>(this,android.R.layout.simple_spinner_item,
                mTutorDAO.getListaTutores());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinner.setAdapter(adapter);
    }

    private void setListeners(){
        btnActualizarTutor.setOnClickListener(this);
        mSpinner.setOnItemSelectedListener(this);
    }
    //TODO validar campos tutor
    @Override
    public void onClick(View v) {
        AlertDialog show = new AlertDialog.Builder(this)
                .setTitle("Actualizar tutor")
                .setMessage("Se actualizara: " + t.getNombre() + ", ¿Esta seguro?")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        t.setNombre(editNombreTutor.getText().toString());
                        t.setTelefono(editTelefonoTutor.getText().toString());
                        t.setEmail(editCorreoTutor.getText().toString());

                        if (mTutorDAO.actualizarTutor(t) == 1) {
                            Toast.makeText(ActualizarTutor.this, "Tutor actualizado", Toast.LENGTH_SHORT).show();
                            ActualizarTutor.this.finish();
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
        t = (Tutor) parent.getItemAtPosition(position);
        editCorreoTutor.setText(t.getEmail());
        editNombreTutor.setText(t.getNombre());
        editTelefonoTutor.setText(t.getTelefono());
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
