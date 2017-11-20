package com.example.pchan.mysqldemo.PlayBack;

import com.example.pchan.mysqldemo.Utilities.LogError;

/**
 * Created by ShirtyElm2960 on 11/20/2017.
 */

public class PlayBackMain implements PlayBack.Callback {
    private PlayBack pb;
    private static final String TAG = LogError.makeLogTag(PlayBackMain.class);
    private static final String CUSTOM_ACTION_THUMBS_UP = "com.example.android.uamp.THUMBS_UP";
    public PlayBackMain(PlayBack playBack)
    {
        pb = playBack;
        pb.setCallback(this);
    }
    public PlayBack getPlayBack(){
        return pb;
    }
    @Override
    public void onCompletion() {

    }

    @Override
    public void onPlaybackStatusChanged(int state) {

    }

    @Override
    public void onError(String error) {

    }

    @Override
    public void setCurrentMediaId(String mediaId) {

    }
}
