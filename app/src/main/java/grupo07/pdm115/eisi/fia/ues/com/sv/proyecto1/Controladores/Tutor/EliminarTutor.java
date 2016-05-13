package grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Controladores.Tutor;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.DAO.TutorDAO;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Modelo.Tutor;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.R;

public class EliminarTutor extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    //Widgets
    private Spinner mSpinner;

    //DAO
    private TutorDAO mTutorDAO;

    //Bandera para spinner
    private boolean bandera= true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar_tutor);
        mTutorDAO = new TutorDAO(EliminarTutor.this);
        //Enlazar
        enlazarWidgets();
        //SetListeners
        setListeners();
        //Configurando el spinner
        configurarSpinner();

    }

    private void enlazarWidgets(){
        mSpinner = (Spinner) findViewById(R.id.spinnerActualizarTutor);

    }


    private void setListeners(){
        mSpinner.setOnItemSelectedListener(this);
    }


    public void configurarSpinner(){
        ArrayAdapter<Tutor> adapter = new ArrayAdapter<Tutor>(this,android.R.layout.simple_spinner_item,
                mTutorDAO.getListaTutores());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinner.setAdapter(adapter);
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (bandera){
            bandera=false;
        } else {

            final Tutor t = (Tutor) parent.getItemAtPosition(position);
            final AlertDialog show = new AlertDialog.Builder(this)
                    .setTitle("Eliminar tutor")
                    .setMessage("Se eliminara a: " + t.getNombre() + ", ¿Esta seguro?")
                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            if (mTutorDAO.eliminarTutor(t.getIdTutor()) == 1) {
                                Toast.makeText(EliminarTutor.this, "Tutor eliminado", Toast.LENGTH_SHORT).show();
                                EliminarTutor.this.finish();
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
