package grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Controladores.Tutor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Apoyo.CustomAdapterTutor;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Modelo.Tutor;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.R;

public class SeleccionarTutor extends AppCompatActivity {

    private ListView list;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccionar_tutor);
        //EnlazarWdigets
        enlazarWidgets();

        //Configurar adapter
        configurarAdapter();
    }

    private void enlazarWidgets(){
        list = (ListView) findViewById(R.id.listViewSeleccionarTutores);
    }

    private void configurarAdapter(){
        Intent intent = getIntent();
        ArrayList<Tutor> tutores = (ArrayList<Tutor>) intent.getSerializableExtra("tutores");
        list.setAdapter(new CustomAdapterTutor(this.getApplicationContext(), tutores));
    }
}