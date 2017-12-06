package com.example.pchan.mysqldemo;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class music_player extends AppCompatActivity {
    private TextView mTextMessage;
    private TextView mTextMessage2;
    private ImageView art;
    MediaPlayer mediaPlayer;
    private Boolean ratingdown = false;
    private Boolean ratingup = false;

    SeekBar seekbar;
    AudioManager audioManager;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId()) {
                case R.id.thumbs_down:
                    if(getRatingup()==false&&getRatingdown()==false){
                        item.setIcon(R.drawable.thumbs_down2);
                        setRatingdown(true);}
                    else{
                        item.setIcon(R.drawable.thumbs_down);
                        setRatingdown(false);}
                case R.id.prev:
                    AudioManager audioManager2 = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
                    audioManager2.setStreamVolume(AudioManager.STREAM_MUSIC, 0, 0);
                    seekbar.setProgress(0);
                    return true;
                case R.id.pause:
                    if(mediaPlayer.isPlaying()) {
                        mediaPlayer.pause();
                        item.setIcon(R.drawable.ic_play);
                        item.setTitle("Play");

                    } else {
                        mediaPlayer.start();
                        item.setIcon(R.drawable.ic_pause);
                        item.setTitle("Pause");

                    }
                    return true;
                case R.id.next:
                    AudioManager audioManager3 = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
                    audioManager3.setStreamVolume(AudioManager.STREAM_MUSIC,8,8);
                    seekbar.setProgress(8);
                    return true;
                case R.id.thumbs_up:
                    if(getRatingup()==false&&getRatingdown()==false) {
                        item.setIcon(R.drawable.thumbs_up2);
                        setRatingup(true);
                    }
                    else {
                        item.setIcon(R.drawable.thumbs_up);
                        setRatingup(false);
                    }
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_player);
        Resources res = getApplicationContext().getResources();
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
        mTextMessage = (TextView) findViewById(R.id.message);
        mTextMessage2 = (TextView) findViewById(R.id.message2);
        art = (ImageView) findViewById(R.id.imageView);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        Intent intent = getIntent();
        String[] name = intent.getStringArrayExtra(Music_Activity.Extra_Message);
        mTextMessage.setText(name[0]);
        mTextMessage2.setText(name[1]);
        String songName= name[1];
        songName = songName.toLowerCase();
        songName=songName.replaceAll("\\s","");
        int song = res.getIdentifier(songName,"raw",getPackageName());
        int artimage = res.getIdentifier(songName,"drawable",getPackageName());
        mediaPlayer = MediaPlayer.create(getApplicationContext(), song);
        mediaPlayer.setVolume(50,50);
        mediaPlayer.start();
        art.setImageResource(artimage);
        //volume controls
        seekbar = (SeekBar)findViewById(R.id.seekBar);
        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        seekbar.setMax(audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC));
        seekbar.setProgress(8);
        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, i, 0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
    @Override
    public void onBackPressed(){
        mediaPlayer.stop();
        this.startActivity(new Intent(this,Music_Activity.class));
    }
    public void setRatingdown(Boolean ratingdown) {
        this.ratingdown = ratingdown;
    }
    public Boolean getRatingdown(){
        return ratingdown;
    }
    public void setRatingup(Boolean ratingup) {
        this.ratingup = ratingup;
    }
    public Boolean getRatingup(){
        return ratingup;
    }
}
