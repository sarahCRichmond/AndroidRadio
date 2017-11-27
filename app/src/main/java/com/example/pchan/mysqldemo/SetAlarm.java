package com.example.pchan.mysqldemo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

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
        DatePicker datePicker = (DatePicker) findViewById(R.id.datePicker);
        day = datePicker.getDayOfMonth();
        month = datePicker.getMonth();
        year = datePicker.getYear();
        TimePicker timePicker = (TimePicker) findViewById(R.id.timePicker);
        hour = timePicker.getCurrentHour();
        minute = timePicker.getCurrentMinute();
        //return(year + "-" + month + "-" + day + "   " + hour + ":" + minute);
    }

}
