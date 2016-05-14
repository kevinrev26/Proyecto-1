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
    private ArrayList<TipoDeActividad> listaTP;


    public CustomAdapterTipoActividad(Context context, ArrayList<TipoDeActividad> listaAc) {
        this.context = context;
        this.listaTP = listaAc;
    }

    @Override
    public int getCount() {
        return listaTP.size();
    }

    @Override
    public TipoDeActividad getItem(int position) {
        return listaTP.get(position);
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

        TextView textId=(TextView) convertView.findViewById(R.id.textIdListaTP);
        TextView textNombre = (TextView) convertView.findViewById(R.id.textNombreTP);
        TextView textHoras = (TextView) convertView.findViewById(R.id.textHorasTP);
        TextView textDesc = (TextView) convertView.findViewById(R.id.textDescTP);

        TipoDeActividad temp = listaTP.get(position);

        textId.setText(temp.getId_tipo_actividad());
        textNombre.setText(temp.getNombre_actividad());
        textHoras.setText(temp.getCantidad_horas());
        textDesc.setText(temp.getDescripcion());

        return convertView;
    }


}


