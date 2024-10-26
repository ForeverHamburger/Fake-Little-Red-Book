package com.example.fakelittleredbook.ui.messagepage.model;

public interface LoadTasksCallBack<T> {
    void onSuccess(T t);
    void onStart();
    void onFailed();
    void onFinish();
}
