package com.example.fakelittleredbook.ui.mypage.presenter;

import com.example.fakelittleredbook.ui.mypage.contract.IMyPageContract;
import com.example.fakelittleredbook.ui.mypage.model.LoadMyInfoCallBack;
import com.example.fakelittleredbook.ui.mypage.model.MyInfo;

public class MyPagePresenter implements IMyPageContract.IMyPagePresenter , LoadMyInfoCallBack<MyInfo> {
    private IMyPageContract.IMyPageView view;
    private IMyPageContract.IMyPageModel model;

    public MyPagePresenter(IMyPageContract.IMyPageView view, IMyPageContract.IMyPageModel model) {
        this.view = view;
        this.model = model;
    }

    @Override
    public void getMessageInfo(String data) {
        model.execute(data,this);
    }

    @Override
    public void onSuccess(MyInfo... t) {
        if (view.isActive()) {
            view.showMyInfomation(t[0]);
        }
    }

    @Override
    public void onStart() {
        if (view.isActive()) {
            //
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
            //
        }
    }
}
