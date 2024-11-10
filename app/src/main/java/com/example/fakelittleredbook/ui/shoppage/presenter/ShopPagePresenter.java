package com.example.fakelittleredbook.ui.shoppage.presenter;

import com.example.fakelittleredbook.ui.shoppage.contract.IShopPageContract;
import com.example.fakelittleredbook.ui.shoppage.model.LoadShopPageInfoCallBack;
import com.example.fakelittleredbook.ui.shoppage.model.ShopItemInfo;

import java.util.List;

public class ShopPagePresenter implements IShopPageContract.IShopPagePresenter, LoadShopPageInfoCallBack<List<ShopItemInfo>> {
    private IShopPageContract.IShopPageModel model;
    private IShopPageContract.IShopPageView view;

    public ShopPagePresenter(IShopPageContract.IShopPageModel model, IShopPageContract.IShopPageView view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void getShopPageInfo(String data) {
        model.execute(data, this);
    }

    @Override
    public void onSuccess(List<ShopItemInfo> shopItemInfos) {
        if (view.isActive()) {
            view.showShopPageInfomation(shopItemInfos);
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
