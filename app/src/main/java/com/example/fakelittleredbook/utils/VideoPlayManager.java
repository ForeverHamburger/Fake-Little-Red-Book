package com.example.fakelittleredbook.utils;

import android.content.Context;
import android.util.Log;

import androidx.annotation.OptIn;
import androidx.media3.common.MediaItem;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.ui.AspectRatioFrameLayout;

import java.util.ArrayList;
import java.util.List;

public class VideoPlayManager {
    private volatile static VideoPlayManager mInstance = null;
    private Context mContext;
    private ExoPlayer mSimpleExoPlayer;
    private VideoPlayTask mCurVideoPlayTask;

    public static VideoPlayManager getInstance(Context context) {
        if (mInstance == null) {
            synchronized (VideoPlayManager.class) {
                if(mInstance == null) {
                    mInstance = new VideoPlayManager(context);
                }
            }
        }
        return mInstance;
    }

    public VideoPlayManager(Context context) {
        this.mContext = context;
    }

    @OptIn(markerClass = UnstableApi.class) public void startPlay() {
        stopPlay();
        if(mCurVideoPlayTask == null) {
            Log.e("Video_Play_TAG", "start play task is null");
            return;
        }

        mSimpleExoPlayer = new ExoPlayer.Builder(mContext).build();
        // 准备要播放的媒体资源
        MediaItem mediaItem = MediaItem.fromUri(mCurVideoPlayTask.getVideoUrl());
        mSimpleExoPlayer.setMediaItem(mediaItem);

        // 隐藏播放工具
        mCurVideoPlayTask.getSimpleExoPlayerView().setUseController(true);

        // 设置播放视频的宽高为Fit模式
        mCurVideoPlayTask.getSimpleExoPlayerView().setResizeMode(AspectRatioFrameLayout.RESIZE_MODE_FIT);
        // 绑定player和playerView
        mCurVideoPlayTask.getSimpleExoPlayerView().setPlayer(mSimpleExoPlayer);
        mSimpleExoPlayer.setPlayWhenReady(true);

        // 准备播放器
        mSimpleExoPlayer.prepare();
        mSimpleExoPlayer.play();
    }


    public void stopPlay() {
        if(mSimpleExoPlayer != null) {
            mSimpleExoPlayer.release();
            mSimpleExoPlayer = null;
        }
    }

    public void resumePlay() {
        if(mSimpleExoPlayer != null) {
            mSimpleExoPlayer.setPlayWhenReady(true);
        } else {
            startPlay();
        }
    }

    public void pausePlay() {
        if(mSimpleExoPlayer != null) {
            mSimpleExoPlayer.setPlayWhenReady(false);
        }
    }

    public VideoPlayTask getCurVideoPlayTask() {
        return mCurVideoPlayTask;
    }

    public void setCurVideoPlayTask(VideoPlayTask mCurVideoPlayTask) {
        this.mCurVideoPlayTask = mCurVideoPlayTask;
    }

    public static List<String> buildTestVideoUrls() {
        List<String> urls = new ArrayList<>();
        urls.add("https://v-cdn.zjol.com.cn/276988.mp4");
        urls.add("https://media.w3.org/2010/05/sintel/trailer.mp4");
        urls.add("https://www.w3schools.com/html/movie.mp4");
        urls.add("http://vjs.zencdn.net/v/oceans.mp4");
        return urls;
    }
}