package grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Controladores.ServicioSocial;

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

import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.DAO.ServicioSocialDAO;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Modelo.ServicioSocial;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.R;

public class ActualizarServicioSocial extends AppCompatActivity implements View.OnClickListener{

    //Widgets
    private EditText mTituloSSText, mDesSSText, mDispSSText, mIdInsSSText, mIdModSSText, mIdTutorSSText, mCooAprSSText;
    private Button mBtnActualizarSS;
    private Spinner mSpinnerIServiciosSociales;

    private ServicioSocial ss;

    //Referencia al DAO
    private ServicioSocialDAO mServicioSocialDAO;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar_servicio_social);
        //Enlazar widgets
        enlazarWidgets();
        mServicioSocialDAO= new ServicioSocialDAO(ActualizarServicioSocial.this);
        //ConfigurarSpinner
        configurarSpinnerServiciosSociales();
        //SetListeners
        setListeners();
    }

    private void enlazarWidgets(){
        mSpinnerIServiciosSociales = (Spinner) findViewById(R.id.spinnerServiciosSociales);
        mTituloSSText = (EditText) findViewById(R.id.eTTituloSS);
        mDesSSText = (EditText) findViewById(R.id.eTDesSS);
        mDispSSText = (EditText) findViewById(R.id.eTDisSS);
        mIdInsSSText = (EditText) findViewById(R.id.eTIdInsSS);
        mIdModSSText = (EditText) findViewById(R.id.eTIdModSS);
        mIdTutorSSText = (EditText) findViewById(R.id.eTIdTutorSS);
        mCooAprSSText= (EditText) findViewById(R.id.eTCooAprSS);
        mBtnActualizarSS = (Button) findViewById(R.id.btnActualizarSS);
    }

    private void configurarSpinnerServiciosSociales(){
        ArrayAdapter<ServicioSocial> adapter = new ArrayAdapter<ServicioSocial>(this,android.R.layout.simple_spinner_item,
                mServicioSocialDAO.getListaServicioSocials());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinnerIServiciosSociales.setAdapter(adapter);
    }

    private void setListeners(){
        mBtnActualizarSS.setOnClickListener(this);

        //Servicios_Sociales
        mSpinnerIServiciosSociales.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ss = (ServicioSocial) parent.getItemAtPosition(position);
                mTituloSSText.setText(ss.getTitulo());
                mDesSSText.setText(ss.getDescripcion());
                mDispSSText.setText(ss.getDisponible());
                mIdInsSSText.setText(ss.getIdentificadorInstitucion());
                mIdModSSText.setText(ss.getIdentificadorModalidad());
                mIdTutorSSText.setText(ss.getIdentificadorTutor());
                mCooAprSSText.setText(ss.getCoordinadorAprobado());

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    @Override
    public void onClick(View v) {
        AlertDialog show = new AlertDialog.Builder(this)
                .setTitle("Actualizar Institucion")
                .setMessage("Se actualizara: " + ss.getIdServicio() + ", ¿Esta seguro?")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        ss.setTitulo(mTituloSSText.getText().toString());
                        ss.setDescripcion(mDesSSText.getText().toString());
                        ss.setDisponible(Integer.parseInt(mDispSSText.getText().toString()));
                        ss.setCoordinadorAprobado(mCooAprSSText.getText().toString());
                        ss.setIdentificadorInstitucion(mIdInsSSText.getText().toString());
                        ss.setIdentificadorModalidad(mIdModSSText.getText().toString());
                        ss.setIdentificadorTutor(mIdTutorSSText.getText().toString());
                        if (mServicioSocialDAO.actualizarServicioSocial(ss) == 1) {
                            Toast.makeText(ActualizarServicioSocial.this, "Servicio Social actualizado", Toast.LENGTH_SHORT).show();
                            ActualizarServicioSocial.this.finish();
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
