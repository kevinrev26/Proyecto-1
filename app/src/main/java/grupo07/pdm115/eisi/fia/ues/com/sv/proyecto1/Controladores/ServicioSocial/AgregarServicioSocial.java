package grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Controladores.ServicioSocial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.DAO.ServicioSocialDAO;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Modelo.ServicioSocial;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.R;

public class AgregarServicioSocial extends AppCompatActivity implements View.OnClickListener{

    //Widgets
    private EditText mTituloSSText, mDesSSText, mDispSSText, mIdInsSSText, mIdModSSText, mIdTutorSSText, mCooAprSSText;
    private Button mBtnAgregarSS;

    //Objeto para manejar el ingreso del nuevo estudiante
    private ServicioSocialDAO mServicioSocialDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_servicio_social);
        //Enlanzando los widgets
        enlazarWidgets();
        //Estableciendo los escuchadores
        setListeners();
        //Referenciando el DAO
        mServicioSocialDAO = new ServicioSocialDAO(AgregarServicioSocial.this);
    }



    private void enlazarWidgets(){
        mTituloSSText = (EditText) findViewById(R.id.editTextTiSS);
        mDesSSText = (EditText) findViewById(R.id.editTextDesSS);
        mDispSSText = (EditText) findViewById(R.id.editTextDispSS);
        mIdInsSSText = (EditText) findViewById(R.id.editTextIdInsSS);
        mIdModSSText = (EditText) findViewById(R.id.editTextIdModSS);
        mIdTutorSSText = (EditText) findViewById(R.id.editTextIdTutorSS);
        mCooAprSSText = (EditText) findViewById(R.id.editTextCooAprSS);
        mBtnAgregarSS = (Button) findViewById(R.id.btnAgregarNuevoSS);
    }

    private void setListeners(){

        mBtnAgregarSS.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (!validarVacios()) {
            Toast.makeText(AgregarServicioSocial.this, "Algun campo esta vacio", Toast.LENGTH_SHORT).show();
        } else if(!validarDisponible()){
            Toast.makeText(AgregarServicioSocial.this, "Disponibilidad solo puede ser 1=Disponible o 0=No Disponible", Toast.LENGTH_SHORT).show();
        } else {

            ServicioSocial temp = new ServicioSocial();
                    temp.setIdentificadorTutor(Integer.parseInt(mIdTutorSSText.getText().toString()));
                    temp.setIdentificadorModalidad(Integer.parseInt(mIdModSSText.getText().toString()));
                    temp.setTitulo(mTituloSSText.getText().toString());
                    temp.setDescripcion(mDesSSText.getText().toString());
                    temp.setDisponible(Integer.parseInt(mDispSSText.getText().toString()));
                    temp.setCoordinadorAprobado(Integer.parseInt(mCooAprSSText.getText().toString()));
            if (mServicioSocialDAO.insertarServicioSocial(temp) > 0) {
                Toast.makeText(AgregarServicioSocial.this, "Servicio social agregado con exito", Toast.LENGTH_SHORT).show();
                this.finish();
            } else {
                Toast.makeText(AgregarServicioSocial.this, "Ocurrio algun problema al agregar, verfique los identificadores", Toast.LENGTH_SHORT).show();
            }
            //}
        }
    }

    //Validaciones
    public boolean validarVacios(){
        if (mTituloSSText.getText().toString().equals("") ||
                mIdInsSSText.getText().toString().equals("") ||
                mIdModSSText.getText().toString().equals("")||
                mDispSSText.getText().toString().equals("")||
                mCooAprSSText.getText().toString().equals("")
                )
        {
            return false;

        } else {
            return true;
        }
    }

    public boolean validarDisponible(){
        if(Integer.parseInt(mDispSSText.getText().toString())==1 || Integer.parseInt(mDispSSText.getText().toString())==0) {
            return true;
        }else{
            return false;
        }
    }
}
