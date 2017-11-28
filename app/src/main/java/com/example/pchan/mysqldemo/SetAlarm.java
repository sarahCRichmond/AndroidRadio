package com.example.pchan.mysqldemo;

import android.app.AlarmManager;
import android.app.PendingIntent;
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
import java.util.Random;

import java.io.File;
import java.text.DateFormat;
import java.util.Calendar;
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


        Date today = new Date();
        Calendar calAlarm = Calendar.getInstance();
        Calendar calNow = Calendar.getInstance();

        calNow.setTime(today);
        calAlarm.setTime(today);
        calAlarm.set(Calendar.YEAR, year);
        calAlarm.set(Calendar.MONTH, month);
        calAlarm.set(Calendar.DAY_OF_MONTH, day);
        calAlarm.set(Calendar.HOUR_OF_DAY, hour);
        calAlarm.set(Calendar.MINUTE, minute);
        calAlarm.set(Calendar.SECOND, 1);


        if(calAlarm.after(calNow)){
            Alarm alarm = new Alarm(year+"-"+month+"-"+day, hour + ":" + minute);
            Context context = this;
            File alrmDat = new File(context.getFilesDir(), "alrDat.txt");
            aFileIO alrmList = new aFileIO(alarm, alrmDat);

            //set alarm
            AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
            Intent intent = new Intent(this, AlarmActivated.class);

            Random rand = new Random();
            int n = rand.nextInt(100)+1;
            PendingIntent futureIntent = PendingIntent.getActivity(this, n, intent, 0);
            alarmManager.set(AlarmManager.RTC_WAKEUP, calAlarm.getTimeInMillis(), futureIntent);


            System.out.println(">>>>>>>>>>>>TRIED TO SET N ALARM HAHA<<<<<<<<<<<<<<<<<<");
        }



        Intent myIntent = new Intent(view.getContext(), AlarmActivity.class);
        startActivity(myIntent);
    }


}
