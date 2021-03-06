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
        findViewById(R.id.textView4).setSelected(true);
    }

    public void OnAlarms(View view) {
        Intent myIntent = new Intent(view.getContext(), AlarmActivity.class);
        startActivity(myIntent);
    }

    public void OnMusic(View view){
        Intent myIntent = new Intent(view.getContext(), Music_Activity.class);
        startActivity(myIntent);
    }

    public void OnLogout(View view) {
        User.getInstance().Logout();
        Intent myIntent = new Intent(view.getContext(), MainActivity.class);
        startActivity(myIntent);
    }

    public void onBackPressed() {
        //because we want the back button not work in the main menu, user should
        //press logout to go back to the login screen
    }

}
