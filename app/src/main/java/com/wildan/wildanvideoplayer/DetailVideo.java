package com.wildan.wildanvideoplayer;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailVideo extends AppCompatActivity {

    private VideoView videoView;
    private ImageView play;
    private ImageView pause;
    private MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_video);
        initView();
        mediaController = new MediaController(this);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Variable Uri untuk menentukan lokasi Resource Video yang akan ditampilkan
                Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+getIntent().getIntExtra("file",0));

                videoView.setVideoURI(uri);

                //Memasang MediaController untuk menampilkan tombol play, pause, dsb
                videoView.setMediaController(mediaController);
                mediaController.setAnchorView(videoView);

                //Menjalankan Video
                videoView.start();
            }
        });
    }

    private void initView() {
        videoView = (VideoView) findViewById(R.id.videoView);
        play = (ImageView) findViewById(R.id.play);
        pause = (ImageView) findViewById(R.id.pause);
    }
}