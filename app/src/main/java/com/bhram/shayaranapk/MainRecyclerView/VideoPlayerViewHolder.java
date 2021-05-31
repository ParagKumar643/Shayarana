package com.bhram.shayaranapk.MainRecyclerView;

import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bhram.shayaranapk.Models.MediaObjects;
import com.bhram.shayaranapk.R;
import com.bumptech.glide.RequestManager;
import de.hdodenhof.circleimageview.CircleImageView;


public class VideoPlayerViewHolder extends RecyclerView.ViewHolder {

    FrameLayout media_container;
    TextView title;
    ImageView thumbnail, volumeControl;
    ProgressBar progressBar;
    View parent;
    RequestManager requestManager;

    public VideoPlayerViewHolder(@NonNull View itemView) {
        super(itemView);
        parent = itemView;
        media_container = itemView.findViewById(R.id.media_container);
        thumbnail = itemView.findViewById(R.id.thumbnail);
        title = itemView.findViewById(R.id.title);
        volumeControl = itemView.findViewById(R.id.volume_control);
    }

    public void onBind(MediaObjects mediaObject, RequestManager requestManager) {
        this.requestManager = requestManager;
        parent.setTag(this);
        title.setText(mediaObject.getDescription()+",\n"+mediaObject.getData());

        this.requestManager.load(mediaObject.getThumbnail()).into(thumbnail);
    }
}
