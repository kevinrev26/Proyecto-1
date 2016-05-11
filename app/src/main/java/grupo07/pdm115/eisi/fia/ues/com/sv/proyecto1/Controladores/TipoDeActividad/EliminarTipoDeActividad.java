package grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Controladores.TipoDeActividad;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.DAO.TipoDeActividadDAO;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Modelo.TipoDeActividad;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.R;

public class EliminarTipoDeActividad extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    //Widgets
    private Spinner nSpinner;
    //DAO
    private TipoDeActividadDAO nTipoActividadDAO;
    //Bandeja para controlar el spinner
    private boolean flag = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar_tipo_de_actividad);
        nSpinner=(Spinner) findViewById(R.id.spinnerEliminarTD);
        nSpinner.setOnItemSelectedListener(this);
        nTipoActividadDAO=new TipoDeActividadDAO(EliminarTipoDeActividad.this);

        configurarSpinners();
    }

    public void configurarSpinners(){
        ArrayAdapter<TipoDeActividad> adapter=new ArrayAdapter<TipoDeActividad>(this,android.R.layout.simple_spinner_item,nTipoActividadDAO.getListaTiposActividad());

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        nSpinner.setAdapter(adapter);
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (flag){
            flag = false;
        } else {

            final TipoDeActividad e = (TipoDeActividad) parent.getItemAtPosition(position);

            //Toast.makeText(EliminarEstudiante.this, "Seleccionado: "+e.getCarnet(), Toast.LENGTH_SHORT).show();
            final AlertDialog show = new AlertDialog.Builder(this)
                    .setTitle("Eliminar Tipo Actividad")
                    .setMessage("Se eliminara a: " + e.getNombre_actividad() + ", ¿Esta seguro?")
                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            if (nTipoActividadDAO.eliminarTipoActividad(e.getId_tipo_actividad()) == 1) {
                                Toast.makeText(EliminarTipoDeActividad.this, "TipoDeActividad Eliminada", Toast.LENGTH_SHORT).show();
                                EliminarTipoDeActividad.this.finish();
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
        //Do nothing

    }
}
