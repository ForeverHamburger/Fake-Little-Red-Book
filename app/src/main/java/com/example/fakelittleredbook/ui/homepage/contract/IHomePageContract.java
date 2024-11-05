package com.example.fakelittleredbook.ui.homepage.contract;

import com.example.fakelittleredbook.base.BaseView;
import com.example.fakelittleredbook.ui.homepage.model.LoadHomePageInfoCallBack;

import java.util.List;

public interface IHomePageContract {
    interface IHomePageModel<T> {
        // data是请求数据用的头
        // callBack为回调方法
        void execute(T data, LoadHomePageInfoCallBack callBack);
    }
    interface IHomePagePresenter{
        void getHomePageInfo(String data);
    }
    interface IHomePageView extends BaseView<IHomePagePresenter> {
        void showHomePageInfomation(List<String> waterFallInfo);
        void showError();
        // 用于判断Fragment是否添加到了Activity中
        boolean isActive();
    }
}
