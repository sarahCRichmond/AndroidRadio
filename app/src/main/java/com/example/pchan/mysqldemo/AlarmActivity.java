package com.example.pchan.mysqldemo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.io.File;
import java.text.SimpleDateFormat;
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
        List<AlarmInt> alrList = new ArrayList<AlarmInt>();
        Context context = this;
        File alrmDat = new File(context.getFilesDir(), "alrDat.txt");
        aFileIO alrmList = new aFileIO(alrmDat);
        alrList = alrmList.getAlrmList();

        for(AlarmInt aInt : alrList){
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> ADDING TO A LIST <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
            Alist.add(aInt.getDate() + "  " + aInt.getTime());
        }



        adapter = new ArrayAdapter(AlarmActivity.this, android.R.layout.simple_list_item_1, Alist);
        AlarmList.setAdapter(adapter);


    }

    public void onDeleteAlarms(View view){
        Context context = this;
        File alrmDat = new File(context.getFilesDir(), "alrDat.txt");
        aFileIO alrmList = new aFileIO(alrmDat);
        alrmList.deleteAlrmFile(alrmDat);
        Intent myIntent = new Intent(view.getContext(), AlarmActivity.class);
        startActivity(myIntent);
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

        Context context = this;
        File alrmDat = new File(context.getFilesDir(), "alrDat.txt");
        aFileIO alarmFileList = new aFileIO(alarmList, alrmDat);

        for(AlarmInt aInt : alarmList){
            Alist.add(aInt.getDate() + "  " + aInt.getTime());
        }
    }
    

}
