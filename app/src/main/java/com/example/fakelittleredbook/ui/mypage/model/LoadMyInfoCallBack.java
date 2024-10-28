package com.example.fakelittleredbook.ui.mypage.model;

public interface LoadMyInfoCallBack<T> {
    void onSuccess(T... t);
    void onStart();
    void onFailed();
    void onFinish();
}
