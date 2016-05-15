package grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Apoyo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Modelo.Institucion;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Modelo.ServicioSocial;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.R;

/**
 * Created by Usuario on 14/05/2016.
 */
public class CustomAdapterServicioSocial extends BaseAdapter {


    private Context ctx;
    private ArrayList<ServicioSocial> lista;



    public CustomAdapterServicioSocial(Context ctx, ArrayList<ServicioSocial> lista) {
        this.ctx = ctx;
        this.lista = lista;
    }


    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public ServicioSocial getItem(int position) {
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
            convertView = layoutInflater.inflate(R.layout.listview_row_servicio_social,parent,false);
        }

        TextView mIdSSText = (TextView) convertView.findViewById(R.id.textViewIdSS);
        TextView mTituloSSText = (TextView) convertView.findViewById(R.id.textViewTituloSS);
        TextView mDesSSText = (TextView) convertView.findViewById(R.id.textViewDesSS);
        TextView mDispSSText= (TextView) convertView.findViewById(R.id.textViewDispSS);
        TextView mIdInsSSText = (TextView) convertView.findViewById(R.id.textViewIdInsSS);
        TextView mIdModSSText = (TextView) convertView.findViewById(R.id.textViewIdModSS);
        TextView mIdTutorSSText = (TextView) convertView.findViewById(R.id.textViewIdTutorSS);
        TextView mCooAprSSText = (TextView) convertView.findViewById(R.id.textViewCooAprSS);

        ServicioSocial temp = lista.get(position);

        mIdSSText.setText(temp.getIdServicio());
        mTituloSSText.setText(temp.getTitulo());
        mDesSSText.setText(temp.getDescripcion());
        mDispSSText.setText(temp.getDisponible());
        mIdInsSSText.setText(temp.getIdentificadorInstitucion());
        mIdModSSText.setText(temp.getIdentificadorModalidad());
        mIdTutorSSText.setText(temp.getIdentificadorTutor());
        mCooAprSSText.setText(temp.getCoordinadorAprobado());

        return convertView;
    }
}
