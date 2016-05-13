package grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Apoyo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Modelo.Tutor;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.R;

/**
 * Created by Diego on 13/05/2016.
 */
public class CustomAdapterTutor extends BaseAdapter {


    private ArrayList<Tutor> lista;
    private Context context;

    public CustomAdapterTutor(Context context, ArrayList<Tutor> lista) {
        this.context = context;
        this.lista = lista;
    }

    @Override
    public Tutor getItem(int position) {
        return lista.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            LayoutInflater layoutInflater = (LayoutInflater)
                    context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.list_select_row,parent,false);
        }

        TextView textNombre = (TextView) convertView.findViewById(R.id.editTextNombreTutor);
        TextView textEmail = (TextView) convertView.findViewById(R.id.editTextCorreoTutor);
        TextView textTelefono = (TextView) convertView.findViewById(R.id.editTextTelefonoTutor);

        Tutor temp = lista.get(position);

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
