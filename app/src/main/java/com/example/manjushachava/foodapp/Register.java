package com.example.manjushachava.foodapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Register extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private Button button;
    private EditText password;
    private EditText email;
    private ProgressDialog progress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAuth.getInstance();
        setContentView(R.layout.activity_register);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        mAuth = FirebaseAuth.getInstance();

        button = (Button) findViewById(R.id.registerButton);
        password = (EditText) findViewById(R.id.passwordField);
        email = (EditText) findViewById(R.id.emailField);

        progress = new ProgressDialog(this);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(mAuth.getCurrentUser() != null){
                    Toast.makeText(Register.this, "A user is currently logged in!", Toast.LENGTH_LONG);
                } else {
                    String emailString = email.getText().toString().trim();
                    String passwordString = password.getText().toString().trim();
                        if(TextUtils.isEmpty(emailString)){
                        Toast.makeText(Register.this, "Input for email is required", Toast.LENGTH_LONG);
                        } else if (TextUtils.isEmpty(passwordString)){
                            Toast.makeText(Register.this, "Input for password is required", Toast.LENGTH_LONG);
                        }
                    progress.setMessage("System Processing ...");
                    progress.show();

                    mAuth.createUserWithEmailAndPassword(emailString, passwordString)
                            .addOnCompleteListener(Register.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if(task.isSuccessful()){
                                        Toast.makeText(Register.this, "Your account has been created. Enjoy!", Toast.LENGTH_LONG);
                                    }

                                }
                            });

                    }
            }
        });


   }

    @Override
    public void onStart() {
    super.onStart();

    }

}
