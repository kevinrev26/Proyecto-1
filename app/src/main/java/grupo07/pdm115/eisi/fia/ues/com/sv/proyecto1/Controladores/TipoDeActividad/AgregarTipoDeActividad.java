package grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Controladores.TipoDeActividad;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.DAO.TipoDeActividadDAO;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Modelo.TipoDeActividad;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.R;

public class AgregarTipoDeActividad extends AppCompatActivity implements View.OnClickListener{

    //Widgets
    private EditText mIdText, mNombreText, mHorasText, mDescText;
    private String Horas;
    private Button mBtnAgregar;

    //Objeto para manejar el ingreso del nuevo tipo de actividad
    private TipoDeActividadDAO mTipoActividadDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_tipo_de_actividad);
        //Enlazando Widgets
        anclarWidgets();
        //Estableciendo los escuchadores
        setListener();
        //Referencia al DAO
        mTipoActividadDAO=new TipoDeActividadDAO(AgregarTipoDeActividad.this);
    }

    private void anclarWidgets(){
        mIdText=(EditText) findViewById(R.id.idEdit);
        mNombreText=(EditText) findViewById(R.id.nombreEdit);
        mHorasText=(EditText) findViewById(R.id.numeroEditText);
        mDescText=(EditText) findViewById(R.id.desctext);

        mBtnAgregar=(Button) findViewById(R.id.btnAgregarUnNuevoTipoActividad);
    }

    private void setListener(){
        mBtnAgregar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (!validarVacios()){
            Toast.makeText(AgregarTipoDeActividad.this, "Algun campo esta vacio", Toast.LENGTH_SHORT).show();
        } else {
            /*if (validarId()){
                Toast.makeText(AgregarTipoDeActividad.this, "El id debe comenzar con una letra", Toast.LENGTH_SHORT).show();
            } else {*/
                if (validarHoras()){
                    Toast.makeText(AgregarTipoDeActividad.this, "El cantidad de horas no es valida", Toast.LENGTH_SHORT).show();
                } else {
                    Horas=String.valueOf(mHorasText);
                    TipoDeActividad temp = new TipoDeActividad(mIdText.getText().toString().toUpperCase(),
                            mNombreText.getText().toString(),
                            mHorasText.getInputType(), ///DUDAS?????
                            mDescText.getText().toString());
                    if (mTipoActividadDAO.insertarTipoActividad(temp)>0){
                        Toast.makeText(AgregarTipoDeActividad.this, "TipoActividad Agregado con Exito", Toast.LENGTH_SHORT).show();
                        this.finish();
                    } else {
                        Toast.makeText(AgregarTipoDeActividad.this, "Ocurrio algun error al agregar la nueva TipoActividad", Toast.LENGTH_SHORT).show();
                    }
               // }//Validar telefono
            } //Else validar carnet

        }//Else validar vacios

    }


    //Validaciones
    public boolean validarVacios(){
        if (mIdText.getText().toString().equals("") ||
                mNombreText.getText().toString().equals("") ||
                mHorasText.getText().toString().equals("")){
            return false;

        } else {
            return true;
        }
    }

    public boolean validarId(){
        if (mIdText.getText().toString().matches("^[A-Za-z]{1}\\d{5}$")){
            return false;
        } else {
            return true;
        }

    }


    public boolean validarHoras(){
        if (mHorasText.getText().length() < 0 ){
            return true;
        } else {
            return false;
        }
    }
}


