package com.example.fakelittleredbook.ui.shoppage.model;

import com.example.fakelittleredbook.ui.shoppage.contract.IShopPageContract;

import java.util.ArrayList;
import java.util.List;

public class ShopPageModel implements IShopPageContract.IHomePageModel<String> {
    @Override
    public void execute(String data, LoadShopPageInfoCallBack callBack) {
        callBack.onStart();

        callBack.onStart();

        // 造一点数据
        List<ShopItemInfo> list = new ArrayList<>();

        callBack.onSuccess(list);

        callBack.onFinish();

        if (false) {
            callBack.onFailed();
        }
    }
}
