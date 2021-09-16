package com.wildan.wildanvideoplayer.Model;

public class MusicModel {
    String author,judul;
    int file;

    public MusicModel(String author, String judul, int file) {
        this.author = author;
        this.judul = judul;
        this.file = file;
    }

    public String getAuthor() {
        return author;
    }

    public String getJudul() {
        return judul;
    }

    public int getFile() {
        return file;
    }
}
