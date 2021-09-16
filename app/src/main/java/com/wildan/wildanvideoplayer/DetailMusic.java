package com.wildan.wildanvideoplayer;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

public class DetailMusic extends AppCompatActivity implements View.OnClickListener {

    private TextView judul;
    private TextView authorDetail;
    private ImageView play;
    private ImageView pause;
    private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_music);
        initView();
        play.setOnClickListener(this);
        pause.setOnClickListener(this);

        judul.setText(getIntent().getStringExtra("judul"));
        authorDetail.setText(getIntent().getStringExtra("author"));

        pause.setVisibility(View.INVISIBLE);

    }


    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.play:
                playAudio();
                break;

            case R.id.pause:
                pauseAudio();
                break;
        }
    }

    private void playAudio() {
        mediaPlayer = MediaPlayer.create(this, getIntent().getIntExtra("file",0));

        //Kondisi Button setelah tombol play di klik
        play.setVisibility(View.INVISIBLE);
        pause.setVisibility(View.VISIBLE);

        //Menjalankan Audio / Musik
        try{
            mediaPlayer.prepare();
        }catch (IllegalStateException ex){
            ex.printStackTrace();
        }catch (IOException ex1){
            ex1.printStackTrace();
        }
        mediaPlayer.start();

        //Setelah audio selesai dimainkan maka kondisi Button akan kembali seperti awal
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                play.setVisibility(View.VISIBLE);
                pause.setVisibility(View.INVISIBLE);
            }
        });
    }

    private void pauseAudio() {
        //Jika audio sedang dimainkan, maka audio dapat di pause
        if(mediaPlayer.isPlaying()){
            if(mediaPlayer != null){
                mediaPlayer.pause();
                play.setVisibility(View.VISIBLE);
                pause.setVisibility(View.INVISIBLE);
            }
        }else {

            //Jika audio sedang di pause, maka audio dapat dilanjutkan kembali
            if(mediaPlayer != null){
                mediaPlayer.start();
                play.setVisibility(View.INVISIBLE);
                pause.setVisibility(View.VISIBLE);
            }
        }
    }

    private void initView() {
        judul = (TextView) findViewById(R.id.judul);
        authorDetail = (TextView) findViewById(R.id.author_detail);
        play = (ImageView) findViewById(R.id.play);
        pause = (ImageView) findViewById(R.id.pause);
    }
}