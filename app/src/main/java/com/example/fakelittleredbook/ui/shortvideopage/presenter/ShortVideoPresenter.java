package com.example.fakelittleredbook.ui.shortvideopage.presenter;

import com.example.fakelittleredbook.ui.shortvideopage.contract.IShortVideoPageContract;
import com.example.fakelittleredbook.ui.shortvideopage.model.LoadShortVideoPageInfoCallBack;
import com.example.fakelittleredbook.ui.shortvideopage.model.ShortVideoInfo;

import java.util.List;

public class ShortVideoPresenter implements IShortVideoPageContract.IShortVideoPagePresenter
        , LoadShortVideoPageInfoCallBack<List<ShortVideoInfo>> {
    private IShortVideoPageContract.IShortVideoPageModel model;
    private IShortVideoPageContract.IShortVideoPageView view;

    public ShortVideoPresenter(IShortVideoPageContract.IShortVideoPageModel model, IShortVideoPageContract.IShortVideoPageView view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void getShortVideoPageInfo(String data) {
        model.execute(data,this);
    }

    @Override
    public void onSuccess(List<ShortVideoInfo> shortVideoInfos) {
        if (view.isActive()) {
            view.showShortVideoPageInfomation(shortVideoInfos);
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
