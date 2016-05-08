package grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Controladores.Estudiante;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.DAO.EstudianteDAO;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Modelo.Estudiante;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.R;

public class EliminarEstudiante extends AppCompatActivity implements AdapterView.OnItemSelectedListener{


    //Widgets
    private Spinner mSpinner;

    //DAO
    private EstudianteDAO  mEstudianteDAO;

    //Bandera para controlar el spinner
    private boolean bandera = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar_estudiante);
        mSpinner = (Spinner) findViewById(R.id.spinnerEliminar);
        mSpinner.setOnItemSelectedListener(this);
        mEstudianteDAO = new EstudianteDAO(EliminarEstudiante.this);
        //Configurar
        configurarSpinner();
    }

    public void configurarSpinner(){
        ArrayAdapter<Estudiante> adapter = new ArrayAdapter<Estudiante>(this,android.R.layout.simple_spinner_item,
                mEstudianteDAO.getListaEstudiantes());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinner.setAdapter(adapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (bandera){
            bandera = false;
        } else {

            final Estudiante e = (Estudiante) parent.getItemAtPosition(position);

            //Toast.makeText(EliminarEstudiante.this, "Seleccionado: "+e.getCarnet(), Toast.LENGTH_SHORT).show();
            final AlertDialog show = new AlertDialog.Builder(this)
                    .setTitle("Eliminar estudiante")
                    .setMessage("Se eliminara a: " + e.getNombre() + ", ¿Esta seguro?")
                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            if (mEstudianteDAO.eliminarEstudiante(e.getCarnet()) == 1) {
                                Toast.makeText(EliminarEstudiante.this, "Estudiante eliminado", Toast.LENGTH_SHORT).show();
                                EliminarEstudiante.this.finish();
                            }
                        }
                    })
                    .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // do nothing
                        }
                    })
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        //Do nothing

    }
}
