package com.example.pchan.mysqldemo;

import android.content.Intent;

/**
 * Created by ShirtyElm2960 on 11/20/2017.
 */

public class MusicService {
    public void onCreate() {}
    public int onStartCommand(){
        return 0;
    }
    public void onTaskRemoved(Intent rootIntent) {}
    public void onDestroy() {}
    public void onPlaybackStart() {}
    public void onPlaybackStop() {}
    public void onNotificationRequired() {}
}
