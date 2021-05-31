package com.bhram.shayaranapk.MainRecyclerView;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bhram.shayaranapk.Models.MediaObjects;
import com.bhram.shayaranapk.R;
import com.bumptech.glide.RequestManager;
import java.util.ArrayList;



public class VideoPlayerRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<MediaObjects> mediaObjects;
    private RequestManager requestManager;


    public VideoPlayerRecyclerAdapter(ArrayList<MediaObjects> mediaObjects, RequestManager requestManager) {
        this.mediaObjects = mediaObjects;
        this.requestManager = requestManager;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new com.bhram.shayaranapk.MainRecyclerView.VideoPlayerViewHolder(
                LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_main, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ((com.bhram.shayaranapk.MainRecyclerView.VideoPlayerViewHolder)viewHolder).onBind(mediaObjects.get(i), requestManager);
    }

    @Override
    public int getItemCount() {
        return mediaObjects.size();
    }

}