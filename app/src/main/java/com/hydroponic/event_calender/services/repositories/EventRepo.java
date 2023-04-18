package com.hydroponic.event_calender.services.repositories;

import android.app.Application;
import android.content.Context;


import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.hydroponic.event_calender.services.locals.AppDatabase;
import com.hydroponic.event_calender.services.locals.AppDatabaseInstance;
import com.hydroponic.event_calender.services.locals.EventDao;
import com.hydroponic.event_calender.services.models.Event;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventRepo{
    private static final String TAG = "EventRepo_TAG";
    private EventDao eventDao;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    OnEventRepo listener;
    Context context;

    public EventRepo(Application application, OnEventRepo listener) { //application is subclass of context
        AppDatabase database = AppDatabaseInstance.getAppDatabaseInstance(application);
        this.context = application;
        eventDao = database.eventDao();
        this.listener = listener;
    }

    public void insertOneEvent(Event event){
        new Thread(new Runnable() {
            @Override
            public void run() {
                eventDao.insert(event);
            }
        }).start();
    }
    public void ClearAcc() {
        eventDao.deleteAllNotes();
    }
    public LiveData<List<Event>> getParticularDateEvents(String date){
        return eventDao.getAllEventsOfParticularDate(date);
    }

    public LiveData<List<Event>> getAllEvents(){
        return eventDao.getAllEvents();
    }


    public void backupToCloud(List<Event> events){

        System.out.println("starts");
        Map<String , Event> datas = new HashMap<>();
        for(Event item: events){
            datas.put(item.uid, item);
        }


        db.collection("event_db")
                .document(FirebaseAuth.getInstance().getCurrentUser().getUid())
                .set(datas)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                      //  Log.d(TAG, "EVENTAS: "+ events);
                        listener.isBackupDone(true);
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        listener.isBackupDone(false);
                    }
                });
    }



    public List<Event> getEventsFromCloud() {
        db.collection("event_db")
                .document(FirebaseAuth.getInstance().getCurrentUser().getUid())
                .get()
                .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                Collection<Object> objectCollection = task.getResult().getData().values();
                //Log.d(TAG, "FireDATA: "+objectCollection.size());

                Gson gson = new Gson();
                List<Event> eventList = new ArrayList<>();

                for(Object obj:   objectCollection){
                    JsonElement jsonElement = gson.toJsonTree(obj);
                    Event event = gson.fromJson( jsonElement, Event.class);
                    eventList.add(event);

                }

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        eventDao.insertAll(eventList.toArray(new Event[eventList.size()]));
                    }
                }).start();


            }
        });

        return new ArrayList<>();

    }
}
