package grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Controladores.Institucion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Apoyo.CustomAdapterInstitucion;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Modelo.Institucion;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.R;

public class SeleccionarInstitucion extends AppCompatActivity {

    private ListView mList;
    private CustomAdapterInstitucion mCustomAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccionar_institucion);

        enlazarWidgets();
        configurarAdapter();
    }

    private void enlazarWidgets(){
        mList = (ListView) findViewById(R.id.listViewInstituciones);
    }

    private void configurarAdapter(){
        Intent i = getIntent();
        ArrayList<Institucion> list = (ArrayList<Institucion>) i.getSerializableExtra("instituciones");
        mList.setAdapter(mCustomAdapter = new CustomAdapterInstitucion(this.getApplicationContext(),list));
    }
}
