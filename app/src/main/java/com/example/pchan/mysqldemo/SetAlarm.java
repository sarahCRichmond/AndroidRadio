package com.example.pchan.mysqldemo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.io.File;
import java.text.DateFormat;
import java.util.Date;

public class SetAlarm extends AppCompatActivity {
    TextView curTime;
    int day, month, year, hour, minute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_alarm);
        curTime = (TextView)findViewById(R.id.curTime);
        String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());
        curTime.setText(currentDateTimeString);


    }

    public void OnBack (View view) {
        onBackPressed();
    }

    public void onSet(View view) {
        System.out.println(">>>>>>>>>>>>>>>>>>>> ONSET YO <<<<<<<<<<<<<<<<<<<<<<<<<<<");
        DatePicker datePicker = (DatePicker) findViewById(R.id.datePicker);
        day = datePicker.getDayOfMonth();
        month = datePicker.getMonth();
        year = datePicker.getYear();
        TimePicker timePicker = (TimePicker) findViewById(R.id.timePicker);
        hour = timePicker.getCurrentHour();
        minute = timePicker.getCurrentMinute();
        System.out.println(">>>>>>>>>>>>>" + year + "-" + month + "-" + day + "." + hour + ":" + minute + "<<<<<<<<<<<<<");
        Alarm alarm = new Alarm(year+"-"+month+"-"+day, hour + ":" + minute);
        Context context = this;
        File alrmDat = new File(context.getFilesDir(), "alrDat.txt");
        aFileIO alrmList = new aFileIO(alarm, alrmDat);
        Intent myIntent = new Intent(view.getContext(), AlarmActivity.class);
        startActivity(myIntent);
    }

}
