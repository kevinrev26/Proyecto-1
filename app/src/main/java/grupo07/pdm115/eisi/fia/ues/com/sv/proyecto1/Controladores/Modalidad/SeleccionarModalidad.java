package grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Controladores.Modalidad;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Apoyo.CustomAdapterModalidad;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Modelo.Modalidad;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.R;

public class SeleccionarModalidad extends AppCompatActivity {

    private ListView list;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccionar_coordinador);
        //EnlazarWdigets
        enlazarWidgets();

        //Configurar adapter
        configurarAdapter();
    }

    private void enlazarWidgets(){
        list = (ListView) findViewById(R.id.listViewSeleccionarModalidades);
    }

    private void configurarAdapter(){
        Intent intent = getIntent();
        ArrayList<Modalidad> modalidades = (ArrayList<Modalidad>) intent.getSerializableExtra("modalidades");
        list.setAdapter(new CustomAdapterModalidad(this.getApplicationContext(), modalidades));
    }
}
