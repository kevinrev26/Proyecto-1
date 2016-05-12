package grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Controladores;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Controladores.Bitacora.ActualizarBitacora;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Controladores.Bitacora.AgregarBitacora;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Controladores.Bitacora.EliminarBitacora;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.DAO.BitacoraDAO;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Modelo.Bitacora;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.R;

public class BitacoraActivity extends AppCompatActivity implements View.OnClickListener{

    //TAG de la clase
    public static final String TAG = "BitacoraActivity";
    //Widgets
    private Button BTNAgregar, BTNActualizar, BTNLlenar, BTNEliminar, BTNVer;
    //Referencia al DAO
    private BitacoraDAO mBitacoraDAO;
    //Lista para cargar en Memoria
    private ArrayList<Bitacora> Bitacoras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bitacora);
        mBitacoraDAO=new BitacoraDAO(BitacoraActivity.this);

        //EnlazandoWidgets
        anclarWdigets();
        //SetListeners
        setListener();
    }

    private void anclarWdigets(){
        BTNAgregar = (Button) findViewById(R.id.btnAgregarBitacora);
        BTNActualizar = (Button) findViewById(R.id.btnActualizarBitacora);
        BTNLlenar = (Button) findViewById(R.id.btnLlenarBase);
        BTNEliminar = (Button) findViewById(R.id.btnEliminarBitacora);
        BTNVer = (Button) findViewById(R.id.btnVerBitacoras);
    }

    private void setListener(){
        BTNAgregar.setOnClickListener(this);
        BTNActualizar.setOnClickListener(this);
        BTNLlenar.setOnClickListener(this);
        BTNEliminar.setOnClickListener(this);
        BTNVer.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.btnLlenarBase:

                llenarBitacoras();
                Toast.makeText(BitacoraActivity.this, "llenado de la base de datos, verificar...", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnAgregarBitacora:
                //Toast.makeText(CoordinadorActivity.this, "Activity agregar coordinador", Toast.LENGTH_SHORT).show();
                intent = new Intent(this.getApplicationContext(), AgregarBitacora.class);
                startActivity(intent);
                break;
            case R.id.btnActualizarBitacora:
                intent = new Intent(this.getApplicationContext(), ActualizarBitacora.class);
                startActivity(intent);
                //Toast.makeText(CoordinadorActivity.this, "Activity actualizar coordinador", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnEliminarBitacora:
                //Toast.makeText(CoordinadorActivity.this, "Activity eliminar coordinador", Toast.LENGTH_SHORT).show();
                intent = new Intent(this.getApplicationContext(), EliminarBitacora.class);
                startActivity(intent);
                break;
            case R.id.btnVerBitacoras:
                cargarBitacoras();
                for (Bitacora c : Bitacoras){
                    Log.i(TAG, c.toString());
                }
                Toast.makeText(BitacoraActivity.this, "Revisar LOGCAT", Toast.LENGTH_SHORT).show();
                break;

        }
    }

    private void cargarBitacoras(){
        Bitacoras = mBitacoraDAO.getListaBitacoras();
    }


    private void llenarBitacoras(){
        Bitacora temp;
        int validador;
        temp = new Bitacora();
        temp.setId_bitacora("AZXC");
        temp.setFecha_inicio("10-02-2003");
        temp.setFecha_fin("11/03/2003");
        temp.setRevision_coordinador("az");
        temp.setRevision_tutor("edft");
        temp.setIdentificador_actividad("qwe45");
        validador = (int) mBitacoraDAO.insertarBitacora(temp);
        temp.setId_bitacora("AZXz");
        temp.setFecha_inicio("10-02-2003");
        temp.setFecha_fin("12/03/2003");
        temp.setRevision_coordinador("azx");
        temp.setRevision_tutor("edfts");
        temp.setIdentificador_actividad("qwe451");
        validador += (int) mBitacoraDAO.insertarBitacora(temp);

        if (validador>0){
            Toast.makeText(BitacoraActivity.this, "Se ingresaron los registros", Toast.LENGTH_SHORT).show();
        }
    }
}


