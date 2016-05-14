package grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Controladores.Institucion;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.DAO.InstitucionDAO;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Modelo.Institucion;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.R;

public class EliminarInstitucion extends AppCompatActivity implements AdapterView.OnItemSelectedListener{


    //Widgets
    private Spinner mSpinner;

    //DAO
    private InstitucionDAO mInstitucionDAO;

    //Bandera para controlar el spinner
    private boolean bandera = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar_institucion);
        mSpinner = (Spinner) findViewById(R.id.spinnerEliminarIns);
        mSpinner.setOnItemSelectedListener(this);
        mInstitucionDAO = new InstitucionDAO(EliminarInstitucion.this);
        //Configurar
        configurarSpinner();
    }

    public void configurarSpinner(){
        ArrayAdapter<Institucion> adapter = new ArrayAdapter<Institucion>(this,android.R.layout.simple_spinner_item,
                mInstitucionDAO.getListaInstitucion());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinner.setAdapter(adapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (bandera){
            bandera = false;
        } else {

            final Institucion ins = (Institucion) parent.getItemAtPosition(position);

            final AlertDialog show = new AlertDialog.Builder(this)
                    .setTitle("Eliminar Institucion")
                    .setMessage("Se eliminara a: " + ins.getNombreInstitucion() + ", ¿Esta seguro?")
                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            if (mInstitucionDAO.eliminarInstiucion(ins.getIdInstitucion()) == 1) {
                                Toast.makeText(EliminarInstitucion.this, "Institucion Eliminada", Toast.LENGTH_SHORT).show();
                                EliminarInstitucion.this.finish();
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
