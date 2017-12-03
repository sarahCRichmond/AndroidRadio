package com.example.pchan.mysqldemo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {
    EditText UsernameEt, PasswordEt, EmailET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        UsernameEt = (EditText)findViewById(R.id.etUserName);
        PasswordEt = (EditText)findViewById(R.id.etPW);
        EmailET = (EditText)findViewById(R.id.etEmail);
    }

    public void OnRegisterAcct(View view) {
        String type = "register";
        BackgroundWorker bgworker = new BackgroundWorker(this);
        bgworker.execute(type, UsernameEt.getText().toString(), PasswordEt.getText().toString(), EmailET.getText().toString());
    }


}
