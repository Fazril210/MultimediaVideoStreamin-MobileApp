package com.example.mutimediavideostreaming;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    BottomNavigationView navigationBottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navigationBottom = findViewById(R.id.navigation_bottom);
        navigationBottom.setOnNavigationItemSelectedListener(listener);
    }

    private final BottomNavigationView.OnNavigationItemSelectedListener listener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case nav_audio_sederhana:
                    Intent a = new Intent(MainActivity.this, Audiosederhana.class);
                    startActivity(a);
                    break;
                case nav_video_sederhana:
                    Intent v = new Intent(MainActivity.this, VideoSederhana.class);
                    startActivity(v);
                    break;
                case nav_audio_streaming:
                    Intent s = new Intent(MainActivity.this, AudioStreaming.class);
                    startActivity(s);
                    break;
                case nav_video_streaming:
                    Intent i = new Intent(MainActivity.this, VideoStreaming.class);
                    startActivity(i);
                    break;
                default:
                    return false;
            }
            return false;
        }
    };
}
