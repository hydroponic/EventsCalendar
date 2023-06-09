package com.hydroponic.event_calender.views.ui;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.hydroponic.event_calender.R;
import com.hydroponic.event_calender.viewmodels.AuthViewModel;
import com.hydroponic.event_calender.views.commons.AuthCommonActivity;

public class LoginActivity extends AuthCommonActivity {
    private static final String TAG = "Login_TAG";
    EditText mEmail, mPassword;
    Button mLoginBtn;
    AuthViewModel authViewModel;
    String email, password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initWidgets();

        authViewModel = new ViewModelProvider(this).get(AuthViewModel.class);

        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = mEmail.getText().toString();
                password = mPassword.getText().toString();
                Log.d(TAG, email+" "+password);
                if(validate(email, password)){
                    authViewModel.loggedInUser(email, password);
                }
            }
        });

        authViewModel.getIsUserLoggedIn().observe(LoginActivity.this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                Log.d(TAG, "LoginOb: "+ aBoolean);
                if(aBoolean != null){
                    if(aBoolean){
                        Toast.makeText(LoginActivity.this, "Logged In", Toast.LENGTH_SHORT).show();
                        goToMainActivity();
                    }
                    else{
                        Toast.makeText(LoginActivity.this, "Login failed !", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


    }


    private void initWidgets() {
        mEmail = findViewById(R.id.et_email);
        mPassword = findViewById(R.id.et_password);
        mLoginBtn = findViewById(R.id.btn_login);
    }


    public void gotoRegisterScreen(View view) {
        startActivity(new Intent(this, RegisterActivity.class));
        finish();
        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);

    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            goToMainActivity();
            Log.d(TAG, "User: "+user.toString());
        }

    }

    private void goToMainActivity() {
        // User is signed in
        startActivity(new Intent(this, MainActivity.class));
        finish();
        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);

    }
}