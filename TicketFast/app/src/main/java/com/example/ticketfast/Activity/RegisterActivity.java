package com.example.ticketfast.Activity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.icu.text.UnicodeSetSpanner;
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
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.iid.FirebaseInstanceId;


public class RegisterActivity extends AppCompatActivity {


    private EditText emailedt;
    private EditText senhaedt;
    private EditText nomeedt;
    private Button registrobtn;
    private Button loginbtn;
    private FirebaseAuth mAuth;
    private EditText confSenhaedt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //Definir orientação como portrait
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        emailedt = findViewById(R.id.register_email);
        senhaedt = findViewById(R.id.register_password);
        nomeedt = findViewById(R.id.register_name);
        registrobtn = findViewById(R.id.register_btn);
        confSenhaedt = findViewById(R.id.confirm_password);


        mAuth = FirebaseAuth.getInstance();



        registrobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String name = nomeedt.getText().toString();
                String email = emailedt.getText().toString();
                String senha = senhaedt.getText().toString();
                String confSenha = confSenhaedt.getText().toString();

                    if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(email) && !TextUtils.isEmpty(senha)&& !TextUtils.isEmpty(confSenha) && senha.equals(confSenha)) {

                        mAuth.createUserWithEmailAndPassword(email, senha).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull final Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    //POST do usuario para API
                                    Toast.makeText(getApplicationContext(),"Cadastrado com sucesso",Toast.LENGTH_LONG).show();
                                    Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
                                    startActivity(intent);
                                } else {
                                    Toast.makeText(getApplicationContext(), "Error:" + task.getException().getMessage(), Toast.LENGTH_LONG).show();

                                }
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(getApplicationContext(), "Error:" + e.getMessage(), Toast.LENGTH_LONG).show();
                            }
                        });
                    } else {
                    validarCampos();
                }
            }
        });
    }

    private void validarCampos() {
        if (nomeedt.getText().toString().isEmpty()) {
            nomeedt.setError("Digite seu nome");
        }
        if (emailedt.getText().toString().isEmpty()) {
            emailedt.setError("Digite seu email");
        }
        if (senhaedt.getText().toString().isEmpty()) {
            senhaedt.setError("Escolha uma senha com mais de 6 caracteres");
        }
        if (confSenhaedt.getText().toString().isEmpty()) {
            confSenhaedt.setError("Confirme sua senha");
        }if(!senhaedt.getText().toString().equals(confSenhaedt.getText().toString())){
            senhaedt.setError("Confira sua senha");
            senhaedt.setError("Confirme sua senha");
        }



    }
}
