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
public class LoginActivity extends AppCompatActivity {


    //Wdigets
    private Button mBtnAcceder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Enlazando los widgets de la vista al codigo
       // bindWidgets();

        //Estableciendo los eventos y sus manejadores
       // setListeners();


    }


}
