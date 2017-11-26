package com.example.pchan.mysqldemo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Date;

public class SetAlarm extends AppCompatActivity {
    TextView curTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_alarm);
        curTime = (TextView)findViewById(R.id.curTime);
        String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());
        curTime.setText(currentDateTimeString);
    }

    public void OnBack(View view) {
        onBackPressed();
    }

    public void onSet(View view) {
        onBackPressed();
    }

}
