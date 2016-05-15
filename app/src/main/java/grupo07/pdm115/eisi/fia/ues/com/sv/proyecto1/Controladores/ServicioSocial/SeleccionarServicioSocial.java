package grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Controladores.ServicioSocial;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Apoyo.CustomAdapterServicioSocial;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Modelo.ServicioSocial;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.R;

public class SeleccionarServicioSocial extends AppCompatActivity{

    private ListView mList;
    private CustomAdapterServicioSocial mCustomAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccionar_servicio_social);

        enlazarWidgets();
        configurarAdapter();
    }

    private void enlazarWidgets(){
        mList = (ListView) findViewById(R.id.listViewServiciosSociales);
    }

    private void configurarAdapter(){
        Intent i = getIntent();
        ArrayList<ServicioSocial> list = (ArrayList<ServicioSocial>)i.getSerializableExtra("servicios_sociales");
        mList.setAdapter(mCustomAdapter = new CustomAdapterServicioSocial(this.getApplicationContext(),list));
    }
}