package com.example.fakelittleredbook.ui.messagepage.model;

public interface LoadTasksCallBack<T> {
    void onSuccess(T t,T t1);
    void onStart();
    void onFailed();
    void onFinish();
}
