package grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Controladores.Institucion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.DAO.InstitucionDAO;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Modelo.Institucion;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.R;

public class AgregarInstitucion extends AppCompatActivity implements View.OnClickListener{

    //Widgets
    private EditText mNombreInsText, mEmailInsText, mNombreEncText, mTel1Text, mTel2Text;
    private Button mBtnAgregarIns;

    //Objeto para manejar el ingreso del nuevo estudiante
    private InstitucionDAO mInstitucionDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_institucion);
        //Enlanzando los widgets
        enlazarWidgets();
        //Estableciendo los escuchadores
        setListeners();
        //Referenciando el DAO
        mInstitucionDAO = new InstitucionDAO(AgregarInstitucion.this);
    }



    private void enlazarWidgets(){
        mNombreInsText = (EditText) findViewById(R.id.nomInsEdit);
        mEmailInsText = (EditText) findViewById(R.id.correoInsEdit);
        mNombreEncText = (EditText) findViewById(R.id.nomEncEdit);
        mTel1Text = (EditText) findViewById(R.id.tel1Edit);
        mTel2Text = (EditText) findViewById(R.id.tel2Edit);
        mBtnAgregarIns = (Button) findViewById(R.id.btnAgregarNuevaInstitucion);
    }

    private void setListeners(){

        mBtnAgregarIns.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (!validarVacios()){
            Toast.makeText(AgregarInstitucion.this, "Algun campo esta vacio", Toast.LENGTH_SHORT).show();
        } else {
            if (validarTelefono()){
                Toast.makeText(AgregarInstitucion.this, "El telefono1 no es valido", Toast.LENGTH_SHORT).show();
            } else if (!validarTelefono2()) {
                Toast.makeText(AgregarInstitucion.this, "El telefono2 no es valido", Toast.LENGTH_SHORT).show();
            } else {
                Institucion temp = new Institucion();
                        temp.setNombreInstitucion(mNombreInsText.getText().toString());
                        temp.setEmailInstitucion(mEmailInsText.getText().toString());
                        temp.setNombreEncargado(mNombreEncText.getText().toString());
                        temp.setTelefono1(mTel1Text.getText().toString());
                        temp.setTelefono2(mTel2Text.getText().toString());
                if (mInstitucionDAO.insertarInstitucion(temp)>0){
                    Toast.makeText(AgregarInstitucion.this, "Institucion agregada con exito", Toast.LENGTH_SHORT).show();
                    this.finish();
                } else {
                    Toast.makeText(AgregarInstitucion.this, "Ocurrio algun error al agregar la nueva Institucion", Toast.LENGTH_SHORT).show();
                }
            }//Validar telefono
        }//Else validar vacios
    }

    //Validaciones
    public boolean validarVacios(){
        if (mNombreInsText.getText().toString().equals("") ||
                mEmailInsText.getText().toString().equals("") ||
                mNombreEncText.getText().toString().equals("")||
                mTel1Text.getText().toString().equals(""))
        {
            return false;

        } else {
            return true;
        }
    }

    public boolean validarTelefono(){
        if (mTel1Text.getText().length() < 8 ){
            return true;
        } else {
            return false;
        }
    }

    public boolean validarTelefono2(){
        if (mTel2Text.getText().toString().equals("")){
            return true;
        } else {
            if(mTel2Text.getText().length() >= 8){
                return true;
            } else {
                return false;
            }
        }
    }
}
