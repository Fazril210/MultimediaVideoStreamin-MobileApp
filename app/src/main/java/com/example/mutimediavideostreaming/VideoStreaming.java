package com.example.mutimediavideostreaming;

import android.app.ProgressDialog;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class VideoStreaming extends AppCompatActivity {
    final String urlVideo = "https://cxftr.000webhostapp.com/video.mp4";


    ProgressDialog dialog;
    @BindView(R.id.video_view_stream)
    VideoView videoViewStream;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_streaming);
        ButterKnife.bind(this);
        dialog = new ProgressDialog(VideoStreaming.this);
        dialog.setTitle("Informasi");
        dialog.setMessage("Loading...");

        dialog.setIndeterminate(false);
        dialog.setCancelable(false);
        dialog.show();

        MediaController mController = new MediaController(VideoStreaming.this);

        mController.setAnchorView(videoViewStream);
        videoViewStream.setMediaController(mController);

        videoViewStream.setVideoURI(Uri.parse(urlVideo));
        videoViewStream.requestFocus();

        videoViewStream.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.start();
                dialog.dismiss();
            }
        });
    }

}