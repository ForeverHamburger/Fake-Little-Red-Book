package com.example.fakelittleredbook.ui.messagepage.contract;

import com.example.fakelittleredbook.base.BaseView;
import com.example.fakelittleredbook.ui.messagepage.model.LoadTasksCallBack;
import com.example.fakelittleredbook.ui.messagepage.model.MessageInfo;

import java.util.List;

public interface IMessagePageContract {
    interface IMessagePageModel<T> {
        // data是请求数据用的头
        // callBack为回调方法
        void execute(T data, LoadTasksCallBack callBack);
    }
    interface IMessagePagePresenter{
        void getMessageInfo(String data);
    }
    interface IMessagePageView extends BaseView<IMessagePagePresenter> {
        void showMessage(List<MessageInfo> messageList);
        void showError();
        // 用于判断Fragment是否添加到了Activity中
        boolean isActive();
    }
}
