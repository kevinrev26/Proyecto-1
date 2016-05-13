package grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Controladores.Bitacora;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Apoyo.CustomAdapterBitacora;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Modelo.Bitacora;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.R;

public class SeleccionarBitacora extends AppCompatActivity {

    private ListView list;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccionar_bitacora);
        //EnlazarWdigets
        enlazarWidgets();

        //Configurar adapter
        configurarAdapter();
    }

    private void enlazarWidgets(){
        list = (ListView) findViewById(R.id.listViewBitacoras);
    }

    private void configurarAdapter(){
        Intent intent = getIntent();
        ArrayList<Bitacora> coordinadores = (ArrayList<Bitacora>) intent.getSerializableExtra("bitacoras");
        list.setAdapter(new CustomAdapterBitacora(this.getApplicationContext(),coordinadores));
    }
}
