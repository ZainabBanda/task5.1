package com.mine.newsapp2;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import android.content.Context;

@Database(entities = {PlaylistItem.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {   public abstract PlaylistDao playlistDao();

    private static volatile AppDatabase instance;
    public static AppDatabase getInstance(Context ctx) {
        if (instance == null) {
            instance = Room.databaseBuilder(
                ctx.getApplicationContext(),
                AppDatabase.class,
                "app_db"
            ).build();
        }
        return instance;
    }
}
