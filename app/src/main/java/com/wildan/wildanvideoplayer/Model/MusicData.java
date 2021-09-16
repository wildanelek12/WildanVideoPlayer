package com.wildan.wildanvideoplayer.Model;

import com.wildan.wildanvideoplayer.R;

import java.util.ArrayList;
import java.util.List;

public class MusicData {
    public static List<MusicModel> musicModelList(){

        MusicModel perlahan = new MusicModel("guyon waton","Perlahan", R.raw.perlahan);
        MusicModel korban_janji = new MusicModel("guyon waton","Korban Janji", R.raw.korban_janji);
        MusicModel menepi = new MusicModel("guyon waton","Menepi", R.raw.menepi);

        List<MusicModel> listMusic  = new ArrayList<>();

        listMusic.add(perlahan);
        listMusic.add(korban_janji);
        listMusic.add(menepi);

        return listMusic;
    }
}
