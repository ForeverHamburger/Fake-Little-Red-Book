package com.example.fakelittleredbook.ui.goodsitempage.model;

public interface LoadGoodsItemPageInfoCallBack<T> {
    void onSuccess(T t);
    void onStart();
    void onFailed();
    void onFinish();
}
