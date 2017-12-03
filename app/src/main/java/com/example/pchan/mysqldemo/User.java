package com.example.pchan.mysqldemo;

import android.content.Context;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by pchan on 11/26/2017.
 */
//
public class User {
    private static User instance = null;
    public int accountID = 0;
    public String userName;
    public String email;
    private String password;
    //public Library library;
    //public AlarmManager alarms;

    public static User getInstance() {
        if(instance == null) {
            instance = new User();
        }
        return instance;
    }

    protected User() {
        // Exists only to defeat instantiation.
    }

    public void Login(Context ctx, String name, String pw) //DB call to verify user, loads data if verified
    {
        String type = "login";
        BackgroundWorker bgworker = new BackgroundWorker(ctx);
        bgworker.execute(type, name, pw);
        //add return type for bgworker.execute
        userName = name;
        password = pw;
        LoadUserFromDB(ctx);
    }

    private void LoadUserFromDB(Context ctx)
    { //With the data returned from DB after successful login, load/assign the user's data
        BackgroundWorker backgroundWorker = new BackgroundWorker(ctx);
        backgroundWorker.execute("getUserData", userName,password);
        //accountID = blah
        //email = blah


    }

    public void Logout()
    { //close/unassign all user data and make this a default empty user object
        userName = null;
        password = null;
        email = null;
        accountID = 0;

        //take user to "login" activity/screen
    }

    public void RegisterAccount() //DB call to insert new user data
    {//send name, email, and PW & insert new record into DB

    }



}
