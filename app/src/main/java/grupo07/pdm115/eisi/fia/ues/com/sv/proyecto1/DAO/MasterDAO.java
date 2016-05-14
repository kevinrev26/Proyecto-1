package grupo07.pdm115.eisi.fia.ues.com.sv.proyecto1.DAO;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

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
        Log.i("MasterDAO","Constructor MasterDAO: "+mDatabase);
    }

    private  void abrirDB(){
        if (manager == null){
            manager = DatabaseManager.getInstance(this.mContext);
            mDatabase = manager.getWritableDatabase();
           // Log.i("DAO","Abriendo la BD");
        } else {
            mDatabase = manager.getWritableDatabase();
            //Log.i("DAO","Abriendo la BD con else");
        }
    }

    public String versionDB(){
        abrirDB();
        Cursor cursor  = mDatabase.openOrCreateDatabase(":memory:",null)
                .rawQuery("SELECT sqlite_version() AS sqlite_version",null);
        String sqliteVersion = "";
        while (cursor.moveToNext()){
            sqliteVersion += cursor.getString(0);
        }

        return sqliteVersion;
    }

}
