package grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Controladores.TipoDeActividad;

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


import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.DAO.TipoDeActividadDAO;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Modelo.TipoDeActividad;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.R;

public class ActualizarTipoDeActividad extends AppCompatActivity implements View.OnClickListener {

    //Widgets
    private EditText editNombreTP, editCantidadH, editDescripcion;
    private Spinner mSpinner;
    private Button  btnActualizarTipAct;

    //referencia a coordinador
    TipoDeActividad c;


    //DAO
    private TipoDeActividadDAO mTActividadDAO;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar_tipo_de_actividad);
        mTActividadDAO = new TipoDeActividadDAO(ActualizarTipoDeActividad.this);
        //EnlazarWidgets
        enlazarWidgets();

        //configurar spinner
        configurarSpinner();

        //setListeners
        setListeners();


    }

    private void enlazarWidgets(){

        editNombreTP = (EditText) findViewById(R.id.editTextActutalizarNombreActividad);
        editCantidadH = (EditText) findViewById(R.id.editTextActutalizarCantidadHoras);
        editDescripcion = (EditText) findViewById(R.id.editTextActutalizarDescripcionActividad);

        mSpinner = (Spinner) findViewById(R.id.spinnerTiposActividades);
        btnActualizarTipAct = (Button) findViewById(R.id.btnActualizarTipoDeActividad);
    }

    private void configurarSpinner(){
        ArrayAdapter<TipoDeActividad> adapter = new ArrayAdapter<TipoDeActividad>(this,android.R.layout.simple_spinner_item,
                mTActividadDAO.getListaTiposActividad());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinner.setAdapter(adapter);
    }

    private void setListeners(){
        mSpinner.setOnClickListener(this);

        //Tipos Actividades
        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                c = (TipoDeActividad) parent.getItemAtPosition(position);
                editNombreTP.setText(c.getNombre_actividad());
                editCantidadH.setText(c.getCantidad_horas());
                editDescripcion.setText(c.getDescripcion());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    //TODO Validar los campos.
    @Override
    public void onClick(View v) {
        AlertDialog show = new AlertDialog.Builder(this)
                .setTitle("Actualizar Tipo Actividad")
                .setMessage("Se actualizara: " + c.getNombre_actividad() + ", ¿Esta seguro?")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        c.setNombre_actividad(editNombreTP.getText().toString());
                        c.setCantidad_horas(Integer.parseInt(editCantidadH.getText().toString()));
                        c.setDescripcion(editDescripcion.getText().toString());
                        if (mTActividadDAO.actualizarTipoActividad(c) == 1) {
                            Toast.makeText(ActualizarTipoDeActividad.this, "Tipo De Actualidad Actualizada", Toast.LENGTH_SHORT).show();
                            ActualizarTipoDeActividad.this.finish();
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
