package grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Apoyo;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import java.io.Serializable;
import java.util.ArrayList;

import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.LoginActivity;
import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Modelo.Permiso;

/**
 * Creado por Kevin Rivera, 05-15-16.
 * Puede usar, modificar y compartir este archivo
 * Consultas y mas: kevinrev26@gmail.com
 */
public class SesionPermisos implements Serializable{

    private Context mContext;
    private boolean loggin;


    private SharedPreferences mPreferences;
    private SharedPreferences.Editor mEditor;

    public final static String PERMISOS = "permisos";
    public final static int MODE=0;


    //private static SesionPermisos instancia;

    public SesionPermisos(Context context) {
        mContext = context;
        mPreferences = mContext.getSharedPreferences(PERMISOS,MODE);
        mEditor = mPreferences.edit();
    }

    private boolean isLogged(){
        loggin = mPreferences.getBoolean("login",false);
        return loggin;
    }

    private void editLoggin(){
        loggin = true;
        mEditor.putBoolean("login",loggin);
        mEditor.commit();
    }

    public void checkLogin(){
        if (!this.isLogged()) {
            Intent i = new Intent(this.mContext, LoginActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            editLoggin();
            mContext.startActivity(i);

        }
    }

    public void configurarPermisos(ArrayList<Permiso> permisos){

        for (Permiso p: permisos) {
            mEditor.putInt(String.valueOf(p.getIdOpcion()),p.getIdUsuario());
        }

        mEditor.commit();

    }

    public int getPermiso(int idOpcion){
        return mPreferences.getInt(String.valueOf(idOpcion),0);
    }

    public void logout(){
        mEditor.clear();
        mEditor.commit();
        Intent i = new Intent(mContext, LoginActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        mContext.startActivity(i);
    }
}
