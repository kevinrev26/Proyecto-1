package grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Controladores.Bitacora;

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

import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.DAO.BitacoraDAO;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Modelo.Bitacora;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.R;

public class ActualizarBitacora extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    //Widgets
    private EditText editIdentificador, editFechaInicio, editFechaFin, editRevisionCoor, editRevTutor, editIdTipoAct;
    private Spinner mSpinner;
    private Button btnActualizarBitacora;

    //referencia a coordinador
    Bitacora c;


    //DAO
    private BitacoraDAO mBitacoraDAO;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar_bitacora);
        mBitacoraDAO = new BitacoraDAO(ActualizarBitacora.this);
        //EnlazarWidgets
        enlazarWidgets();

        //configurar spinner
        configurarSpinner();

        //setListeners
        setListeners();


    }

    private void enlazarWidgets(){
        editIdentificador = (EditText) findViewById(R.id.editTextActutalizarIdentificadorBitacora);
        editFechaInicio = (EditText) findViewById(R.id.editTextActutalizarFechaInicio);
        editFechaFin = (EditText) findViewById(R.id.editTextActutalizarFechaFinal);
        editRevisionCoor = (EditText) findViewById(R.id.editTextActutalizarRevisionCoordinador);
        editRevTutor = (EditText) findViewById(R.id.editTextActutalizarRevisionTutor);
        editIdTipoAct = (EditText) findViewById(R.id.editTextActutalizarIdentificadorTipAct);

        mSpinner = (Spinner) findViewById(R.id.spinnerActualizarBitacora);
        btnActualizarBitacora = (Button) findViewById(R.id.btnActualizarBitacora);
    }

    private void configurarSpinner(){
        ArrayAdapter<Bitacora> adapter = new ArrayAdapter<Bitacora>(this,android.R.layout.simple_spinner_item,
                mBitacoraDAO.getListaBitacoras());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinner.setAdapter(adapter);
    }

    private void setListeners(){
        btnActualizarBitacora.setOnClickListener(this);
        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                c = (Bitacora) parent.getItemAtPosition(position);
                editIdentificador.setText(c.getId_bitacora());
                editFechaInicio.setText(c.getFecha_inicio());
                editFechaFin.setText(c.getFecha_fin());
                editRevisionCoor.setText(c.getRevision_coordinador());
                editRevTutor.setText(c.getRevision_tutor());
                editIdTipoAct.setText(c.getIdentificador_actividad());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    //TODO validar campos bitacora
    @Override
    public void onClick(View v) {
        AlertDialog show = new AlertDialog.Builder(this)
                .setTitle("Actualizar Bitacora")
                .setMessage("Se actualizara: " + c.getId_bitacora() + ", ¿Esta seguro?")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        c.setId_bitacora(editIdentificador.getText().toString());
                        c.setFecha_inicio(editFechaInicio.getText().toString());
                        c.setFecha_fin(editFechaFin.getText().toString());
                        c.setRevision_coordinador(editRevisionCoor.getText().toString());
                        c.setRevision_tutor(editRevTutor.getText().toString());
                        c.setIdentificador_actividad(editIdTipoAct.getText().toString());

                        if (mBitacoraDAO.actualizarBitacora(c) == 1) {
                            Toast.makeText(ActualizarBitacora.this, "Bitacora actualizada", Toast.LENGTH_SHORT).show();
                            ActualizarBitacora.this.finish();
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
        c = (Bitacora) parent.getItemAtPosition(position);
        editIdentificador.setText(c.getId_bitacora());
        editFechaInicio.setText(c.getFecha_inicio());
        editFechaFin.setText(c.getFecha_fin());
        editRevisionCoor.setText(c.getRevision_coordinador());
        editRevTutor.setText(c.getRevision_tutor());
        editIdTipoAct.setText(c.getIdentificador_actividad());
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}

