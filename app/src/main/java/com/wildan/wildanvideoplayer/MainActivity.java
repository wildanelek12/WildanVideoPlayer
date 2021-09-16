package com.wildan.wildanvideoplayer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.wildan.wildanvideoplayer.Adapter.MusicAdapter;
import com.wildan.wildanvideoplayer.Adapter.VideoAdapter;
import com.wildan.wildanvideoplayer.Model.MusicData;
import com.wildan.wildanvideoplayer.Model.MusicModel;
import com.wildan.wildanvideoplayer.Model.VideoData;
import com.wildan.wildanvideoplayer.Model.VideoModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv_video,rv_music;
    List<MusicModel>listMusic;
    List<VideoModel>listVideo;
    MusicAdapter musicAdapter;
    VideoAdapter videoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv_video = findViewById(R.id.recyclerView);
        rv_music = findViewById(R.id.recyclerView2);

        listMusic = new ArrayList<>();
        listMusic = MusicData.musicModelList();

        listVideo = new ArrayList<>();
        listVideo = VideoData.videoModelList();

        musicAdapter = new MusicAdapter(this,listMusic);
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rv_music.setLayoutManager(layoutManager);
        rv_music.setAdapter(musicAdapter);

        videoAdapter = new VideoAdapter(this,listVideo);
        LinearLayoutManager layoutManager2
                = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        rv_video.setLayoutManager(layoutManager2);
        rv_video.setAdapter(videoAdapter);






    }
}