package com.example.fakelittleredbook.ui.waterfallpage.presenter;

import com.example.fakelittleredbook.ui.waterfallpage.contract.IWaterFallContract;
import com.example.fakelittleredbook.ui.waterfallpage.model.LoadWaterFallInfoCallBack;
import com.example.fakelittleredbook.ui.waterfallpage.model.WaterFallInfo;

import java.util.List;

public class WaterFallPagePresenter implements IWaterFallContract.IWaterFallPagePresenter, LoadWaterFallInfoCallBack<List<WaterFallInfo>> {
    private IWaterFallContract.IWaterFallPageView view;
    private IWaterFallContract.IWaterFallPageModel model;

    public WaterFallPagePresenter(IWaterFallContract.IWaterFallPageView view, IWaterFallContract.IWaterFallPageModel model) {
        this.view = view;
        this.model = model;
    }

    @Override
    public void getWaterFallInfo(String data) {
        model.execute(data,this);
    }

    @Override
    public void onSuccess(List<WaterFallInfo> waterFallInfos) {
        if (view.isActive()) {
            view.showWaterFallInfomation(waterFallInfos);
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
