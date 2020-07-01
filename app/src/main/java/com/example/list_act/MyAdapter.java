package com.example.list_act;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{

    public ArrayList<Schedule_Item> data ;
    public  Context context;
     public MyAdapter(Context ct, ArrayList<Schedule_Item> s1)
     {
         context = ct;
         data = s1;
     }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
         holder.myText1.setText(data.get(position).Sch_name);

         holder.mainlayout.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent = new Intent(context, SecondActivity.class);
                 intent.putExtra("ScheduleItem", data.get(position));
                 intent.putExtra("position", position);
                 intent.putExtra("All_Schedules",data);
                 context.startActivity(intent);
             }
         });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

         TextView myText1;
         ConstraintLayout mainlayout;
        public MyViewHolder(@NonNull View itemView)
        {
            super(itemView);
            myText1 = itemView.findViewById(R.id.Schedule_name);
            mainlayout = itemView.findViewById(R.id.mainLayout);
        }
    }

}

