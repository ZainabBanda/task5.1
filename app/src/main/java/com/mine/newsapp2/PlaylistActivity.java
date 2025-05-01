package com.mine.newsapp2;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class PlaylistActivity extends AppCompatActivity {
    private RecyclerView rv;
    private PlaylistAdapter adapter;
    private AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist);

        // 1) Setup RecyclerView
        rv = findViewById(R.id.rvPlaylist);
        rv.setLayoutManager(new LinearLayoutManager(this));

        // 2) Create adapter with empty list & attach it
        adapter = new PlaylistAdapter(new ArrayList<>());
        rv.setAdapter(adapter);

        // 3) Obtain database instance
        db = AppDatabase.getInstance(this);

        // 4) Load playlist off the main thread
        new Thread(() -> {
            List<PlaylistItem> list = db.playlistDao().getAll();
            runOnUiThread(() -> adapter.setItems(list));
        }).start();
    }
}
