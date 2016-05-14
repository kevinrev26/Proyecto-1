package grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Apoyo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Modelo.Estudiante;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.R;

/**
 * Creado por Kevin Rivera, 05-08-16.
 * Puede usar, modificar y compartir este archivo
 * Consultas y mas: kevinrev26@gmail.com
 */
public class CustomAdapter extends BaseAdapter {


    private Context ctx;
    private ArrayList<Estudiante> lista;



    public CustomAdapter(Context ctx, ArrayList<Estudiante> lista) {
        this.ctx = ctx;
        this.lista = lista;
    }


    @Override
    public int getCount() { return lista.size();
    }

    @Override
    public Estudiante getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            LayoutInflater layoutInflater = (LayoutInflater)
                    ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.list_select_row,parent,false);
        }

        TextView textNombre = (TextView) convertView.findViewById(R.id.textNombreLista);
        TextView textCarnet = (TextView) convertView.findViewById(R.id.textCarnetLista);
        TextView textCorreo = (TextView) convertView.findViewById(R.id.textCorreoLista);
        TextView textTelefono = (TextView) convertView.findViewById(R.id.textTelefonoLista);
        TextView textCarrera = (TextView) convertView.findViewById(R.id.textCarreraLista);

        Estudiante temp = lista.get(position);

        textCarnet.setText(temp.getCarnet());
        textNombre.setText(temp.getNombre());
        textCorreo.setText(temp.getEmail());
        textTelefono.setText(temp.getTelefono());
        textCarrera.setText(temp.getCarrera());

        return convertView;
    }
}
