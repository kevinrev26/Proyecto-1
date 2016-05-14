package grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Controladores.Bitacora;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.DAO.BitacoraDAO;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Modelo.Bitacora;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.R;

public class EliminarBitacora extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    //Widgets
    private Spinner mSpinner;

    //DAO
    private BitacoraDAO  mBitacoraDAO;

    //Bandera para spinner
    private boolean bandera= true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar_bitacora);
        mSpinner=(Spinner) findViewById(R.id.spinnerEliminarBitacora);
        mSpinner.setOnItemSelectedListener(this);
        mBitacoraDAO = new BitacoraDAO(EliminarBitacora.this);

        configurarSpinner();

    }


    public void configurarSpinner(){
        ArrayAdapter<Bitacora> adapter = new ArrayAdapter<Bitacora>(this,android.R.layout.simple_spinner_item,
                mBitacoraDAO.getListaBitacoras());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinner.setAdapter(adapter);
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (bandera){
            bandera = false;
        } else {

            final Bitacora e = (Bitacora) parent.getItemAtPosition(position);

            //Toast.makeText(EliminarEstudiante.this, "Seleccionado: "+e.getCarnet(), Toast.LENGTH_SHORT).show();
            final AlertDialog show = new AlertDialog.Builder(this)
                    .setTitle("Eliminar Bitacora")
                    .setMessage("Se eliminara a: " + e.getId_bitacora() + ", ¿Esta seguro?")
                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            if (mBitacoraDAO.eliminarBitacora(e.getId_bitacora()) == 1) {
                                Toast.makeText(EliminarBitacora.this, "Bitacora Eliminada", Toast.LENGTH_SHORT).show();
                                EliminarBitacora.this.finish();
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
