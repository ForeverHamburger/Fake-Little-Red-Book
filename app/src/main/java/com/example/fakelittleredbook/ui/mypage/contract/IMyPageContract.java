package com.example.fakelittleredbook.ui.mypage.contract;

import com.example.fakelittleredbook.base.BaseView;
import com.example.fakelittleredbook.ui.messagepage.model.MessageInfo;
import com.example.fakelittleredbook.ui.mypage.model.LoadMyInfoCallBack;
import com.example.fakelittleredbook.ui.mypage.model.MyInfo;

import java.util.List;

public interface IMyPageContract {
    interface IMyPageModel<T> {
        // data是请求数据用的头
        // callBack为回调方法
        void execute(T data, LoadMyInfoCallBack callBack);
    }
    interface IMyPagePresenter{
        void getMessageInfo(String data);
    }
    interface IMyPageView extends BaseView<IMyPagePresenter> {
        void showMyInfomation(MyInfo myinfo);
        void showError();
        // 用于判断Fragment是否添加到了Activity中
        boolean isActive();
    }
}
