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
    public static final int TOKEN = 40;
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
        BTNAgregar = (Button) findViewById(R.id.btnAgregarBitacoraAc);
        BTNActualizar = (Button) findViewById(R.id.btnActualizarBitacoraAc);
        BTNLlenar = (Button) findViewById(R.id.btnLlenarBaseBitacoraAc);
        BTNEliminar = (Button) findViewById(R.id.btnEliminarBitacoraAc);
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
            case R.id.btnLlenarBaseBitacoraAc:

                llenarBitacoras();
                Toast.makeText(BitacoraActivity.this, "llenado de la base de datos, verificar...", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnAgregarBitacoraAc:
                //Toast.makeText(CoordinadorActivity.this, "Activity agregar coordinador", Toast.LENGTH_SHORT).show();
                intent = new Intent(this.getApplicationContext(), AgregarBitacora.class);
                startActivity(intent);
                break;
            case R.id.btnActualizarBitacoraAc:
                intent = new Intent(this.getApplicationContext(), ActualizarBitacora.class);
                startActivity(intent);
                //Toast.makeText(CoordinadorActivity.this, "Activity actualizar coordinador", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnEliminarBitacoraAc:
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

    private void toast (String msg){
        Toast.makeText(BitacoraActivity.this, msg, Toast.LENGTH_SHORT).show();}

    private void cargarBitacoras(){
        Bitacoras = mBitacoraDAO.getListaBitacoras();
    }


    private void llenarBitacoras(){
        Bitacora temp;
        int validador;
        temp=new Bitacora();
        //temp.setId_bitacora(2);
        temp.setFecha_inicio("10/12/2003");
        temp.setFecha_fin("30/01/2004");
        temp.setRevision_coordinador(1);
        temp.setRevision_tutor(2);
        temp.setIdentificador_actividad("1234");
        validador=(int) mBitacoraDAO.insertarBitacora(temp);
        temp=new Bitacora();
        //temp.setId_bitacora(2);
        temp.setFecha_inicio("10/12/2003");
        temp.setFecha_fin("30/01/2004");
        temp.setRevision_coordinador(3);
        temp.setRevision_tutor(4);
        temp.setIdentificador_actividad("1234s");
        validador=(int) mBitacoraDAO.insertarBitacora(temp);

        if(validador>0){
            Toast.makeText(BitacoraActivity.this, "Se Ingresaron Registros", Toast.LENGTH_SHORT).show();
        }
        /*if (mBitacoraDAO.insertarBitacora(new Bitacora("AZXC", "10-02-2003", "11/03/2003", "az", "edft", "qwe45")) > 0){
            Toast.makeText(BitacoraActivity.this, "Registro Insertado", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(BitacoraActivity.this, "Error al insertar ", Toast.LENGTH_SHORT).show();
        }*/
    }


}


