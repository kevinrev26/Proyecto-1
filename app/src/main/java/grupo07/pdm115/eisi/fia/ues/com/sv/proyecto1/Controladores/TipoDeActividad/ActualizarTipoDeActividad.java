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

import java.util.HashMap;
import java.util.Map;

import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.DAO.TipoDeActividadDAO;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Modelo.TipoDeActividad;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.R;

public class ActualizarTipoDeActividad extends AppCompatActivity implements View.OnClickListener {

    //Wdigets
    private EditText editNombAct, editCantH, editDesc;
    private Spinner mSpinnerTipoActividad;
    private Button mButtonActualizar;

    //Referencia de identificador
    private String seleccion;

    //Referencia de tipo de actividad
    private TipoDeActividad x;

    //Referencia al TipoDeActividadDAO
    private TipoDeActividadDAO mActividadDAO;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar_tipo_de_actividad);
        //Enlazar widgets
        anclarWidgets();

        mActividadDAO = new TipoDeActividadDAO(ActualizarTipoDeActividad.this);

        //configurandoSpinnerActividades
        configurarSpinnerTiposActividades();
        //setListener
        setListener();
    }

    private void anclarWidgets() {
        editNombAct = (EditText) findViewById(R.id.nombEditText);
        editCantH = (EditText) findViewById(R.id.numEditText);
        editDesc = (EditText) findViewById(R.id.txtDesc);
        mSpinnerTipoActividad = (Spinner) findViewById(R.id.spinnerTiposActividades);
        mButtonActualizar = (Button) findViewById(R.id.btnActualizar);
    }

    private void configurarSpinnerTiposActividades() {
        ArrayAdapter<TipoDeActividad> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, mActividadDAO.getListaTiposActividad());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinnerTipoActividad.setAdapter(adapter);
    }

    private void setListener() {
        mButtonActualizar.setOnClickListener(this);

        //TiposDeActividades
        mSpinnerTipoActividad.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                x = (TipoDeActividad) parent.getItemAtPosition(position);

                editNombAct.setText(x.getNombre_actividad());
                editCantH.setText(x.getCantidad_horas());
                editDesc.setText(x.getDescripcion());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void onClick(View v){
        AlertDialog show=new AlertDialog.Builder(this)
                .setTitle("Actualizar Tipo de Actividad")
                .setMessage("Se Actualizara: " + x.getNombre_actividad() + ", Estas seguro?")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        x.setNombre_actividad(editNombAct.getText().toString());
                        x.setCantidad_horas(Integer.parseInt(editCantH.getText().toString()));
                        x.setDescripcion(editDesc.getText().toString());
                        if (mActividadDAO.actualizarTipoActividad(x)==1){
                            Toast.makeText(ActualizarTipoDeActividad.this, "Tipo De Actividad Actualizada", Toast.LENGTH_SHORT).show();
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



