package com.example.fakelittleredbook.ui.goodsitempage.contract;

import com.example.fakelittleredbook.base.BaseView;
import com.example.fakelittleredbook.ui.goodsitempage.model.GoodsItemInfo;
import com.example.fakelittleredbook.ui.goodsitempage.model.LoadGoodsItemPageInfoCallBack;
import com.example.fakelittleredbook.ui.shortvideopage.model.LoadShortVideoPageInfoCallBack;
import com.example.fakelittleredbook.ui.shortvideopage.model.ShortVideoInfo;

import java.util.List;

public interface IGoodsItemPageContract {
    interface IGoodsItemPageModel<T> {
        // data是请求数据用的头
        // callBack为回调方法
        void execute(T data, LoadGoodsItemPageInfoCallBack callBack);
    }
    interface IGoodsItemPagePresenter{
        void getGoodsItemPageInfo(String data);
    }
    interface IGoodsItemPageView extends BaseView<IGoodsItemPagePresenter> {
        void showGoodsItemPageInfomation(GoodsItemInfo GoodsItemInfo);
        void showError();
        // 用于判断Fragment是否添加到了Activity中
        boolean isActive();
    }
}
