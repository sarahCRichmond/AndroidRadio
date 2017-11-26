package com.example.pchan.mysqldemo;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
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
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    EditText UsernameEt, PasswordEt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        UsernameEt = (EditText)findViewById(R.id.etUserName);
        PasswordEt = (EditText)findViewById(R.id.etPassword);

        //CollectData();
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

        //latitude of location
        double myLatitude = myLocation.getLatitude();

        //longitude og location
        double myLongitude = myLocation.getLongitude();

        //test internet connection
        boolean connected = false;
        ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(this.CONNECTIVITY_SERVICE);
        if(connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
            //we are connected to a network, so send the collected data to the DB
            //also send any old data stored locally
            connected = true;
        }
        else
        {
            connected = false; //we are not connected to internet, so store the collected data
        }

        Log.d("mylog","DateTime : "+time.toString());
        Log.d("mylog","Android ID : "+android_id);
        Log.d("mylog","GPS : " +myLatitude + myLongitude);
        Log.d("mylog","Internet status : "+connected);

        String type2 = "InsertUserData";
        DataSender dataSender = new DataSender(this);
        dataSender.execute(type2, String.valueOf(myLongitude), String.valueOf(myLatitude), String.valueOf(android_id), time.toString(), "1" );
    }


    public void OnLogin(View view) {
        String username = UsernameEt.getText().toString();
        String password = PasswordEt.getText().toString();

        String type = "login";
        BackgroundWorker bgworker = new BackgroundWorker(this);
        bgworker.execute(type, username, password);

    }

    public void OnAlarm(View view) {
        Intent myIntent = new Intent(view.getContext(), AlarmActivity.class);
        startActivity(myIntent);
    }


}


