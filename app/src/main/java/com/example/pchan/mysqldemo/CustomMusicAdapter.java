package com.example.pchan.mysqldemo;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class CustomMusicAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private ArrayList<Music> arrayList;


    public CustomMusicAdapter(Context context, int layout, ArrayList<Music> arrayList) {
        this.context = context;
        this.layout = layout;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    private class ViewHolder {
        TextView txtName, txtSinger,txtLength;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;
        if(convertView == null){
            viewHolder = new ViewHolder();
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = layoutInflater.inflate(layout, null);
            viewHolder.txtName = (TextView) convertView.findViewById(R.id.txtName);
            viewHolder.txtSinger = (TextView) convertView.findViewById(R.id.txtSinger);
            viewHolder.txtLength = (TextView) convertView.findViewById(R.id.txtLength);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        final Music music = arrayList.get(position);
        viewHolder.txtName.setText(music.getName());
        viewHolder.txtSinger.setText(music.getArtist());
        viewHolder.txtLength.setText(music.getLength());
        return convertView;
    }
}
