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
 * Created by Gabriel on 11/05/2016.
 */
public class TipoActividadCustomAdapter extends BaseAdapter{

    private Context ctx;
    private ArrayList<TipoDeActividad> lista;


    public TipoActividadCustomAdapter(Context ctx, ArrayList<TipoDeActividad> lista) {
        this.ctx = ctx;
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
                    ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.tp_list_select_row,parent,false);
        }

        //TextView textNombre = (TextView) convertView.findViewById(R.id.textNombreLista);
        TextView textId = (TextView) convertView.findViewById(R.id.textIdLista);
        TextView textNomb = (TextView) convertView.findViewById(R.id.textNombre);
        TextView textCantH = (TextView) convertView.findViewById(R.id.textHoras);
        TextView textDescrip = (TextView) convertView.findViewById(R.id.textDesc);

        TipoDeActividad temp = lista.get(position);

        textId.setText(temp.getId_tipo_actividad());
        //textNombre.setText(temp.getNombre());
        textNomb.setText(temp.getNombre_actividad());
        textCantH.setText(temp.getCantidad_horas());
        textDescrip.setText(temp.getDescripcion());

        return convertView;
    }
}
