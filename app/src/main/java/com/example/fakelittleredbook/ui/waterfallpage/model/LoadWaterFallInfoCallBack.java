package com.example.fakelittleredbook.ui.waterfallpage.model;

public interface LoadWaterFallInfoCallBack<T> {
    void onSuccess(T t);
    void onStart();
    void onFailed();
    void onFinish();
}
