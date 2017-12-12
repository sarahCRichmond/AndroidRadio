package com.example.pchan.mysqldemo;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Criteria;
import android.location.LocationManager;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.provider.Settings.Secure;
import android.widget.TextView;

import java.util.Date;

public class MainActivity extends AppCompatActivity {
    EditText UsernameEt, PasswordEt;
    TextView loginMsgTv;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        UsernameEt = (EditText)findViewById(R.id.etUserName);
        PasswordEt = (EditText)findViewById(R.id.etPassword);
        loginMsgTv = (TextView)findViewById(R.id.loginErrorMsgTv);
        loginMsgTv.setTextColor(Color.RED);
        CollectData();
    }

    public void CollectData()
    {
        //get dateTime
        Date time = new Date();
        //get device ID
        String android_id = Secure.getString(this.getContentResolver(), Secure.ANDROID_ID);
        //get GPS location
        LocationManager locationManager = (LocationManager) getSystemService(this.LOCATION_SERVICE);

        // Create a criteria object to retrieve provider
        Criteria criteria = new Criteria();

        // Get the name of the best provider
        String provider = locationManager.getBestProvider(criteria, true);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(new String[]{Manifest.permission.ACCESS_COARSE_LOCATION,Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.INTERNET}
                        ,10);
            }
            return;
        }

        // Get Current Location
        Location myLocation = locationManager.getLastKnownLocation(provider);

        if (myLocation != null)
        {
            //latitude of location
            double myLatitude = myLocation.getLatitude();

            //longitude og location
            double myLongitude = myLocation.getLongitude();

            String type2 = "InsertUserData";
            DataSender dataSender = new DataSender(this);
            dataSender.execute(type2, String.valueOf(myLongitude), String.valueOf(myLatitude), String.valueOf(android_id), time.toString(), "1" );
        }
  }

    public void OnLogin(View view) throws InterruptedException {
        user = User.getInstance();
        String test1 = UsernameEt.getText().toString();
        String test2 = PasswordEt.getText().toString();
        if (UsernameEt.getText().toString().equals("") || PasswordEt.getText().toString().equals(""))
        {
            loginMsgTv.setText("Make sure to fill in the username and password fields above");
        }
        else //only login if username & password are filled out
        {
            user.Login(this, UsernameEt.getText().toString(), PasswordEt.getText().toString());
            Thread.sleep(1000);
            if (user.accountID != 0){ //only login if credentials validated
                Intent myIntent = new Intent(view.getContext(), MainMenuActivity.class);
                startActivity(myIntent);
                loginMsgTv.setText("");
            }
            else
            {
                loginMsgTv.setText("No matching username and password, retry or make a new account");
            }
        }
    }

    public void OnRegister(View view) {
        UsernameEt.setText("");
        PasswordEt.setText("");
        loginMsgTv.setText("");
        Intent myIntent = new Intent(view.getContext(), RegisterActivity.class);
        startActivity(myIntent);
    }


}


