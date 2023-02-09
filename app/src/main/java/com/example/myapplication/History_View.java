package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class History_View extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    private ImageView backArrow;
    RecyclerView historyView;
    ArrayList<StoringAppData> appdataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_view);
        getWindow().setStatusBarColor(ContextCompat.getColor(History_View.this, R.color.yellow));

        historyView = findViewById(R.id.recyclerViewId);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference().child("appData");

        appdataList = new ArrayList<>();
        historyView.setLayoutManager(new LinearLayoutManager(this));
        AppDataList adapter = new AppDataList(History_View.this,appdataList);
        historyView.setAdapter(adapter);


        backArrow=findViewById(R.id.arrowBackId);
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),NavigationBarView.class);
                startActivity(intent);
            }
        });




        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {


                for( DataSnapshot dataSnapshot: snapshot.getChildren()){

                    StoringAppData storingAppData = dataSnapshot.getValue(StoringAppData.class);
                    appdataList.add(storingAppData);

                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError error) {

            }
        });
    }
}