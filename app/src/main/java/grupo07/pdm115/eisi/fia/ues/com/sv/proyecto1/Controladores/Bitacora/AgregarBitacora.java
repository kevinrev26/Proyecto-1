package grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Controladores.Bitacora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.DAO.BitacoraDAO;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Modelo.Bitacora;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.R;

public class AgregarBitacora extends AppCompatActivity  implements View.OnClickListener{

    //wdigets
    private EditText editTextIdBitacora, editTextFechaIn, editTextFechaFi, editTextRevCoor, editTextRevTut, editTextIdTipA;
    private Button BTNAgregar;

    //DAO
    BitacoraDAO mBitacoraDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_bitacora);
        mBitacoraDAO = new BitacoraDAO(AgregarBitacora.this);
        //EnlazarWidgets
        anclarWidgets();
        //SetListeners
        setListener();


    }

    private void anclarWidgets(){
        editTextIdBitacora=(EditText) findViewById(R.id.editTextIdentificadorBitacora);
        editTextFechaIn = (EditText) findViewById(R.id.editTextFechaInicio);
        editTextFechaFi = (EditText) findViewById(R.id.editTextFechaFinal);
        editTextRevCoor = (EditText) findViewById(R.id.editTextRevCoordinador);
        editTextRevTut = (EditText) findViewById(R.id.editTextRevisionTutor);
        editTextIdTipA = (EditText) findViewById(R.id.editTextIdTipoActividad);

        BTNAgregar = (Button) findViewById(R.id.btnAgregarBitacora);
    }


    private void setListener(){
        BTNAgregar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if (!validarVacios()){
            Toast.makeText(AgregarBitacora.this, "Algun campo esta vacio,", Toast.LENGTH_SHORT).show();
        } else {
            /*if (validarTelefono()){
                Toast.makeText(AgregarBitacora.this, "El telefono no es valido", Toast.LENGTH_SHORT).show();
            } else {*/

                Bitacora temp = new Bitacora();
                temp.setId_bitacora(editTextIdBitacora.getText().toString());
                temp.setFecha_inicio(editTextFechaIn.getText().toString());
                temp.setFecha_fin(editTextFechaFi.getText().toString());
                temp.setRevision_coordinador(editTextRevCoor.getText().toString());
                temp.setRevision_tutor(editTextRevTut.getText().toString());
                temp.setIdentificador_actividad(editTextIdTipA.getText().toString());

                if (mBitacoraDAO.insertarBitacora(temp)>0){
                    Toast.makeText(AgregarBitacora.this, "Bitacora agregada con exito", Toast.LENGTH_SHORT).show();
                    this.finish();
                } else {
                    Toast.makeText(AgregarBitacora.this, "Ocurrio algun problema al agregar", Toast.LENGTH_SHORT).show();
                }
            //}
        }

    }


    //Validaciones
    public boolean validarVacios(){
        if (editTextIdBitacora.getText().toString().equals("") ||
                editTextFechaIn.getText().toString().equals("") ||
                editTextFechaFi.getText().toString().equals("") ||
                editTextRevCoor.getText().toString().equals("") ||
                editTextRevTut.getText().toString().equals("") ||
                editTextIdTipA.getText().toString().equals("")){
            return false;

        } else {
            return true;
        }
    }

    /*public boolean validarTelefono(){
        if (editTextTelefono.getText().length() < 8){
            return true;
        } else {
            return false;
        }
    }*/
}

