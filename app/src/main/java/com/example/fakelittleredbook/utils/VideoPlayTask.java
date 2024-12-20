package com.example.fakelittleredbook.utils;


import androidx.media3.ui.PlayerView;

public class VideoPlayTask {
    private PlayerView mSimpleExoPlayerView;
    private String mVideoUrl;

    public VideoPlayTask(PlayerView simpleExoPlayerView, String uri) {
        this.mSimpleExoPlayerView = simpleExoPlayerView;
        this.mVideoUrl = uri;
    }

    public PlayerView getSimpleExoPlayerView() {
        return mSimpleExoPlayerView;
    }

    public void setSimpleExoPlayerView(PlayerView mSimpleExoPlayerView) {
        this.mSimpleExoPlayerView = mSimpleExoPlayerView;
    }

    public String getVideoUrl() {
        return mVideoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.mVideoUrl = videoUrl;
    }
}