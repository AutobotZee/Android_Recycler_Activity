package com.example.list_act;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {
    private RecyclerView Record_recycler;
    private RecyclerView.Adapter mRecAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    Schedule_Item data1 = null;
    ArrayList<Schedule_Item> All_schedule = new ArrayList<>();
    public int provided_pos;

    // TODO Add new layout elements and display the data
    // TODO write adaptor class for 2nd layout
    EditText textview;
    EditText sec_cmd;
    EditText sec_Address;
    EditText sec_StartDT;
    TextView sec_ID;
    Button rename;
    Button AddRec;
    Button SaveReturn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.schedule_config);
        data1 = getData();

        textview = (EditText) findViewById(R.id.Sch_name);
        rename = (Button) findViewById(R.id.rename);
        AddRec = (Button) findViewById(R.id.AddRecord);
        SaveReturn =( Button) findViewById(R.id.SaveReturn);

        Record_recycler = findViewById(R.id.Sch_record_view);
        new ItemTouchHelper(rec_touch).attachToRecyclerView(Record_recycler);

        mLayoutManager = new LinearLayoutManager(this);
        mRecAdapter = new RecordAdapter(data1.record_list);

        Record_recycler.setLayoutManager(mLayoutManager);
        Record_recycler.setAdapter(mRecAdapter);

        sec_ID = findViewById(R.id.sec_ID);
        sec_cmd = findViewById(R.id.sec_CMD);
        sec_Address = findViewById(R.id.sec_Address);
        sec_StartDT = findViewById(R.id.sec_StartDT);

        data1.record_list.add(new Record("12","123","1230"));

        data1.record_list.add(new Record("05","456","1920"));
        setData(data1);

        rename.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data1.Sch_name = textview.getText().toString();
                Toast.makeText(getApplicationContext(),"DATA written", Toast.LENGTH_SHORT).show();
            }
        });

        AddRec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Record rec = new Record(sec_cmd.getText().toString(), sec_Address.getText().toString(), sec_StartDT.getText().toString());
                data1.record_list.add(rec);
                // just accessing sorter through a record object
                Record.sorter( data1.record_list);
                mRecAdapter.notifyDataSetChanged();
            }
        });
        SaveReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backIntent = new Intent(SecondActivity.this, MainActivity.class);
                backIntent.putExtra("Schedule",data1);
                backIntent.putExtra("position", provided_pos);
                All_schedule.remove(provided_pos);
                All_schedule.add(provided_pos, data1);
                backIntent.putExtra("All_Schedule", All_schedule);
                startActivity(backIntent);
                finish();
            }
        });

    }

    private Schedule_Item getData(){
        Schedule_Item data1 = null;
        if (getIntent().hasExtra("ScheduleItem")){
            data1 = getIntent().getParcelableExtra("ScheduleItem");
            provided_pos = getIntent().getIntExtra("position", provided_pos);
            All_schedule = getIntent().getParcelableArrayListExtra("All_Schedules");
            }else{
            Toast.makeText(this,"No data", Toast.LENGTH_LONG).show();
        }
        return data1;

    }

    private void setData(Schedule_Item sch){
        // TODO Write more
        textview.setText(sch.getSch_name());
        mRecAdapter.notifyDataSetChanged();
    }
    ItemTouchHelper.SimpleCallback rec_touch = new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.RIGHT) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
            data1.record_list.remove(viewHolder.getAdapterPosition());
            mRecAdapter.notifyDataSetChanged();
        }
    };


}

