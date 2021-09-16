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

import com.wildan.wildanvideoplayer.DetailVideo;
import com.wildan.wildanvideoplayer.Model.VideoModel;
import com.wildan.wildanvideoplayer.R;

import java.util.List;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.VideoViewHolder> {

    Context context;
    List<VideoModel>videoModelList;
    public VideoAdapter(Context context, List<VideoModel>videoModelList){
        this.context = context;
        this.videoModelList = videoModelList;
    }

    @NonNull
    @Override
    public VideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_video, parent, false);
        VideoAdapter.VideoViewHolder holder = new VideoAdapter.VideoViewHolder(v); //inisialisasi ViewHolder
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull VideoViewHolder holder, int position) {
        VideoModel video = videoModelList.get(position);
        holder.tv_judul.setText(video.getJudul());
        holder.cl_video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailVideo.class);
                intent.putExtra("file",video.getFile());
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return videoModelList.size();
    }

    public class VideoViewHolder extends RecyclerView.ViewHolder {
        TextView tv_judul;
        ConstraintLayout cl_video;
        public VideoViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_judul = itemView.findViewById(R.id.tv_judul);
            cl_video = itemView.findViewById(R.id.cl_video);
        }
    }
}
