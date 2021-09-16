package com.wildan.wildanvideoplayer.Model;

import com.wildan.wildanvideoplayer.R;

import java.util.ArrayList;
import java.util.List;

public class VideoData {
    public static List<VideoModel> videoModelList(){

        VideoModel perlahan = new VideoModel("guyon waton", R.raw.perlahan_video);
        VideoModel korban_janji = new VideoModel("guyon waton",R.raw.korban_janji_video);
        VideoModel menepi = new VideoModel("guyon waton", R.raw.menepi_video);

        List<VideoModel> listVideo  = new ArrayList<>();

        listVideo.add(perlahan);
        listVideo.add(korban_janji);
        listVideo.add(menepi);

        return listVideo;
    }
}
