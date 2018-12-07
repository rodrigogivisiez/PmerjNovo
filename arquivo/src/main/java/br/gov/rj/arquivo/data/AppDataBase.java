package br.gov.rj.arquivo.data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.util.Log;

import br.gov.rj.arquivo.ui.menu.MenuDevItem;


@Database(entities = {



        //Menu
        MenuDevItem.class

}, version = 2, exportSchema = false)
//@TypeConverters(DateConverter.class)
public abstract class AppDataBase extends RoomDatabase {

    private static final String LOG_TAG = AppDataBase.class.getSimpleName();
    private static final Object LOCK = new Object();
    private static final String DATABASE_NAME = "";
    private static final String DATABASE_NAME_SQLITE_FILE = "pmerj3.db";

    private static AppDataBase sInstance;

    public static AppDataBase getsInstance(Context context) {
        if (sInstance == null) {
            synchronized (LOCK) {
                Log.d(LOG_TAG, "Creating new Database Instance");

                sInstance = Room.databaseBuilder(context.getApplicationContext(), AppDataBase.class, AppDataBase.DATABASE_NAME_SQLITE_FILE)
                        .allowMainThreadQueries()
                       // .fallbackToDestructiveMigration()
                        .build();
                Log.v("testedb", "banco inicial criado com sucesso");
            }

        }
        Log.d(LOG_TAG, "Getting the Database instance");
        return sInstance;
    }





    //Menu DAO
     public abstract MenuDevItemDao MenuDevItemDao();



}
