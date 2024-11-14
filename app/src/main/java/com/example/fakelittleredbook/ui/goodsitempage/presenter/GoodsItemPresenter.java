package com.example.fakelittleredbook.ui.goodsitempage.presenter;

import com.example.fakelittleredbook.ui.goodsitempage.contract.IGoodsItemPageContract;
import com.example.fakelittleredbook.ui.goodsitempage.model.GoodsItemInfo;
import com.example.fakelittleredbook.ui.goodsitempage.model.LoadGoodsItemPageInfoCallBack;

public class GoodsItemPresenter implements IGoodsItemPageContract.IGoodsItemPagePresenter
        , LoadGoodsItemPageInfoCallBack<GoodsItemInfo> {
    private IGoodsItemPageContract.IGoodsItemPageModel model;
    private IGoodsItemPageContract.IGoodsItemPageView view;

    public GoodsItemPresenter(IGoodsItemPageContract.IGoodsItemPageModel model, IGoodsItemPageContract.IGoodsItemPageView view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void getGoodsItemPageInfo(String data) {
        model.execute(data,this);
    }

    @Override
    public void onSuccess(GoodsItemInfo goodsItemInfo) {
        if (view.isActive()) {
            view.showGoodsItemPageInfomation(goodsItemInfo);
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
