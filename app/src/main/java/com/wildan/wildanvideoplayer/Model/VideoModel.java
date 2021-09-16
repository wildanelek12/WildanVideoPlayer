package com.wildan.wildanvideoplayer.Model;

public class VideoModel {
    String judul;
    int file;

    public VideoModel(String judul, int file) {

        this.judul = judul;
        this.file = file;
    }

    public String getJudul() {
        return judul;
    }

    public int getFile() {
        return file;
    }
}
