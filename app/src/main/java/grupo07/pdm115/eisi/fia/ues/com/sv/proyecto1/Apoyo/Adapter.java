package grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Apoyo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.R;

   /*
    * Clase para implementar el comportamiento del List View
    * */
public class Adapter extends BaseAdapter{

    List<Clase> mClases = new ArrayList<Clase>();
    Context mCtx;

    public Adapter(Context ctx) {
        mCtx = ctx;
    }

    @Override
    public int getCount() {
        return mClases.size();
    }

    @Override
    public Clase getItem(int position) {
        return mClases.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            LayoutInflater inflater = (LayoutInflater)
                    mCtx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.listview_row,parent,false);

        }
        TextView txtTitulo = (TextView)convertView.findViewById(R.id.txtNombre);
        TextView txtDescripcion = (TextView) convertView.findViewById(R.id.txtDesc);

        Clase temp = mClases.get(position);
        txtTitulo.setText(temp.getNombreClase());
        txtDescripcion.setText(temp.getDescripcionClase());


        return convertView;
    }

    public  void addClase(Clase c){
        mClases.add(c);
        notifyDataSetChanged();
    }

}