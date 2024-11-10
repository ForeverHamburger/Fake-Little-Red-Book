package com.example.fakelittleredbook.ui.shortvideopage.contract;

import com.example.fakelittleredbook.base.BaseView;
import com.example.fakelittleredbook.ui.shortvideopage.model.LoadShortVideoPageInfoCallBack;
import com.example.fakelittleredbook.ui.shortvideopage.model.ShortVideoInfo;

import java.util.List;

public interface IShortVideoPageContract {
    interface IShortVideoPageModel<T> {
        // data是请求数据用的头
        // callBack为回调方法
        void execute(T data, LoadShortVideoPageInfoCallBack callBack);
    }
    interface IShortVideoPagePresenter{
        void getShortVideoPageInfo(String data);
    }
    interface IShortVideoPageView extends BaseView<IShortVideoPagePresenter> {
        void showShortVideoPageInfomation(List<ShortVideoInfo> ShortVedioInfo);
        void showError();
        // 用于判断Fragment是否添加到了Activity中
        boolean isActive();
    }
}
