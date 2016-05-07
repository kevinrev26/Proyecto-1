package grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.DAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.Modelo.DatabaseManager;

/**
 * Creado por Kevin Rivera, 05-07-16.
 * Puede usar, modificar y compartir este archivo
 * Consultas y mas: kevinrev26@gmail.com
 */
public class MasterDAO {
    protected SQLiteDatabase mDatabase;
    private DatabaseManager manager;
    private Context mContext;

    public MasterDAO(Context ctx){
        this.mContext = ctx;
        this.manager = DatabaseManager.getInstance(ctx);
        abrirDB();
    }

    public void abrirDB(){
        if (manager == null){
            manager = DatabaseManager.getInstance(this.mContext);
            mDatabase = manager.getReadableDatabase();
        }
    }

}
