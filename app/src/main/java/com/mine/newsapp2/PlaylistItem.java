package com.mine.newsapp2;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.annotation.NonNull;

@Entity(tableName = "playlist")
public class PlaylistItem {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @NonNull
    private String url;

    public PlaylistItem(@NonNull String url) {
        this.url = url;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    @NonNull
    public String getUrl() { return url; }
    public void setUrl(@NonNull String url) { this.url = url; }
}
