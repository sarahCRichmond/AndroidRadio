package com.example.pchan.mysqldemo;

import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
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

        CollectData();
    }

    public void CollectData()
    {
        //get dateTime
        Date time = new Date();
        //get device ID
        String android_id = Secure.getString(this.getContentResolver(), Secure.ANDROID_ID);
        //get GPS location
        LocationManager locationManager;
        locationManager = (LocationManager) getSystemService(this.LOCATION_SERVICE);

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
            connected = false; //we are not connected to internet, so store the collected data

        Log.d("mylog","DateTime : "+time.toString());
        Log.d("mylog","Android ID : "+android_id);
        Log.d("mylog","GPS : "+locationManager.toString());
        Log.d("mylog","Internet status : "+connected);
    }


    public void OnLogin(View view) {
        String username = UsernameEt.getText().toString();
        String password = PasswordEt.getText().toString();

        String type = "login";
        BackgroundWorker bgworker = new BackgroundWorker(this);
        bgworker.execute(type, username, password);
    }
}
