package com.example.pchan.mysqldemo;

import android.content.Intent;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class music_player extends AppCompatActivity {
    private TextView mTextMessage;
    private TextView mTextMessage2;
    private ImageView art;
    MediaPlayer mediaPlayer;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.prev:
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

                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_player);
        Resources res = getApplicationContext().getResources();

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
        mediaPlayer.setVolume(100,100);
        mediaPlayer.start();
        art.setImageResource(artimage);
    }
}
