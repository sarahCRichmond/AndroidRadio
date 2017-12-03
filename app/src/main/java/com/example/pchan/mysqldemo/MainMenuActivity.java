package com.example.pchan.mysqldemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);
    }

    public void OnAlarms(View view) {
        Intent myIntent = new Intent(view.getContext(), AlarmActivity.class);
        startActivity(myIntent);
    }

    public void OnLogout(View view) {
        User.getInstance().Logout();
        Intent myIntent = new Intent(view.getContext(), MainActivity.class);
        startActivity(myIntent);
    }

//    public void OnPlayMusic(View view) {
//        Intent myIntent = new Intent(view.getContext(), MusicPlayer.class);
//        startActivity(myIntent);
//    }
}
