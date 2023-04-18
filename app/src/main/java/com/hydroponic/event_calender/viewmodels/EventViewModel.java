package com.hydroponic.event_calender.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.hydroponic.event_calender.services.models.Event;
import com.hydroponic.event_calender.services.repositories.EventRepo;
import com.hydroponic.event_calender.services.repositories.OnEventRepo;

import java.util.List;

public class EventViewModel extends AndroidViewModel implements OnEventRepo {
    EventRepo eventRepo;
    MutableLiveData<Boolean> isBackUpDoneVar = new MutableLiveData<>();

    public EventViewModel(@NonNull Application application) {
        super(application);
        eventRepo = new EventRepo(application, this);

    }

    public LiveData<List<Event>> getParticularDateEvents(String date){
        return eventRepo.getParticularDateEvents(date);
    }
    public void insertEvent(Event event){
        eventRepo.insertOneEvent(event);
    }

    public void clearAll(){
        eventRepo.ClearAcc();
    }

    public void backUpEventsToCloud(List<Event> events){
        eventRepo.backupToCloud(events);
    }

    @Override
    public void isBackupDone(boolean val) {
        isBackUpDoneVar.postValue(val);
    }

    public MutableLiveData<Boolean> getIsBackUpDoneState(){
        return isBackUpDoneVar;
    }

    public LiveData<List<Event>> getAllEvents(){
        return  eventRepo.getAllEvents();
    }

    public void getEventsFromCloud(){
        eventRepo.getEventsFromCloud();
    }
}
