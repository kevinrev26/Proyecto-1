package grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Controladores.Estudiante;

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

import java.util.HashMap;
import java.util.Map;

import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.DAO.EstudianteDAO;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Modelo.Estudiante;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.R;

public class ActualizarEstudiante extends AppCompatActivity implements View.OnClickListener{

    //Wdigets
    private EditText editNombre, editTelefono,editCorreo;
    private Spinner mSpinnerCarrera, mSpinnerEstudiante;
    private Button mButtonActualizar;

    //Referencia de carrera
    private String seleccion;

    //Referencia de estudiante
    private Estudiante e;

    //Referencia al DAO
    private EstudianteDAO  mEstudianteDAO;

    //Diccionario para los vaores del spinner carreras
    Map<String,Integer> map = new HashMap<String,Integer>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar_estudiante);
        //Enlazar widgets
        enlazarWidgets();
        //llenar map
        llenarMap();
        mEstudianteDAO = new EstudianteDAO(ActualizarEstudiante.this);
        //ConfigurarSpinnerEstudiantes
        configurarSpinnerEstudiantes();
        //ConfigurarSpinnerCarrera
        configurarSpinnerCarreras();
        //SetListeners
        setListeners();
    }

    private void enlazarWidgets(){
        editCorreo = (EditText) findViewById(R.id.correoEditText);
        editNombre = (EditText) findViewById(R.id.nombreEditText);
        editTelefono = (EditText) findViewById(R.id.telEditText);
        mSpinnerCarrera = (Spinner) findViewById(R.id.spinnerCarreras);
        mSpinnerEstudiante = (Spinner) findViewById(R.id.spinnerEstudiantes);
        mButtonActualizar = (Button) findViewById(R.id.btnActualizar);
    }


    private void llenarMap(){
        map.put("Ingenieria Civil",0);
        map.put("Ingenieria Industrial",1);
        map.put("Ingenieria Electrica",2);
        map.put("Ingenieria en Alimentos",3);
        map.put("Ingenieria Quimica",4);
        map.put("Ingenieria de Sistemas",5);
        map.put("Arquitectura",6);
        map.put("Ingenieria Mecanica",7);
    }

    private void configurarSpinnerEstudiantes(){
        ArrayAdapter<Estudiante> adapter = new ArrayAdapter<Estudiante>(this,android.R.layout.simple_spinner_item,
                mEstudianteDAO.getListaEstudiantes());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinnerEstudiante.setAdapter(adapter);
    }

    private void configurarSpinnerCarreras(){
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.carreras_array,
                android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinnerCarrera.setAdapter(adapter);
    }

    private void setListeners(){
        mButtonActualizar.setOnClickListener(this);

        //Estudiantes
        mSpinnerEstudiante.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                e = (Estudiante) parent.getItemAtPosition(position);
                editNombre.setText(e.getNombre());
                editCorreo.setText(e.getEmail());
                editTelefono.setText(e.getTelefono());
                mSpinnerCarrera.setSelection(map.get(e.getCarrera()));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        //Carreras
        mSpinnerCarrera.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                seleccion = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //Nothing
            }
        });
    }
    //TODO Validar los campos de nombre e Email.
    @Override
    public void onClick(View v) {
        AlertDialog show = new AlertDialog.Builder(this)
                .setTitle("Actualizar estudiante")
                .setMessage("Se actualizara: " + e.getNombre() + ", ¿Esta seguro?")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        e.setNombre(editNombre.getText().toString());
                        e.setCarrera(seleccion);
                        e.setEmail(editCorreo.getText().toString());
                        e.setTelefono(editTelefono.getText().toString());
                        if (mEstudianteDAO.actualizarEstudiante(e) == 1) {
                            Toast.makeText(ActualizarEstudiante.this, "Estudiante actualizado", Toast.LENGTH_SHORT).show();
                            ActualizarEstudiante.this.finish();
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
}
