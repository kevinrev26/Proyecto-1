package grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Apoyo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Modelo.Coordinador;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.R;

/**
 * Creado por Kevin Rivera, 05-11-16.
 * Puede usar, modificar y compartir este archivo
 * Consultas y mas: kevinrev26@gmail.com
 */
public class CustomAdapterCoordinador extends BaseAdapter{


    private ArrayList<Coordinador> lista;
    private Context context;

    public CustomAdapterCoordinador(Context context, ArrayList<Coordinador> lista) {
        this.context = context;
        this.lista = lista;
    }

    @Override
    public Coordinador getItem(int position) {
        return lista.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            LayoutInflater layoutInflater = (LayoutInflater)
                    context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.listview_row_coordinador,parent,false);
        }

        TextView textNombre = (TextView) convertView.findViewById(R.id.textViewNombreCoordinador);
        TextView textEmail = (TextView) convertView.findViewById(R.id.textViewEmailCoordinador);
        TextView textTelefono = (TextView) convertView.findViewById(R.id.textViewTelefonoCoordinador);

        Coordinador temp = lista.get(position);

        textNombre.setText(temp.getNombre());
        textEmail.setText(temp.getEmail());
        textTelefono.setText(temp.getTelefono());

        return convertView;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getCount() {
        return lista.size();
    }
}
