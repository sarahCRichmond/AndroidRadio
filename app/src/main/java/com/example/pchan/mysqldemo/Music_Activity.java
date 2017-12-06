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
        arrayList.add(new Music("Kalimba", "Mr. Scruff", R.raw.kalimba, "Ninja Tune", "2008", "5:48",R.drawable.kalimba));
        arrayList.add(new Music("Maid With The Flaxen Hair", "Richard S.", R.raw.maidwiththeflaxenhair, "N/A", "2008", "2:49",R.drawable.maidwiththeflaxenhair));
        arrayList.add(new Music("Sleep Away", "Bob Acri", R.raw.sleepaway, "N/A", "2004", "3:20",R.drawable.sleepaway));
        /*arrayList.add(new Music("All I Want For Christmas", "Mariah Carey", R.raw.all, "Sony Music", "1994", "3:55",R.drawable.mariah_carey));
        arrayList.add(new Music("Joy To The World", "Mariah Carey", R.raw.mariahcareyjoytotheworld, "Sony Music", "1994", "5:31",R.drawable.mariah_carey));
        arrayList.add(new Music("Santa Claus is Coming To Town", "Mariah Carey", R.raw.mariahcareysantaclausiscomingtotown, "Sony Music", "1994", "3:22",R.drawable.mariah_carey));
        arrayList.add(new Music("Miss You The Most", "Mariah Carrey", R.raw.mariahcareymissyoumost, "Sony Music", "1994", "4:31",R.drawable.mariah_carey));
        arrayList.add(new Music("Jingle Bells Rock", "Bobby Helms", R.raw.bobbyhelmsjinglebellrock, "Decca", "1957", "2:10",R.drawable.bobby_helms));
        arrayList.add(new Music("Silent Night", "Temptations", R.raw.temptationssilentnight, "Motown Records", "1970", "6:10",R.drawable.the_temptations));*/
        adapter = new CustomMusicAdapter(Music_Activity.this, R.layout.activity_music_, arrayList);
        songList.setAdapter(adapter);

        songList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i == 0) {
                    setContentView(R.layout.activity_music_player);
                    Intent myIntent = new Intent(view.getContext(), music_player.class);
                    myIntent.putExtra(Extra_Message,new String[] {arrayList.get(0).getArtist(),arrayList.get(0).getName(),arrayList.get(0).getYear(),arrayList.get(0).getPublisher()});
                    startActivity(myIntent);
                }
                else if(i == 1) {
                    setContentView(R.layout.activity_music_player);
                    Intent myIntent = new Intent(view.getContext(), music_player.class);
                    myIntent.putExtra(Extra_Message,new String[] {arrayList.get(1).getArtist(),arrayList.get(1).getName(),arrayList.get(1).getYear(),arrayList.get(1).getPublisher()});
                    startActivity(myIntent);
                }
                else if(i == 2) {
                    setContentView(R.layout.activity_music_player);
                    Intent myIntent = new Intent(view.getContext(), music_player.class);
                    myIntent.putExtra(Extra_Message,new String[] {arrayList.get(2).getArtist(),arrayList.get(2).getName(),arrayList.get(2).getYear(),arrayList.get(2).getPublisher()});
                    startActivity(myIntent);
                }
                /*else if(i == 3) {
                    setContentView(R.layout.activity_music_player);
                    Intent myIntent = new Intent(view.getContext(), music_player.class);
                    myIntent.putExtra(Extra_Message,new String[] {arrayList.get(3).getArtist(),arrayList.get(3).getName(),arrayList.get(3).getYear(),arrayList.get(3).getPublisher()});
                    startActivity(myIntent);
                }
                else if(i == 4) {
                    setContentView(R.layout.activity_music_player);
                    Intent myIntent = new Intent(view.getContext(), music_player.class);
                    myIntent.putExtra(Extra_Message,new String[] {arrayList.get(4).getArtist(),arrayList.get(4).getName(),arrayList.get(4).getYear(),arrayList.get(4).getPublisher()});
                    startActivity(myIntent);
                }
                else if(i == 5) {
                    setContentView(R.layout.activity_music_player);
                    Intent myIntent = new Intent(view.getContext(), music_player.class);
                    myIntent.putExtra(Extra_Message,new String[] {arrayList.get(5).getArtist(),arrayList.get(5).getName(),arrayList.get(5).getYear(),arrayList.get(5).getPublisher()});
                    startActivity(myIntent);
                }
                else if(i == 6) {
                    setContentView(R.layout.activity_music_player);
                    Intent myIntent = new Intent(view.getContext(), music_player.class);
                    myIntent.putExtra(Extra_Message,new String[] {arrayList.get(6).getArtist(),arrayList.get(6).getName(),arrayList.get(6).getYear(),arrayList.get(6).getPublisher()});
                    startActivity(myIntent);
                }
                else if(i == 7) {
                    setContentView(R.layout.activity_music_player);
                    Intent myIntent = new Intent(view.getContext(), music_player.class);
                    myIntent.putExtra(Extra_Message,new String[] {arrayList.get(7).getArtist(),arrayList.get(7).getName(),arrayList.get(7).getYear(),arrayList.get(7).getPublisher()});
                    startActivity(myIntent);
                }
                else if(i == 8) {
                    setContentView(R.layout.activity_music_player);
                    Intent myIntent = new Intent(view.getContext(), music_player.class);
                    myIntent.putExtra(Extra_Message,new String[] {arrayList.get(8).getArtist(),arrayList.get(8).getName(),arrayList.get(8).getYear(),arrayList.get(8).getPublisher()});
                    startActivity(myIntent);
                }*/
            }
        });
    }
}
