package com.example.fakelittleredbook.ui.homepage.model;

public interface LoadHomePageInfoCallBack<T> {
    void onSuccess(T t);
    void onStart();
    void onFailed();
    void onFinish();
}
