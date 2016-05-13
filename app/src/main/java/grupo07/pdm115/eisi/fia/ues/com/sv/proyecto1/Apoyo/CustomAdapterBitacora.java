package grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Apoyo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Modelo.Bitacora;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.R;

/**
 * Created by Marvin on 12/05/2016.
 */
public class CustomAdapterBitacora extends BaseAdapter{

    private ArrayList<Bitacora> lista;
    private Context context;

    public CustomAdapterBitacora(Context context, ArrayList<Bitacora> lista) {
        this.context = context;
        this.lista = lista;
    }

    @Override
    public Bitacora getItem(int position) {
        return lista.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            LayoutInflater layoutInflater = (LayoutInflater)
                    context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.listview_row_coordinador,parent,false);
        }

        TextView textId = (TextView) convertView.findViewById(R.id.textViewIdentificador);
        TextView textFechaIn = (TextView) convertView.findViewById(R.id.textViewFechaInicio);
        TextView textFechaF = (TextView) convertView.findViewById(R.id.textViewFechaFin);
        TextView textRevCo = (TextView) convertView.findViewById(R.id.textViewRevisionCoordinador);
        TextView textRevTu = (TextView) convertView.findViewById(R.id.textViewRevisionTutor);
        TextView textIdAct = (TextView) convertView.findViewById(R.id.textViewIdentificadorActividad);

        Bitacora temp = lista.get(position);

        textId.setText(temp.getId_bitacora());
        textFechaIn.setText(temp.getFecha_inicio());
        textFechaF.setText(temp.getFecha_fin());
        textRevCo.setText(temp.getRevision_coordinador());
        textRevTu.setText(temp.getRevision_tutor());
        textIdAct.setText(temp.getIdentificador_actividad());

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

