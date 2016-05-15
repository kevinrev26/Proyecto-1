package grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Controladores.ServicioSocial;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.DAO.ServicioSocialDAO;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Modelo.ServicioSocial;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.R;

public class EliminarServicioSocial extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    //Widgets
    private Spinner mSpinner;

    //DAO
    private ServicioSocialDAO mServicioSocialDAO;

    //Bandera para controlar el spinner
    private boolean bandera = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar_servicio_social);
        mSpinner = (Spinner) findViewById(R.id.spinnerEliminarSS);
        mSpinner.setOnItemSelectedListener(this);
        mServicioSocialDAO = new ServicioSocialDAO(EliminarServicioSocial.this);
        //Configurar
        configurarSpinner();
    }

    public void configurarSpinner(){
        ArrayAdapter<ServicioSocial> adapter = new ArrayAdapter<ServicioSocial>(this,android.R.layout.simple_spinner_item,
                mServicioSocialDAO.getListaServicioSocials());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinner.setAdapter(adapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (bandera){
            bandera = false;
        } else {

            final ServicioSocial ss = (ServicioSocial) parent.getItemAtPosition(position);

            final AlertDialog show = new AlertDialog.Builder(this)
                    .setTitle("Eliminar Servicio Social")
                    .setMessage("Se eliminara a: " + ss.getTitulo() + ", ¿Esta seguro?")
                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            if (mServicioSocialDAO.eliminarServicioSocial(ss.getIdServicio()) == 1) {
                                Toast.makeText(EliminarServicioSocial.this, "Servicio Social Eliminado", Toast.LENGTH_SHORT).show();
                                EliminarServicioSocial.this.finish();
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
