package com.example.pchan.mysqldemo.Model;

/**
 * Created by ShirtyElm2960 on 11/20/2017.
 */
import android.support.v4.media.MediaMetadataCompat;
import java.util.Iterator;

public interface MusicSource {
    String CUSTOM_METADATA_TRACK_SOURCE = "__SOURCE__";
    Iterator<MediaMetadataCompat> iterator();
}

