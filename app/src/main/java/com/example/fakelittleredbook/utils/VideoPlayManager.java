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
        mCurVideoPlayTask.getSimpleExoPlayerView().setUseController(false);
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
        urls.add("https://upos-sz-mirrorcos.bilivideo.com/upgcxcode/25/32/500001656593225/500001656593225-1-192.mp4?e=ig8euxZM2rNcNbRVhwdVhwdlhWdVhwdVhoNvNC8BqJIzNbfq9rVEuxTEnE8L5F6VnEsSTx0vkX8fqJeYTj_lta53NCM=&uipk=5&nbs=1&deadline=1731313658&gen=playurlv2&os=upos&oi=1866713016&trid=1ad94b05a4074d8cb53d50e2a89fa42fO&mid=0&platform=html5&og=08&upsig=f75c3c395245fbda2c5e60dcacffd2ba&uparams=e,uipk,nbs,deadline,gen,os,oi,trid,mid,platform,og&bvc=vod&nettype=1&orderid=0,3&buvid=&build=7330300&f=O_0_0&bw=68529&logo=80000000");
        urls.add("https://upos-sz-mirrorcos.bilivideo.com/upgcxcode/81/56/500001660315681/500001660315681-1-192.mp4?e=ig8euxZM2rNcNbRVhwdVhwdlhWdVhwdVhoNvNC8BqJIzNbfq9rVEuxTEnE8L5F6VnEsSTx0vkX8fqJeYTj_lta53NCM=&uipk=5&nbs=1&deadline=1731313574&gen=playurlv2&os=upos&oi=2584261250&trid=c8295a94c2e04bc6a2dc75e046367a2dO&mid=0&platform=html5&og=08&upsig=5b318c2db62922679292ea8738f79858&uparams=e,uipk,nbs,deadline,gen,os,oi,trid,mid,platform,og&bvc=vod&nettype=1&orderid=0,3&buvid=&build=7330300&f=O_0_0&bw=98626&logo=80000000");
        urls.add("https://cn-gdfs-ct-01-23.bilivideo.com/upgcxcode/10/46/26680754610/26680754610-1-16.mp4?e=ig8euxZM2rNcNbRVhwdVhwdlhWdVhwdVhoNvNC8BqJIzNbfq9rVEuxTEnE8L5F6VnEsSTx0vkX8fqJeYTj_lta53NCM=&uipk=5&nbs=1&deadline=1731313681&gen=playurlv2&os=bcache&oi=1782024106&trid=0000dee4c92f994348309ab34290d7eb15ddh&mid=0&platform=html5&og=08&upsig=345157cdcb00715b9f3a738f8f8d0ed7&uparams=e,uipk,nbs,deadline,gen,os,oi,trid,mid,platform,og&cdnid=60923&bvc=vod&nettype=0&f=h_0_0&bw=64907&logo=80000000");
        urls.add("https://cn-gdfs-ct-01-12.bilivideo.com/upgcxcode/87/22/26495682287/26495682287-1-16.mp4?e=ig8euxZM2rNcNbRVhwdVhwdlhWdVhwdVhoNvNC8BqJIzNbfq9rVEuxTEnE8L5F6VnEsSTx0vkX8fqJeYTj_lta53NCM=&uipk=5&nbs=1&deadline=1731313703&gen=playurlv2&os=bcache&oi=1782024106&trid=00002ea18f6c9fec460f9f33680258abaaefh&mid=0&platform=html5&og=cos&upsig=823b94b6984ba063d594786b60e1eca0&uparams=e,uipk,nbs,deadline,gen,os,oi,trid,mid,platform,og&cdnid=60912&bvc=vod&nettype=0&f=h_0_0&bw=13365&logo=80000000");
        urls.add("https://upos-sz-mirrorcos.bilivideo.com/upgcxcode/72/93/26258639372/26258639372-1-192.mp4?e=ig8euxZM2rNcNbRVhwdVhwdlhWdVhwdVhoNvNC8BqJIzNbfq9rVEuxTEnE8L5F6VnEsSTx0vkX8fqJeYTj_lta53NCM=&uipk=5&nbs=1&deadline=1731313735&gen=playurlv2&os=mcdn&oi=1696791047&trid=0000cc5f12b6c24f4c10b9f488a527a283bcO&mid=0&platform=html5&og=08&upsig=3fe3daac2997d48d32dc2cf1daf8eb20&uparams=e,uipk,nbs,deadline,gen,os,oi,trid,mid,platform,og&mcdnid=50012919&bvc=vod&nettype=1&orderid=0,3&buvid=&build=7330300&f=O_0_0&bw=101505&logo=A0020000");
        urls.add("https://cn-gdfs-ct-01-04.bilivideo.com/upgcxcode/97/49/26671844997/26671844997-1-16.mp4?e=ig8euxZM2rNcNbRVhwdVhwdlhWdVhwdVhoNvNC8BqJIzNbfq9rVEuxTEnE8L5F6VnEsSTx0vkX8fqJeYTj_lta53NCM=&uipk=5&nbs=1&deadline=1731313758&gen=playurlv2&os=bcache&oi=1782024106&trid=00001ef8c7ed4bb545d19ac4fb27925deb81h&mid=0&platform=html5&og=cos&upsig=8afa0c4e3f5ec1ca5b4813a3466672a5&uparams=e,uipk,nbs,deadline,gen,os,oi,trid,mid,platform,og&cdnid=60904&bvc=vod&nettype=0&f=h_0_0&bw=62894&logo=80000000");
        return urls;
    }
}