package grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Apoyo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Modelo.TipoDeActividad;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.R;

/**
 * Created by Marvin on 12/05/2016.
 */
public class CustomAdapterTipoActividad extends  BaseAdapter {

    private Context context;
    private ArrayList<TipoDeActividad> lista;


    public CustomAdapterTipoActividad(Context context, ArrayList<TipoDeActividad> lista) {
        this.context = context;
        this.lista = lista;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public TipoDeActividad getItem(int position) {
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
                    context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.tp_list_select_row,parent,false);
        }

        TextView textId=(TextView) convertView.findViewById(R.id.textIdLista);
        TextView textNombre = (TextView) convertView.findViewById(R.id.textNombre);
        TextView textHoras = (TextView) convertView.findViewById(R.id.textHoras);
        TextView textDesc = (TextView) convertView.findViewById(R.id.textDesc);

        TipoDeActividad temp = lista.get(position);

        textId.setText(temp.getId_tipo_actividad());
        textNombre.setText(temp.getNombre_actividad());
        textHoras.setText(temp.getCantidad_horas());
        textDesc.setText(temp.getDescripcion());

        return convertView;
    }


}


