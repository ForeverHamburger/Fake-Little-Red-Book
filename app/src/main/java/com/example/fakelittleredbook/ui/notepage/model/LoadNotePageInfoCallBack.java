package com.example.fakelittleredbook.ui.notepage.model;

public interface LoadNotePageInfoCallBack<T> {
    void onSuccess(T t);
    void onStart();
    void onFailed();
    void onFinish();
}
