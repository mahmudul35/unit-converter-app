/*package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
//import android.support.v7.widget.CardView;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class Menupage extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
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
        setContentView(R.layout.activity_menupage);
        toolbar.findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout=findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open_nav,R.string.close_nav);
        drawerLayout.addDrawerListener(toggle);

        navigationview=findViewById(R.id.nav_view);
        navigationview.setNavigationItemSelectedListener(this);

        mass =(CardView) findViewById(R.id.MASS);
        temp=(CardView) findViewById(R.id.TEMPERATURE);
        len=(CardView)findViewById(R.id.LENGTH);
        area=(CardView)findViewById(R.id.AREA);
        currency=(CardView)findViewById(R.id.CURRENCY);
        pressure=(CardView)findViewById(R.id.PRESSURE);


        mass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Menupage.this,Mass_Spinner.class);
                startActivity(intent);
            }
        });
        temp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Menupage.this,Temperature_Spinner.class);
                startActivity(intent);
            }
        });
        len.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Menupage.this,Length_Spinner.class);
                startActivity(intent);
            }
        });
        area.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Menupage.this,Area_Spinner.class);
                startActivity(intent);
            }
        });
        currency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Menupage.this,Currency_Spinner.class);
                startActivity(intent);
            }
        });
        pressure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Menupage.this,Pressure_Spinner.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){

            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else{
            AlertDialog.Builder alertDiologue = new AlertDialog.Builder(Menupage.this);
            alertDiologue.setTitle("Exit App");
            alertDiologue.setMessage("Do you want to close app?");
            alertDiologue.setPositiveButton("Yes" ,new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    finishAffinity();
                }
            });
            alertDiologue.setNegativeButton("No" ,new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });
            alertDiologue.show();
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.home1){
            Toast.makeText(this, "Clicked Home", Toast.LENGTH_SHORT).show();

        }
        else if(item.getItemId()==R.id.share)
        {
            Toast.makeText(this, "Clicked Share", Toast.LENGTH_SHORT).show();
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}*/