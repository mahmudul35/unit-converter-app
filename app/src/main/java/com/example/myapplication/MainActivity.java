package com.example.myapplication;

import android.annotation.SuppressLint;

import android.content.DialogInterface;
import android.content.Intent;
//import android.support.annotation.NonNull;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;

import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;


import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;


public class MainActivity extends AppCompatActivity {
    private TextInputEditText username_view, inputPassword;
    private TextInputLayout passwordField;
    private TextView btn;
    private Button loginBtn;
    TextInputLayout passwordLayout;

    private ProgressBar progressBar;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //statusbar color set
        getWindow().setStatusBarColor(ContextCompat.getColor(MainActivity.this,R.color.yellow));


        username_view = findViewById(R.id.signInEmail);
        inputPassword = findViewById(R.id.signInPassword);
        loginBtn = (Button) findViewById(R.id.loginBtnId);
        btn = findViewById(R.id.signInTextViewId);
        progressBar = findViewById(R.id.progressbarId);
        passwordLayout = findViewById(R.id.password_field);



        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
                DatabaseReference databaseReference=firebaseDatabase.getReference("users");
                String username = username_view.getText().toString().trim();
                String password = inputPassword.getText().toString().trim();
                Query check_username = databaseReference.orderByChild("username").equalTo(username);

                progressBar.setVisibility(View.VISIBLE);
                check_username.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.exists()){
                            username_view.setError(null);
                            String check_password = snapshot.child(username).child("password").getValue(String.class);

                            if(check_password.equals(password)){
                                //share username

                                startActivity(new Intent(getApplicationContext(),NavigationBarView.class));
                                finish();
                                progressBar.setVisibility(View.GONE);
                            }else{
                                passwordLayout.setHelperText("Password Incorrect");
                                passwordLayout.requestFocus();
                                progressBar.setVisibility(View.GONE);
                            }
                        }else{
                            username_view.setError("User not register!");
                            username_view.requestFocus();
                            progressBar.setVisibility(View.GONE);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });


            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Intent intent=new Intent(getApplicationContext(),Register.class);
            startActivity(intent);

            }
        });

    }

    @Override
    public void onBackPressed() {


            AlertDialog.Builder alertDiologue = new AlertDialog.Builder(MainActivity.this);
            alertDiologue.setTitle("Exit App");
            alertDiologue.setMessage("Do you want to close app?");
            alertDiologue.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                    finishAffinity();
                }
            });
            alertDiologue.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });
            alertDiologue.show();


        }
    }



