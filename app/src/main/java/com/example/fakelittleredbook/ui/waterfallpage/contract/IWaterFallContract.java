package com.example.fakelittleredbook.ui.waterfallpage.contract;

import com.example.fakelittleredbook.base.BaseView;
import com.example.fakelittleredbook.ui.mypage.model.LoadMyInfoCallBack;
import com.example.fakelittleredbook.ui.mypage.model.MyInfo;
import com.example.fakelittleredbook.ui.waterfallpage.model.LoadWaterFallInfoCallBack;
import com.example.fakelittleredbook.ui.waterfallpage.model.WaterFallInfo;

import java.util.List;

public interface IWaterFallContract {
    interface IWaterFallPageModel<T> {
        // data是请求数据用的头
        // callBack为回调方法
        void execute(T data, LoadWaterFallInfoCallBack callBack);
    }
    interface IWaterFallPagePresenter{
        void getWaterFallInfo(String data);
    }
    interface IWaterFallPageView extends BaseView<IWaterFallPagePresenter> {
        void showWaterFallInfomation(List<WaterFallInfo> waterFallInfo);
        void showError();
        // 用于判断Fragment是否添加到了Activity中
        boolean isActive();
    }
}
