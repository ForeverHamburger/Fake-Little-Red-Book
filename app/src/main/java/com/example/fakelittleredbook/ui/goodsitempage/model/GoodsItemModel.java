package com.example.fakelittleredbook.ui.goodsitempage.model;

import com.example.fakelittleredbook.ui.goodsitempage.contract.IGoodsItemPageContract;
import com.example.fakelittleredbook.ui.shortvideopage.model.ShortVideoInfo;

import java.util.List;

public class GoodsItemModel implements IGoodsItemPageContract.IGoodsItemPageModel<String> {
    @Override
    public void execute(String data, LoadGoodsItemPageInfoCallBack callBack) {
        callBack.onStart();
        GoodsItemInfo goodsItemInfo = null;
        callBack.onSuccess(goodsItemInfo);

        callBack.onFinish();

        if (false) {
            callBack.onFailed();
        }
    }
}
