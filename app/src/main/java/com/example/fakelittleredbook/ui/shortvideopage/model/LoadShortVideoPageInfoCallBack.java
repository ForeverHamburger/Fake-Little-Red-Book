package com.example.fakelittleredbook.ui.shortvideopage.model;

public interface LoadShortVideoPageInfoCallBack<T> {
    void onSuccess(T t);
    void onStart();
    void onFailed();
    void onFinish();
}
