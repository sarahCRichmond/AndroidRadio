package com.example.pchan.mysqldemo.PlayBack;

/**
 * Created by ShirtyElm2960 on 11/20/2017.
 */
import com.example.pchan.mysqldemo.MusicService;
import static android.support.v4.media.session.MediaSessionCompat.QueueItem;

public interface PlayBack {
    void start();
    void stop(boolean notifyListeners);
    void setState(int state);
    void pause();
    void seekTo(long position);
    void setCurrentMediaId(String mediaId);
    int getState();
    boolean isConnected();
    boolean isPlaying();
    long getCurrentStreamPosition();
    void updateLastKnownStreamPosition();
    void play(QueueItem item);
    String getCurrentMediaId();
    interface Callback {
        void onCompletion();
        void onPlaybackStatusChanged(int state);
        void onError(String error);
        void setCurrentMediaId(String mediaId);
    }
    void setCallback(Callback callback);
}
