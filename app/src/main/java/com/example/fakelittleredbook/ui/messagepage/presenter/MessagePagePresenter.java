package com.example.fakelittleredbook.ui.messagepage.presenter;

import com.example.fakelittleredbook.ui.messagepage.contract.IMessagePageContract;
import com.example.fakelittleredbook.ui.messagepage.model.LoadTasksCallBack;
import com.example.fakelittleredbook.ui.messagepage.model.MessageInfo;

import java.util.List;

public class MessagePagePresenter implements IMessagePageContract.IMessagePagePresenter, LoadTasksCallBack<List<MessageInfo>> {
    private IMessagePageContract.IMessagePageView view;
    private IMessagePageContract.IMessagePageModel model;

    public MessagePagePresenter(IMessagePageContract.IMessagePageView view, IMessagePageContract.IMessagePageModel model) {
        this.view = view;
        this.model = model;
    }

    @Override
    public void getMessageInfo(String data) {
        model.execute(data,this);
    }

    @Override
    public void onSuccess(List<MessageInfo> messageInfo) {
        if (view.isActive()) {
            view.showMessage(messageInfo);
        }
    }

    @Override
    public void onStart() {
        if (view.isActive()) {
//            view.showLoading();
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
//            view.hideLoading(messageInfo);
        }
    }
}
