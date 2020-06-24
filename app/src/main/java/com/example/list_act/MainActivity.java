package com.example.list_act;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public ArrayList<String> sch_list= new ArrayList<>();
    RecyclerView Sch1_view;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Sch1_view = findViewById(R.id.recycle1);
        button = findViewById(R.id.button);

        final MyAdapter myAdapter = new MyAdapter(this, sch_list);
        Sch1_view.setAdapter(myAdapter);
        Sch1_view.setLayoutManager(new LinearLayoutManager(this));

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sch_list.add("Today");
                sch_list.add("is");
                sch_list.add("a");
                sch_list.add("Lovely");
                sch_list.add("day");
                myAdapter.notifyDataSetChanged();

            }
        });
    }


}
