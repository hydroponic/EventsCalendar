package com.hydroponic.event_calender.services.locals;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.hydroponic.event_calender.services.models.Event;

@Database(entities = {Event.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract EventDao eventDao();
}