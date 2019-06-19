package com.example.ticketfast.Activity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.ticketfast.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {


    FirebaseAuth mAuth = FirebaseAuth.getInstance();
    FirebaseUser currentUser = mAuth.getCurrentUser();
    @Override
    protected void onStart() {
        super.onStart();
        verificaUsuario();
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Definir orientação como portrait
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        mAuth = FirebaseAuth.getInstance();
        verificaUsuario();
    }

    public void verificaUsuario(){
        if (currentUser == null) {
            sendToLogin();
        }else{
            sendToEvent();
        }
    }
    private void sendToEvent () {
        Intent eventIntent = new Intent(MainActivity.this, EventsActivity.class);
        startActivity(eventIntent);
        finish();
    }

    private void sendToLogin() {
        Intent loginIntent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(loginIntent);
        finish();
    }
}
