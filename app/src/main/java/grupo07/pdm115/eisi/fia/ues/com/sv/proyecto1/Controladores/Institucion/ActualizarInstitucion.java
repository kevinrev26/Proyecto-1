package grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Controladores.Institucion;

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

import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.DAO.InstitucionDAO;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Modelo.Institucion;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.R;

public class ActualizarInstitucion extends AppCompatActivity implements View.OnClickListener{

    //Wdigets
    private EditText mNombreInsText, mEmailInsText, mNombreEncText, mTel1Text, mTel2Text;
    private Spinner mSpinnerInstitucion;
    private Button mBtnActualizarIns;

    //Referencia de estudiante
    private Institucion ins;

    //Referencia al DAO
    private InstitucionDAO mInstitucionDAO;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar_institucion);
        //Enlazar widgets
        enlazarWidgets();
        mInstitucionDAO = new InstitucionDAO(ActualizarInstitucion.this);
        //ConfigurarSpinnerInstituciones
        configurarSpinnerInstituciones();
        //SetListeners
        setListeners();
    }

    private void enlazarWidgets(){
        mSpinnerInstitucion = (Spinner) findViewById(R.id.spinnerInstituciones);
        mNombreInsText = (EditText) findViewById(R.id.editNomInsText);
        mEmailInsText = (EditText) findViewById(R.id.editCoInsText);
        mNombreEncText = (EditText) findViewById(R.id.editNoEnText);
        mTel1Text = (EditText) findViewById(R.id.editTe1Text);
        mTel2Text = (EditText) findViewById(R.id.editTe2Text);
        mBtnActualizarIns = (Button) findViewById(R.id.btnActualizarInstitucion);
    }

    private void configurarSpinnerInstituciones(){
        ArrayAdapter<Institucion> adapter = new ArrayAdapter<Institucion>(this,android.R.layout.simple_spinner_item,
                mInstitucionDAO.getListaInstitucion());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinnerInstitucion.setAdapter(adapter);
    }

    private void setListeners(){
        mBtnActualizarIns.setOnClickListener(this);

        //Instituciones
        mSpinnerInstitucion.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ins = (Institucion) parent.getItemAtPosition(position);
                mNombreInsText.setText(ins.getNombreInstitucion());
                mEmailInsText.setText(ins.getEmailInstitucion());
                mNombreEncText.setText(ins.getNombreEncargado());
                mTel1Text.setText(ins.getTelefono1());
                mTel2Text.setText(ins.getTelefono2());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
    //TODO Validar los campos de nombre e Email.
    @Override
    public void onClick(View v) {
        AlertDialog show = new AlertDialog.Builder(this)
                .setTitle("Actualizar Institucion")
                .setMessage("Se actualizara: " + ins.getNombreInstitucion() + ", ¿Esta seguro?")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        ins.setNombreInstitucion(mNombreInsText.getText().toString());
                        ins.setEmailInstitucion(mEmailInsText.getText().toString());
                        ins.setNombreEncargado(mNombreEncText.getText().toString());
                        ins.setTelefono1(mTel1Text.getText().toString());
                        ins.setTelefono2(mTel2Text.getText().toString());
                        if (mInstitucionDAO.actualizarInstitucion(ins) == 1) {
                            Toast.makeText(ActualizarInstitucion.this, "Institucion actualizada", Toast.LENGTH_SHORT).show();
                            ActualizarInstitucion.this.finish();
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
