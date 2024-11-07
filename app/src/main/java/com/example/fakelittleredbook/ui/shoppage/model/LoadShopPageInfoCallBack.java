package com.example.fakelittleredbook.ui.shoppage.model;

public interface LoadShopPageInfoCallBack<T> {
    void onSuccess(T t);
    void onStart();
    void onFailed();
    void onFinish();
}
