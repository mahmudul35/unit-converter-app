package com.example.myapplication;

import android.annotation.SuppressLint;

import android.content.Intent;
//import android.support.annotation.NonNull;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity {
    TextView btn;

    private EditText inputUsername,inputPassword,inputEmail,inputConfirmPassword;
    Button btnRegister,signin;
    FirebaseDatabase rootNode;
    DatabaseReference reference;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        //status bar color
        getWindow().setStatusBarColor(ContextCompat.getColor(Register.this,R.color.colorSecondary));
        signin=findViewById(R.id.signIn);
        btn=findViewById(R.id.signInTextViewId);
        inputUsername=findViewById(R.id.username);
        inputEmail=findViewById(R.id.email);
        inputPassword=findViewById(R.id.password);
        inputConfirmPassword=findViewById(R.id.Repassword);


        btnRegister=findViewById(R.id.signUpButtonId);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
                
                rootNode=FirebaseDatabase.getInstance();
                reference=rootNode.getReference("users");
                //get all the values
                String username=inputUsername.getText().toString();
                String email=inputEmail.getText().toString().trim();
                String password=inputPassword.getText().toString().trim();
                String confirmPassword=inputConfirmPassword.getText().toString().trim();
                String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

                //validatiom
                if(!username.isEmpty()){
                    inputUsername.setError(null);

                    if(!email.isEmpty() && email.matches(emailPattern))
                    {
                        inputEmail.setError(null);
                      if(!password.isEmpty() && password.length()>5){
                          inputPassword.setError(null);
                          if(password.matches(confirmPassword)){
                              HelperClass helperClass=new HelperClass(username,email,password,confirmPassword);
                              reference.child(username).setValue(helperClass);
                              Toast.makeText(Register.this, "Successfully Register", Toast.LENGTH_SHORT).show();
                              //Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                              //startActivity(intent);
                          }
                          else
                          {
                              inputConfirmPassword.setError("Password not match");
                              inputConfirmPassword.requestFocus();
                          }
                      }else{
                          inputPassword.setError("Password must be 6 character");
                          inputPassword.requestFocus();
                      }

                    }
                  else{
                      inputEmail.setError("Invalid email");
                      inputEmail.requestFocus();
                    }
                }else
                {
                    inputUsername.setError("Username Not valid");
                    inputUsername.requestFocus();
                }



            }
        });
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });

    }



}
