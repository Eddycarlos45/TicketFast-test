package com.example.ticketfast.Activity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ticketfast.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.iid.FirebaseInstanceId;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    private EditText emailedt;
    private EditText senhaedt;
    private Button loginbtn;
    private Button registrobtn;
    private FirebaseAuth mAuth;
    //  private FirebaseFirestore mFirestore;


    @Override
    protected void onStart() {
        super.onStart();

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Definir orientação como portrait
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        emailedt = findViewById(R.id.login_email);
        senhaedt = findViewById(R.id.login_password);
        loginbtn = findViewById(R.id.login_btn);
        registrobtn = findViewById(R.id.login_register_btn);
        mAuth = FirebaseAuth.getInstance();
     //   mFirestore = FirebaseFirestore.getInstance();

        registrobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(registerIntent);
            }
        });
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailedt.getText().toString();
                String senha = senhaedt.getText().toString();
                if (!TextUtils.isEmpty(email) && !TextUtils.isEmpty(senha)) {
                    mAuth.signInWithEmailAndPassword(email, senha).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                sendToEvent();
                            } else {
                                Toast.makeText(getApplicationContext(), "Error:" + task.getException().getMessage(), Toast.LENGTH_LONG).show();
                            }
                        }
                    });
                } else {
                    validaEmail();
                }

            }
        });


    }

    private void sendToEvent() {
        Intent eventIntent = new Intent(LoginActivity.this, EventsActivity.class);
        startActivity(eventIntent);
        finish();
    }

    private void validaEmail() {
        if (emailedt.getText().toString().isEmpty()) {
            emailedt.setError("Preencha com seu email");

            if (senhaedt.getText().toString().isEmpty()) {
                senhaedt.setError("Preencha com sua senha");
            }
        }

    }


}
