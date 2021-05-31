package com.bhram.shayaranapk.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bhram.shayaranapk.Models.MediaObjects;
import com.bhram.shayaranapk.R;

import java.util.List;

public class DemoAdapter extends RecyclerView.Adapter<DemoAdapter.DemoViewHolder> {

    List<MediaObjects> mediaObjectList;
    Context context;

    public DemoAdapter(List<MediaObjects> mediaObjectList, Context context) {
        this.mediaObjectList = mediaObjectList;
        this.context = context;
    }

    @NonNull
    @Override
    public DemoViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_main,parent,false);

       return new DemoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  DemoAdapter.DemoViewHolder holder, int position) {

        MediaObjects mediaObject = mediaObjectList.get(position);

        //glide
    }

    @Override
    public int getItemCount() {
        return mediaObjectList.size();
    }

    public class DemoViewHolder extends RecyclerView.ViewHolder {
        //priivaate disc
        public DemoViewHolder(@NonNull  View itemView) {
            //disc
            super(itemView);
        }
    }
}
