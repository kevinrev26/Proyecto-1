package grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Controladores.Coordinador;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ListViewCompat;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Apoyo.CustomAdapterCoordinador;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Modelo.Coordinador;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.R;

public class SeleccionarCoordinador extends AppCompatActivity {

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
        list = (ListView) findViewById(R.id.listViewSeleccionarCoordinadores);
    }

    private void configurarAdapter(){
        Intent intent = getIntent();
        ArrayList<Coordinador> coordinadores = (ArrayList<Coordinador>) intent.getSerializableExtra("coordinadores");
        list.setAdapter(new CustomAdapterCoordinador(this.getApplicationContext(),coordinadores));
    }
}
