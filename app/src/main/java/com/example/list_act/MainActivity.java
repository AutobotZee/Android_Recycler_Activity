package com.example.list_act;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public ArrayList<Schedule_Item> sch_list_list = new ArrayList<>();
    public ArrayList<Record> record_list = new ArrayList<>();
    public int selected_pos;

    RecyclerView Sch1_view;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState != null) {
            // Then the application is being reloaded
            sch_list_list  = savedInstanceState.getParcelableArrayList("Schedules");
        }
        Intent intent = getIntent();
        if(intent != null)
        {
            if(intent.hasExtra("position") & intent.hasExtra("Schedule"))
            {
                selected_pos = intent.getIntExtra("position", selected_pos);
                Schedule_Item sch_back = intent.getParcelableExtra("Schedule");
                sch_list_list.clear();
                Bundle data = getIntent().getExtras();
                sch_list_list = data.getParcelableArrayList("All_Schedule");
            }
        }

        setTitle("Schedule List");

        setContentView(R.layout.activity_main);
        Sch1_view = findViewById(R.id.recycle1);
        button = findViewById(R.id.create_sch);

        record_list.add(new Record("00","654","0240"));
        record_list.add(new Record("00","987","0840"));

        final MyAdapter myAdapter = new MyAdapter(this, sch_list_list);
        Sch1_view.setAdapter(myAdapter);
        Sch1_view.setLayoutManager(new LinearLayoutManager(this));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sch_list_list.add(new Schedule_Item(1, "Sch_name",record_list ));
                myAdapter.notifyDataSetChanged();

            }
        });


    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putParcelableArrayList("Schedules", sch_list_list);
        finish();

        super.onSaveInstanceState(outState);

    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        sch_list_list  = savedInstanceState.getParcelableArrayList("Schedules");
        super.onRestoreInstanceState(savedInstanceState);
        ;

    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == -1) {
                String result = data.getStringExtra("result");
            }
            if (resultCode == 0) {
                //Write your code if there's no result
            }
        }
    }


}
