package grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Controladores.Estudiante;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Apoyo.CustomAdapter;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.DAO.EstudianteDAO;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Modelo.Estudiante;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.R;

public class SeleccionarEstudiante extends AppCompatActivity {

    private ListView mList;

    private CustomAdapter mCustomAdapter;

    //private EstudianteDAO mEstudianteDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccionar_estudiante);
        //mEstudianteDAO = new EstudianteDAO(SeleccionarEstudiante.this);
        enlazarWidgets();
        configurarAdapter();

    }

    private void enlazarWidgets(){
        mList = (ListView) findViewById(R.id.listViewEstudiantes);
    }

    private void configurarAdapter(){
        Intent i = getIntent();
        ArrayList<Estudiante> list = (ArrayList<Estudiante>)i.getSerializableExtra("estudiantes");
        mList.setAdapter(mCustomAdapter= new CustomAdapter(this.getApplicationContext(),list));

    }
}
