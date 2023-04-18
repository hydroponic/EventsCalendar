package com.hydroponic.event_calender.services.locals;

import android.content.Context;

import androidx.room.Room;

public class AppDatabaseInstance {
    private static AppDatabase appDatabase;

    public static synchronized AppDatabase getAppDatabaseInstance(Context context){
        if(appDatabase == null){
            appDatabase = Room.databaseBuilder(context.getApplicationContext(),
                    AppDatabase.class , "event_cal_db")
                    .fallbackToDestructiveMigration().allowMainThreadQueries()
                        .build();
        }
        return appDatabase;
    }
}
