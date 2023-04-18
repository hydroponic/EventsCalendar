package com.hydroponic.event_calender.services.repositories;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.hydroponic.event_calender.services.networks.FireAuthExecutor;

public class AuthRepo {
    private static String TAG = "AuthRepo_TAG";

    Context context;
    OnAuthRepo listener;

    FirebaseAuth mAuth;
    Application application;
    public AuthRepo(Application application, OnAuthRepo listener){
        this.application = application;
        this.listener = listener;
        mAuth = FirebaseAuth.getInstance();
    }

    public void createNewAccount(String email, String password){

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new FireAuthExecutor(), new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d(TAG, email+" "+password+ " ==> "+task.isSuccessful());
                        if (task.isSuccessful()) {
                            listener.isAccountCreated(true);
                        } else {
                            listener.isAccountCreated(false);
                        }
                    }

                });
    }


    public void userSignIn(String email, String password){
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(new FireAuthExecutor(), new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d(TAG, email+" "+password+ " ==> "+task.isSuccessful());
                        if (task.isSuccessful()) {
                            listener.isUserSignedIn(true);
                        } else {
                            listener.isUserSignedIn(false);
                        }
                    }
                });
    }
}
