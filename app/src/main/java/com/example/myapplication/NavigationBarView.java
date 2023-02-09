package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
//import android.support.v7.widget.CardView;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class NavigationBarView extends AppCompatActivity {
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationview;
    private CardView mass;
    private CardView temp;
    private CardView len;
    private CardView area;
    private CardView currency;
    private CardView pressure;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //remove status bar
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //set status bar color
        getWindow().setStatusBarColor(ContextCompat.getColor(NavigationBarView.this,R.color.yellow));

        setContentView(R.layout.activity_navigation_bar_view);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_nav, R.string.close_nav);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationview = findViewById(R.id.nav_view);
        //navigation bar item select
        navigationview.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if (item.getItemId() == R.id.home1) {
                    Intent intent = new Intent(getApplicationContext(), NavigationBarView.class);
                    startActivity(intent);

                } else if (item.getItemId() == R.id.share) {
                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.setType("text/plain");
                    String subject = "Unit Converter";
                    String body = "This app is very useful";

                    intent.putExtra(Intent.EXTRA_SUBJECT, subject);
                    intent.putExtra(Intent.EXTRA_TEXT, body);
                    startActivity(Intent.createChooser(intent, "share with"));
                } else if (item.getItemId() == R.id.logout) {

                    logOutMenu();

                    //Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    //startActivity(intent);


                }
                else if(item.getItemId()==R.id.history)
                {
                    Intent intent = new Intent(getApplicationContext(), History_View.class);
                    startActivity(intent);
                }
                else if(item.getItemId()==R.id.calc)
                {
                    Intent intent=new Intent(getApplicationContext(),calculator.class);
                    startActivity(intent);
                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });


        mass = (CardView) findViewById(R.id.MASS);
        temp = (CardView) findViewById(R.id.TEMPERATURE);
        len = (CardView) findViewById(R.id.LENGTH);
        area = (CardView) findViewById(R.id.AREA);
        currency = (CardView) findViewById(R.id.CURRENCY);
        pressure = (CardView) findViewById(R.id.PRESSURE);


        mass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NavigationBarView.this, Mass_Spinner.class);
                startActivity(intent);
            }
        });
        temp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NavigationBarView.this, Temperature_Spinner.class);
                startActivity(intent);
            }
        });
        len.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NavigationBarView.this, Length_Spinner.class);
                startActivity(intent);
            }
        });
        area.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NavigationBarView.this, Area_Spinner.class);
                startActivity(intent);
            }
        });
        currency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NavigationBarView.this, Currency_Spinner.class);
                startActivity(intent);
            }
        });
        pressure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NavigationBarView.this, Pressure_Spinner.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {

            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            AlertDialog.Builder alertDiologue = new AlertDialog.Builder(NavigationBarView.this);
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
    public void logOutMenu(){

        AlertDialog.Builder alertDiologue = new AlertDialog.Builder(NavigationBarView.this);
        alertDiologue.setTitle("Log Out");
        alertDiologue.setMessage("Are you sure you want to logout?");
        alertDiologue.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
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
