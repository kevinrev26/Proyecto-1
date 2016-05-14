package grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Controladores.Modalidad;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.DAO.ModalidadDAO;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Modelo.Modalidad;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.R;

public class EliminarModalidad extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    //Widgets
    private Spinner mSpinner;

    //DAO
    private ModalidadDAO ModDAO;

    //Bandera para spinner
    private boolean bandera= true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar_modalidad);
        ModDAO = new ModalidadDAO(EliminarModalidad.this);
        //Enlazar
        enlazarWidgets();
        //SetListeners
        setListeners();
        //Configurando el spinner
        configurarSpinner();

    }

    private void enlazarWidgets(){
        mSpinner = (Spinner) findViewById(R.id.spinnerActualizarModalidadExistente);

    }


    private void setListeners(){
        mSpinner.setOnItemSelectedListener(this);
    }


    public void configurarSpinner(){
        ArrayAdapter<Modalidad> adapter = new ArrayAdapter<Modalidad>(this,android.R.layout.simple_spinner_item,
                ModDAO.getListaModalidades());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinner.setAdapter(adapter);
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (bandera){
            bandera=false;
        } else {

            final Modalidad m = (Modalidad) parent.getItemAtPosition(position);
            final AlertDialog show = new AlertDialog.Builder(this)
                    .setTitle("Eliminar modalidad")
                    .setMessage("Se eliminara a: " + m.getNombre() + ", ¿Esta seguro?")
                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            if (ModDAO.eliminarModalidad(m.getIdModalidad()) == 1) {
                                Toast.makeText(EliminarModalidad.this, "Modalidad eliminada", Toast.LENGTH_SHORT).show();
                                EliminarModalidad.this.finish();
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

    @Override
    public void onNothingSelected(AdapterView<?> parent) {


    }
}

