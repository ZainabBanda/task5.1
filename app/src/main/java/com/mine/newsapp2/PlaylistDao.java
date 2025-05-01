package com.mine.newsapp2;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;

@Dao
public interface PlaylistDao {
    @Insert
    void insert(PlaylistItem item);

    @Query("SELECT * FROM playlist")
    List<PlaylistItem> getAll();
}
