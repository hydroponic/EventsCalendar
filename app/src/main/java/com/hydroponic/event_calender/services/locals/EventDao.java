package com.hydroponic.event_calender.services.locals;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.hydroponic.event_calender.services.models.Event;

import java.util.List;

@Dao
public interface EventDao {
    @Insert
    void insert(Event event);

    @Update
    void update(Event event);

    @Delete
    void delete(Event event);

    @Query("DELETE FROM events_table")
    void deleteAllNotes();

    @Query("SELECT * FROM events_table")
    LiveData<List<Event>> getAllEvents();

    @Query("SELECT * FROM events_table WHERE date= :date")
    LiveData<List<Event>> getAllEventsOfParticularDate(String date);

    @Insert
    void insertAll(Event... events);
}
