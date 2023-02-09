package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AppDataList extends RecyclerView.Adapter<AppDataList.MyViewHolder>{

    private Context context;
    private ArrayList<StoringAppData> appdata;

    public AppDataList(Context context, ArrayList<StoringAppData> appdata) {
        this.context = context;
        this.appdata = appdata;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_view,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        StoringAppData storingAppData = appdata.get(position);
        holder.calValue.setText(storingAppData.getResult());

    }

    @Override
    public int getItemCount() {
        return appdata.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView calValue;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            calValue = itemView.findViewById(R.id.listViewId);
        }
    }
}