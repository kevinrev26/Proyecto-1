package grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.logging.Handler;
import java.util.logging.LogRecord;

import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.DAO.UsuarioDAO;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Modelo.Usuario;


/*
* Esta clase implementa el login, verifica las credenciales y establece los permisos
* de las activities.
* */

/*
* TODO Implementacion del login
* */
public class LoginActivity extends AppCompatActivity implements View.OnClickListener{


    //Wdigets
    private Button mBtnIngresar, mBtnSalir;
    private EditText textUsername, textPassword;

    //Dao
    private UsuarioDAO usuarioActual;

    private Usuario actual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        usuarioActual = new UsuarioDAO(LoginActivity.this);

        //Enlazando los widgets de la vista al codigo
       bindWidgets();

        //Estableciendo los eventos y sus manejadores
       setListeners();


    }

    private void bindWidgets(){
        mBtnIngresar = (Button) findViewById(R.id.btnIngresar);
        mBtnSalir = (Button) findViewById(R.id.btnSalir);
        textPassword = (EditText) findViewById(R.id.editTextPassword);
        textUsername = (EditText) findViewById(R.id.editTextUserName);
    }

    private void setListeners(){
        mBtnSalir.setOnClickListener(this);
        mBtnIngresar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnSalir:
                this.finish();
                break;

            case R.id.btnIngresar:
                if (validarVacios()){
                    Toast.makeText(LoginActivity.this, "Los campos no pueden estar vacios", Toast.LENGTH_SHORT).show();
                } else {
                    actual = usuarioActual.getUser(textUsername.getText().toString().toUpperCase());
                    Log.i("LoginActivity",textUsername.getText().toString().toUpperCase());
                    if (actual == null){
                        Toast.makeText(LoginActivity.this, "No se encuentra el usuario en el sistema", Toast.LENGTH_SHORT).show();
                    } else {
                        if (textPassword.getText().toString().toUpperCase().equals(actual.getPassword())){
                            Intent i = new Intent(this.getApplicationContext(),MainActivity.class);
                            i.putExtra("usuario",actual.getIdUsuario());
                            startActivity(i);
                            this.finish();
                        } else {
                            Toast.makeText(LoginActivity.this, "Contraseña incorrecta", Toast.LENGTH_SHORT).show();
                            Log.i("LoginActivity",textPassword.getText().toString().toUpperCase());
                        }//Contraseña
                    }//Nombre de usuario
                }//ValidarVacios

        }

    }

    private boolean validarVacios(){
        if (textUsername.getText().toString().equals("") ||
                textPassword.getText().toString().equals("")){
            return true;
        } else {
            return false;
        }
    }
}
