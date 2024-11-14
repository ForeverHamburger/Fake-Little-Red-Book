package com.example.fakelittleredbook.ui.shortvideopage.view.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.media3.ui.PlayerView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fakelittleredbook.R;
import com.example.fakelittleredbook.ui.myviews.InputTextMsgDialog;

import java.util.ArrayList;
import java.util.List;

public class VideoPagerAdapter extends RecyclerView.Adapter<VideoPagerAdapter.VideoViewHolder>{
    private Context mContext;
    private List<String> mVieoUrls = new ArrayList<>();

    public VideoPagerAdapter(Context context) {
        super();
        this.mContext = context;
    }

    public void setDataList(List<String> videoUrls) {
        mVieoUrls.clear();
        mVieoUrls.addAll(videoUrls);
        notifyDataSetChanged();
        Log.d("Video_Play_TAG", "setDataList" );
    }

    public void addDataList(List<String> videoUrls) {
        mVieoUrls.addAll(videoUrls);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public VideoPagerAdapter.VideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.fragment_video_item, parent, false);
        return new VideoViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull VideoPagerAdapter.VideoViewHolder holder, int position) {
        holder.videoUrl = mVieoUrls.get(position);
        holder.itemView.setTag(position);

    }

    @Override
    public int getItemCount() {
        return mVieoUrls == null ? 0 : mVieoUrls.size();
    }

    public class VideoViewHolder extends RecyclerView.ViewHolder{

        public PlayerView mVideoView;
        public String videoUrl;
        public ImageButton ibtnComments;
        public VideoViewHolder(@NonNull View itemView) {
            super(itemView);
            mVideoView = itemView.findViewById(R.id.play_view);
            ibtnComments = itemView.findViewById(R.id.ibtn_comments);
        }
    }

    public String getUrlByPos(int pos) {
        return mVieoUrls.get(pos);
    }
}
