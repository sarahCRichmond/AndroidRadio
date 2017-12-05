package com.example.pchan.mysqldemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Music_Activity extends AppCompatActivity {
    public static final String Extra_Message = "";
    private ArrayList<Music> arrayList;
    private CustomMusicAdapter adapter;
    private ListView songList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_);
        songList = (ListView) findViewById(R.id.songList);
        arrayList = new ArrayList<>();
        arrayList.add(new Music("Kalimba", "Mr. Scruff", R.raw.kalimba, "Ninja Tune", 2008, "5:48",R.drawable.kalimba));
        arrayList.add(new Music("Maid With The Flaxen Hair", "Richard S.", R.raw.maidwiththeflaxenhair, "N/A", 2008, "2:49",R.drawable.maidwiththeflaxenhair));
        arrayList.add(new Music("Sleep Away", "Bob Acri", R.raw.sleepaway, "N/A", 2004, "3:20",R.drawable.sleepaway));
        adapter = new CustomMusicAdapter(Music_Activity.this, R.layout.activity_music_, arrayList);
        songList.setAdapter(adapter);

        songList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i == 0) {
                    setContentView(R.layout.activity_music_player);
                    Intent myIntent = new Intent(view.getContext(), music_player.class);
                    myIntent.putExtra(Extra_Message,new String[] {arrayList.get(0).getArtist(),arrayList.get(0).getName()});
                    startActivity(myIntent);
                }
                else if(i == 1) {
                    setContentView(R.layout.activity_music_player);
                    Intent myIntent = new Intent(view.getContext(), music_player.class);
                    myIntent.putExtra(Extra_Message,new String[] {arrayList.get(1).getArtist(),arrayList.get(1).getName()});
                    startActivity(myIntent);
                }
                else if(i == 2) {
                    setContentView(R.layout.activity_music_player);
                    Intent myIntent = new Intent(view.getContext(), music_player.class);
                    myIntent.putExtra(Extra_Message,new String[] {arrayList.get(2).getArtist(),arrayList.get(2).getName()});
                    startActivity(myIntent);
                }
            }
        });
    }
}
