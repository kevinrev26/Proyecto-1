package grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.logging.Handler;
import java.util.logging.LogRecord;


/*
* Esta clase implementa el login, verifica las credenciales y establece los permisos
* de las activities.
* */

/*
* TODO Implementacion del login
* */
public class LoginActivity extends AppCompatActivity implements View.OnClickListener{


    //Wdigets
    private Button mBtnAcceder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Enlazando los widgets de la vista al codigo
        bindWidgets();

        //Estableciendo los eventos y sus manejadores
        setListeners();


    }

    /*
    * Implementacion de la referencias de los widgets de la vista al codigo de esta
    * activity
    */
    private void bindWidgets(){
        mBtnAcceder = (Button) findViewById(R.id.btnAcceder);
    }

    /*
    * Este metodo implementa el establecimiento de los escuchadores y sus listeners
    *
    */
    private void setListeners() {
        mBtnAcceder.setOnClickListener(this);
    }

    /*
    * Implementacion del metodo de la interfaz View.OnClickListener,
    * se invoca la ActivityPrincipal
    *
    * */

    @Override
    public void onClick(View v) {
        //Se Pasa el control a la actividad principal.
        //Implementacion de la logica para
        Intent intent = new Intent(this.getApplicationContext(),MainActivity.class);
        startActivity(intent);
        this.finish();
    }
}
