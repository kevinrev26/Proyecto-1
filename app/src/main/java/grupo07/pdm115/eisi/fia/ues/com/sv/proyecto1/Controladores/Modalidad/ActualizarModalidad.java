package grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Controladores.Modalidad;

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

import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.DAO.ModalidadDAO;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Modelo.Modalidad;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.R;

public class ActualizarModalidad extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener{

        //Widgets
        private EditText editActualizarNombreModalidad, editActualizarIdentificadorModalidad;
        private Spinner mSpinner;
        private Button  btnActualizarModalidad;

        //referencia a modalidad
        Modalidad m;


        //DAO
        private ModalidadDAO ModDAO;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_actualizar_modalidad);
            ModDAO = new ModalidadDAO(ActualizarModalidad.this);
            //EnlazarWidgets
            enlazarWidgets();

            //configurar spinner
            configurarSpinner();

            //setListeners
            setListeners();


        }

        private void enlazarWidgets(){
            editActualizarIdentificadorModalidad = (EditText) findViewById(R.id.editTextActualizarIdentificadorModalidad);
            editActualizarNombreModalidad = (EditText) findViewById(R.id.editTextActualizarNombreModalidad);

            mSpinner = (Spinner) findViewById(R.id.spinnerActualizarModalidad);
            btnActualizarModalidad = (Button) findViewById(R.id.btnActualizarModalidad);
        }

        private void configurarSpinner(){
            ArrayAdapter<Modalidad> adapter = new ArrayAdapter<Modalidad>(this,android.R.layout.simple_spinner_item,
                    ModDAO.getListaModalidades());
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            mSpinner.setAdapter(adapter);
        }

        private void setListeners(){
            btnActualizarModalidad.setOnClickListener(this);
            mSpinner.setOnItemSelectedListener(this);
        }
        //TODO validar campos modalidad
        @Override
        public void onClick(View v) {
            AlertDialog show = new AlertDialog.Builder(this)
                    .setTitle("Actualizar modalidad")
                    .setMessage("Se actualizara: " + m.getNombre() + ", ¿Esta seguro?")
                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            m.setNombre(editActualizarNombreModalidad.getText().toString());

                            if (ModDAO.actualizarModalidad(m) == 1) {
                                Toast.makeText(ActualizarModalidad.this, "Modalidad actualizada", Toast.LENGTH_SHORT).show();
                                ActualizarModalidad.this.finish();
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
            m = (Modalidad) parent.getItemAtPosition(position);
            editActualizarIdentificadorModalidad.setText(m.getIdModalidad());
            editActualizarNombreModalidad.setText(m.getNombre());
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }
