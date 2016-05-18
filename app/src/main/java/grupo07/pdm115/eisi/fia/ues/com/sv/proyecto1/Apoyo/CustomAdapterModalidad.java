package grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Apoyo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Modelo.Modalidad;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.R;

/**
 * Created by Diego on 12/05/2016.
 */
public class CustomAdapterModalidad extends BaseAdapter {


    private ArrayList<Modalidad> lista;
    private Context context;

    public CustomAdapterModalidad(Context context, ArrayList<Modalidad> lista) {
        this.context = context;
        this.lista = lista;
    }

    @Override
    public Modalidad getItem(int position) {
        return lista.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            LayoutInflater layoutInflater = (LayoutInflater)
                    context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.listview_row_modalidad,parent,false);
        }

        TextView textNombre = (TextView) convertView.findViewById(R.id.textViewNombreModalidad);

        Modalidad temp = lista.get(position);

        textNombre.setText(temp.getNombre());
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
