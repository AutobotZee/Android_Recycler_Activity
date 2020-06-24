package com.example.list_act;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{

    ArrayList<String> data1 ;
    Context context;
     public MyAdapter(Context ct, ArrayList<String> s1)
     {
         context = ct;
         data1 = s1;
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
         holder.myText1.setText(data1.get(position));

         holder.mainlayout.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent = new Intent(context, SecondActivity.class);
                 intent.putExtra("Sch_name", data1.get(position));
                 context.startActivity(intent);
             }
         });
    }

    @Override
    public int getItemCount() {
        return data1.size();
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
