package com.example.fakelittleredbook.ui.shoppage.contract;

import com.example.fakelittleredbook.base.BaseView;
import com.example.fakelittleredbook.ui.homepage.model.LoadHomePageInfoCallBack;
import com.example.fakelittleredbook.ui.shoppage.model.LoadShopPageInfoCallBack;
import com.example.fakelittleredbook.ui.shoppage.model.ShopItemInfo;

import java.util.List;

public interface IShopPageContract {
    interface IShopPageModel<T> {
        // data是请求数据用的头
        // callBack为回调方法
        void execute(T data, LoadShopPageInfoCallBack callBack);
    }
    interface IShopPagePresenter{
        void getShopPageInfo(String data);
    }
    interface IShopPageView extends BaseView<IShopPagePresenter> {
        void showShopPageInfomation(List<ShopItemInfo> shopItemInfo);
        void showError();
        // 用于判断Fragment是否添加到了Activity中
        boolean isActive();
    }
}
