package com.example.list_act;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    TextView textview;

    String data1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        textview = findViewById(R.id.textView2);

        getData();
        setData();
    }

    private void getData(){
        if (getIntent().hasExtra("Sch_name")){
            data1 = getIntent().getStringExtra("Sch_name");
        }else{
            Toast.makeText(this,"No data", Toast.LENGTH_LONG).show();
        }
    }

    private void setData(){
        textview.setText(data1);
    }
}

