package com.example.myapplication;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.Toast;


public class SplashScreen extends AppCompatActivity {
    private ProgressBar progressBar;
    int i;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setStatusBarColor(ContextCompat.getColor(SplashScreen.this,R.color.colorSecondary));
        //for full screen

        setContentView(R.layout.activity_splash_screen);
        progressBar=(ProgressBar) findViewById(R.id.progressId);


       Thread thread=new Thread(new Runnable() {
           @Override
           public void run() {
               dowork();
               intent();
           }
       });
       thread.start();

    }
    public void dowork(){
        for(i=20;i<=100;i=i+20 )
        {
            try {
                Thread.sleep(500);
                progressBar.setProgress(i);


            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
    public void intent(){
        Intent i=new Intent(SplashScreen.this,MainActivity.class);
        startActivity(i);

        finish();
    }
}