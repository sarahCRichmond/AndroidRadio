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

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AlarmActivity extends AppCompatActivity{
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

        Date curDate = new Date();
        SimpleDateFormat datF = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat datT = new SimpleDateFormat("hh:mm:ss");
        String cTime = datT.format(curDate);
        String cDate = datF.format(curDate);

        AlarmList = (ListView)findViewById(R.id.AlarmList);
        Alist.add(cTime + "  " + cDate);
        //Alist.add(cDate);
        Alist.add("Test");
        Alist.add("Test2");

        testAlarm();

        adapter = new ArrayAdapter(AlarmActivity.this, android.R.layout.simple_list_item_1, Alist);
        AlarmList.setAdapter(adapter);
    }

    public void OnNewAlarm(View view) {
        Intent myIntent = new Intent(view.getContext(), SetAlarm.class);
        startActivity(myIntent);
    }

    public void testAlarm(){
        Alarm alarm1 = new Alarm("2011-04-05", "11:55:22");
        Alarm alarm2 = new Alarm("2011-05-05", "11:55:22");
        Alarm alarm3 = new Alarm("2011-06-05", "11:55:22");
        Alarm alarm4 = new Alarm("2011-07-05", "11:55:22");
        Alarm alarm5 = new Alarm("2011-08-05", "11:55:22");

        List<AlarmInt> alarmList = new ArrayList<AlarmInt>();
        alarmList.add(alarm1);
        alarmList.add(alarm2);
        alarmList.add(alarm3);
        alarmList.add(alarm4);
        alarmList.add(alarm5);

        for(AlarmInt aInt : alarmList){
            Alist.add(aInt.getDate() + "  " + aInt.getTime());
        }
    }

    public void addAlarm(String alarmDate, String alarmTime){
        Alist.add(alarmDate + alarmTime);
    }

}
