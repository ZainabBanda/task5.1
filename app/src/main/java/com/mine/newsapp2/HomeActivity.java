package com.mine.newsapp2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {
    EditText etUrl;
    Button btnPlay, btnAdd, btnPlaylist;
    AppDatabase db;

    @Override protected void onCreate(Bundle s) {
        super.onCreate(s);
        setContentView(R.layout.activity_home);

        etUrl      = findViewById(R.id.etUrl);
        btnPlay    = findViewById(R.id.btnPlay);
        btnAdd     = findViewById(R.id.btnAdd);
        btnPlaylist= findViewById(R.id.btnPlaylist);
        db         = AppDatabase.getInstance(this);

        btnPlay.setOnClickListener(v -> {
            String url = etUrl.getText().toString().trim();
            if (!url.contains("watch?v=")) {
                Toast.makeText(this, "Enter a valid YouTube link", Toast.LENGTH_SHORT).show();
                return;
            }
            String videoId = url.substring(url.indexOf("v=") + 2);
            startActivity(new Intent(this, VideoPlayerActivity.class)
                .putExtra("videoId", videoId));
        });

        btnAdd.setOnClickListener(v -> {
            String url = etUrl.getText().toString().trim();
            if (!url.contains("watch?v=")) {
                Toast.makeText(this, "Enter a valid YouTube link", Toast.LENGTH_SHORT).show();
                return;
            }
            new Thread(() -> {
                db.playlistDao().insert(new PlaylistItem(url));
                runOnUiThread(() ->
                    Toast.makeText(this, "Added to playlist", Toast.LENGTH_SHORT).show()
                );
            }).start();
        });

        btnPlaylist.setOnClickListener(v ->
            startActivity(new Intent(this, PlaylistActivity.class))
        );
    }
}
