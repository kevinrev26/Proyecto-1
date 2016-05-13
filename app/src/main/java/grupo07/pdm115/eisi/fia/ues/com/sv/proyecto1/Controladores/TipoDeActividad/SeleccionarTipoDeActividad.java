package grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Controladores.TipoDeActividad;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Apoyo.CustomAdapterTipoActividad;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Modelo.TipoDeActividad;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.R;

public class SeleccionarTipoDeActividad extends AppCompatActivity {

    private ListView mList;
    private CustomAdapterTipoActividad nCustomAdapterTp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccionar_tipo_de_actividad);

        enlazarWidgets();
        configurarAdapter();

    }

    private void enlazarWidgets(){
        mList = (ListView) findViewById(R.id.listViewTiposActividades);
    }

    private void configurarAdapter(){
        Intent i = getIntent();
        ArrayList<TipoDeActividad> list = (ArrayList<TipoDeActividad>)i.getSerializableExtra("TiposDeActividades");
        mList.setAdapter(nCustomAdapterTp = new CustomAdapterTipoActividad(this.getApplicationContext(),list));

    }
}
