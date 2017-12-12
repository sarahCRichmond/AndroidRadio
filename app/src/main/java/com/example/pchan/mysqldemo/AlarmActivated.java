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
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class AlarmActivated extends AppCompatActivity {
    public static final String Extra_Message = "";
    private ArrayList<Music> arrayList;
    private CustomMusicAdapter adapter;
    private ListView songList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_alarm_activated);

        songList = (ListView) findViewById(R.id.songList);
        arrayList = new ArrayList<>();
        arrayList.add(new Music("Kalimba", "Mr. Scruff", R.raw.kalimba, "Ninja Tune", "2008", "5:48",R.drawable.kalimba));
        setContentView(R.layout.activity_music_player);
        Intent myIntent = new Intent(this, music_player.class);
        myIntent.putExtra(Extra_Message,new String[] {arrayList.get(0).getArtist(),arrayList.get(0).getName()});
        startActivity(myIntent);
    }

    public void OnBack (View view) {
        onBackPressed();
    }

    public void onSnooze (View view){
        Date today = new Date();
        Calendar calAlarm = Calendar.getInstance();

        calAlarm.setTime(today);
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(this, AlarmActivated.class);

        Random rand = new Random();
        int n = rand.nextInt(100)+1;
        PendingIntent futureIntent = PendingIntent.getActivity(this, n, intent, 0);
        alarmManager.set(AlarmManager.RTC_WAKEUP, calAlarm.getTimeInMillis() + 300000, futureIntent);

        //TEMP SEND BACK TO MAIN ALARM SCREEN
        Intent myIntent = new Intent(view.getContext(), AlarmActivity.class);
        startActivity(myIntent);
    }

}
