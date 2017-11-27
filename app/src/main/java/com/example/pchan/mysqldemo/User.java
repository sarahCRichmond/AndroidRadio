package com.example.pchan.mysqldemo;

import android.content.Context;
import android.widget.EditText;

/**
 * Created by pchan on 11/26/2017.
 */

public class User {
    public int accountID;
    public String userName;
    public String email;
    private String password;
    //public Library library;
    //public AlarmManager alarms;

    public void Login(Context ctx, String username, String password) //DB call to verify user, loads data if verified
    {
        String type = "login";
        BackgroundWorker bgworker = new BackgroundWorker(ctx);
        bgworker.execute(type, username, password);
        //add return type for bgworker.execute
        LoadUserFromDB();
    }

    private void LoadUserFromDB()
    { //With the data returned from DB after successful login, load/assign the user's data
        //accountID = blah
        //userName = blah
        //email = blah
        //password = blah
    }

    public void Logout()
    { //close/unassign all user data and make this a default empty user object

    }

    public void RegisterAccount() //DB call to insert new user data
    {//send name, email, and PW & insert new record into DB

    }



}
