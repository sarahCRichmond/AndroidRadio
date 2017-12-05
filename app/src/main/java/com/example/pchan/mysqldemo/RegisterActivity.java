package com.example.pchan.mysqldemo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class RegisterActivity extends AppCompatActivity {
    EditText UsernameEt, PasswordEt, EmailET;
    TextView registerErrorMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        UsernameEt = (EditText)findViewById(R.id.etUserName);
        PasswordEt = (EditText)findViewById(R.id.etPW);
        EmailET = (EditText)findViewById(R.id.etEmail);
        registerErrorMsg = (TextView)findViewById(R.id.registerErrorMsg);
        registerErrorMsg.setTextColor(Color.RED);
    }

    public void OnRegisterAcct(View view) {
        if (UsernameEt.getText().toString().equals("") || PasswordEt.getText().toString().equals("")
                || EmailET.getText().toString().equals(""))
        {
            registerErrorMsg.setText("Fill out all fields before trying to register");
        }
        else
        {
            String type = "register";
            registerErrorMsg.setText("");
            BackgroundWorker bgworker = new BackgroundWorker(this);
            bgworker.execute(type, UsernameEt.getText().toString(), PasswordEt.getText().toString(), EmailET.getText().toString());
        }
  }


}
