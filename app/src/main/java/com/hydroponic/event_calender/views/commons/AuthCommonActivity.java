package com.hydroponic.event_calender.views.commons;

import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AuthCommonActivity extends AppCompatActivity {


    public boolean validate(String email, String password) {

        if(email == null || email.isEmpty()){
            Toast.makeText(this, "Please enter your email", Toast.LENGTH_LONG).show();
            return false;
        }

        else if(password == null || password.isEmpty()){
            Toast.makeText(this, "Please enter your password", Toast.LENGTH_LONG).show();
            return false;
        }
        else if(password.length() < 6){
            Toast.makeText(this, "Password must be greater than 6 characters", Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }
}
