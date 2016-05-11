package grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Controladores.Coordinador;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.DAO.CoordinadorDAO;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Modelo.Coordinador;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.R;

public class EliminarCoordinador extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    //Widgets
    private Spinner mSpinner;

    //DAO
    private CoordinadorDAO  mCoordinadorDAO;

    //Bandera para spinner
    private boolean bandera= true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar_coordinador);
        mCoordinadorDAO = new CoordinadorDAO(EliminarCoordinador.this);
        //Enlazar
        enlazarWidgets();
        //SetListeners
        setListeners();
        //Configurando el spinner
        configurarSpinner();

    }

    private void enlazarWidgets(){
        mSpinner = (Spinner) findViewById(R.id.spinnerActualizarCoordinador);

    }


    private void setListeners(){
        mSpinner.setOnItemSelectedListener(this);
    }


    public void configurarSpinner(){
        ArrayAdapter<Coordinador> adapter = new ArrayAdapter<Coordinador>(this,android.R.layout.simple_spinner_item,
                mCoordinadorDAO.getListaCoordinadores());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinner.setAdapter(adapter);
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (bandera){
            bandera=false;
        } else {

            final Coordinador c = (Coordinador) parent.getItemAtPosition(position);
            final AlertDialog show = new AlertDialog.Builder(this)
                    .setTitle("Eliminar coordinador")
                    .setMessage("Se eliminara a: " + c.getNombre() + ", ¿Esta seguro?")
                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            if (mCoordinadorDAO.eliminarCoordinador(c.getId_coordinador()) == 1) {
                                Toast.makeText(EliminarCoordinador.this, "Coordinador eliminado", Toast.LENGTH_SHORT).show();
                                EliminarCoordinador.this.finish();
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
