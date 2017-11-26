package com.example.pchan.mysqldemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AlarmActivity extends AppCompatActivity {
    TextView curTime;
    ListView AlarmList;
    List Alist = new ArrayList();
    ArrayAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);
        curTime = (TextView)findViewById(R.id.curTime);
        String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());
        System.out.println(">>>>>>>>>>>>>>>>>>" + currentDateTimeString + "<<<<<<<<<<<<<<<<<<<");

        curTime.setText(currentDateTimeString);

        AlarmList = (ListView)findViewById(R.id.AlarmList);
        Alist.add("Test");
        Alist.add("Test2");

        adapter = new ArrayAdapter(AlarmActivity.this, android.R.layout.simple_list_item_1, Alist);
        AlarmList.setAdapter(adapter);
    }

    public void OnNewAlarm(View view) {
        Intent myIntent = new Intent(view.getContext(), SetAlarm.class);
        startActivity(myIntent);
    }

    public void addAlarm(String alarmDate, String alarmTime){
        Alist.add(alarmDate + alarmTime);
    }

}
