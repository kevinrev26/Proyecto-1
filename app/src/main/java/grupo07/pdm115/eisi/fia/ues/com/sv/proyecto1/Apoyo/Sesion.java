package grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Apoyo;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Creado por Kevin Rivera, 05-14-16.
 * Puede usar, modificar y compartir este archivo
 * Consultas y mas: kevinrev26@gmail.com
 */
public class Sesion {

    private Context mContext;
    private boolean mFirstTime;
    private boolean loggin;

    private SharedPreferences mPreferences;
    private SharedPreferences.Editor mEditor;


    private static final String PREFERENCIAS = "preferencias";
    private static final int MODE = 0;

    public Sesion(Context context) {
        mContext = context;
        mPreferences = mContext.getSharedPreferences(PREFERENCIAS,MODE);
        mEditor = mPreferences.edit();
    }

    public boolean isFirstTime(){
        mFirstTime = mPreferences.getBoolean("loggin",false);
        return mFirstTime;
    }

    public void editFirstTime(){
        mFirstTime=true;
        mEditor.putBoolean("loggin",mFirstTime);
        mEditor.commit();
    }


}
