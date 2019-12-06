package com.adisteinfeld.Moneyz;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Country.class}, version = 1, exportSchema = false)
public abstract class AppDB extends RoomDatabase {
    public static void createCountriesDB(Context applicationContext) {
        AppDB db = Room.databaseBuilder(applicationContext,
                AppDB.class, "app_db_name").allowMainThreadQueries().createFromAsset("dataB.db").build();

        String[] countriesList = db.dbQueries().loadAllCountries();
        double israel_rate = db.dbQueries().getCurrencyAndRateFromCountry("Israel");
    }

    public abstract DbQueries dbQueries();


    /*    RoomDatabase.Callback fillTable = new RoomDatabase.Callback() {
        public void onCreate(SupportSQLiteDatabase db) {
            Room.databaseBuilder(getApplicationContext(), AppDB.class, "app_db_name")
                    .createFromAsset("Countries.db")
                    .build();
        }
    };*/
}
