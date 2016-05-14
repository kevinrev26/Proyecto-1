package grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Apoyo;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Modelo.Institucion;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.R;

public class CustomAdapterInstitucion extends BaseAdapter {


    private Context ctx;
    private ArrayList<Institucion> lista;



    public CustomAdapterInstitucion(Context ctx, ArrayList<Institucion> lista) {
        this.ctx = ctx;
        this.lista = lista;
    }


    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Institucion getItem(int position) {
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
            convertView = layoutInflater.inflate(R.layout.list_select_row_institucion,parent,false);
        }

        TextView textIdIns = (TextView) convertView.findViewById(R.id.textViewIdIns);
        TextView textNombreIns = (TextView) convertView.findViewById(R.id.textViewNomIns);
        TextView textNombreEncIns = (TextView) convertView.findViewById(R.id.textViewNomEnc);
        TextView textCorreoIns = (TextView) convertView.findViewById(R.id.textViewEmalIns);
        TextView textTelefono1Ins = (TextView) convertView.findViewById(R.id.textViewTel1);
        TextView textTelefono2Ins = (TextView) convertView.findViewById(R.id.textViewTel2);

        Institucion temp = lista.get(position);

        textIdIns.setText(temp.getIdInstitucion());
        textNombreIns.setText(temp.getNombreInstitucion());
        textNombreEncIns.setText(temp.getNombreEncargado());
        textCorreoIns.setText(temp.getEmailInstitucion());
        textTelefono1Ins.setText(temp.getTelefono1());
        textTelefono2Ins.setText(temp.getTelefono2());

        return convertView;
    }
}
