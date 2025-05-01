package com.mine.newsapp2;

import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.appcompat.app.AppCompatActivity;

public class VideoPlayerActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);

        WebView web = findViewById(R.id.webView);

        // 1) Basic WebView settings
        WebSettings ws = web.getSettings();
        ws.setJavaScriptEnabled(true);
        ws.setDomStorageEnabled(true);
        ws.setMediaPlaybackRequiresUserGesture(false);

        // 2) Attach a WebChromeClient to enable the HTML5 pipeline
        web.setWebChromeClient(new WebChromeClient());

        // 3) Build the embed HTML with autoplay & audio permissions
        String id = getIntent().getStringExtra("videoId");
        String html =
            "<html><body style=\"margin:0;\">"
                + "<iframe width=\"100%\" height=\"100%\" "
                + "src=\"https://www.youtube.com/embed/" + id
                + "?autoplay=1&playsinline=1\" "
                + "frameborder=\"0\" "
                + "allow=\"autoplay; encrypted-media\" "
                + "allowfullscreen>"
                + "</iframe></body></html>";

        web.loadData(html, "text/html", "utf-8");
    }
}
