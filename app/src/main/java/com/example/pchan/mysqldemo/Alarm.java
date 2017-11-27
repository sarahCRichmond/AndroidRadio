package com.example.pchan.mysqldemo;
        
/**
 * Created by Taylor on 11/26/2017.
 */

public class Alarm implements AlarmInt {
    String Date;
    String Time;
    public Alarm(String aDate, String aTime) {
        this.Date=aDate;
        this.Time=aTime;
    }


    @Override
    public void setDate(String aDate) {
        this.Date=aDate;
    }

    public void setTime(String aTime) {
        this.Time=aTime;
    }

    @Override
    public String getDate() {
        return this.Date;
    }

    @Override
    public String getTime() {
        return this.Time;
    }


}
