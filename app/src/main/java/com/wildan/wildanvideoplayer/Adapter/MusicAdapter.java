package com.wildan.wildanvideoplayer.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;


import com.wildan.wildanvideoplayer.DetailMusic;
import com.wildan.wildanvideoplayer.Model.MusicModel;
import com.wildan.wildanvideoplayer.R;

import java.util.List;

public class MusicAdapter extends RecyclerView.Adapter<MusicAdapter.MusicViewHolder> {

    Context context;
    List<MusicModel>MusicModelList;
    public MusicAdapter(Context context, List<MusicModel>MusicModelList){
        this.context = context;
        this.MusicModelList = MusicModelList;
    }

    @NonNull
    @Override
    public MusicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_music, parent, false);
        MusicAdapter.MusicViewHolder holder = new MusicAdapter.MusicViewHolder(v); //inisialisasi ViewHolder
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MusicViewHolder holder, int position) {
        MusicModel Music = MusicModelList.get(position);
        holder.tv_judul.setText(Music.getJudul());
        holder.tv_artis.setText(Music.getAuthor());
        holder.cl_Music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailMusic.class);
                intent.putExtra("file",Music.getFile());
                intent.putExtra("judul",Music.getJudul());
                intent.putExtra("author",Music.getAuthor());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return MusicModelList.size();
    }

    public class MusicViewHolder extends RecyclerView.ViewHolder {
        TextView tv_judul,tv_artis;
        ConstraintLayout cl_Music;
        public MusicViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_judul = itemView.findViewById(R.id.tv_judul);
            cl_Music = itemView.findViewById(R.id.cl_music);
            tv_artis = itemView.findViewById(R.id.tv_artis);
        }
    }
}
