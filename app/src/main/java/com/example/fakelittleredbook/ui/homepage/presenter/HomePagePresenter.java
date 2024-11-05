package com.example.fakelittleredbook.ui.homepage.presenter;

import android.graphics.drawable.Icon;

import com.example.fakelittleredbook.ui.homepage.contract.IHomePageContract;
import com.example.fakelittleredbook.ui.homepage.model.LoadHomePageInfoCallBack;

import java.util.List;

public class HomePagePresenter implements IHomePageContract.IHomePagePresenter, LoadHomePageInfoCallBack<List<String>> {
    private IHomePageContract.IHomePageView view;
    private IHomePageContract.IHomePageModel model;
    @Override
    public void getHomePageInfo(String data) {
        model.execute(data,this);
    }

    @Override
    public void onSuccess(List<String> strings) {
        if (view.isActive()) {
            view.showHomePageInfomation(strings);
        }
    }

    @Override
    public void onStart() {
        if (view.isActive()) {

        }
    }

    @Override
    public void onFailed() {
        if (view.isActive()) {
            view.showError();
        }
    }

    @Override
    public void onFinish() {
        if (view.isActive()) {

        }
    }
}
