package com.example.fakelittleredbook.ui.shoppage.model;

import com.example.fakelittleredbook.R;
import com.example.fakelittleredbook.ui.shoppage.contract.IShopPageContract;

import java.util.ArrayList;
import java.util.List;

public class ShopPageModel implements IShopPageContract.IShopPageModel<String> {
    @Override
    public void execute(String data, LoadShopPageInfoCallBack callBack) {
        callBack.onStart();

        callBack.onStart();

        // 造一点数据
        List<ShopItemInfo> list = new ArrayList<>();
        list.add(new ShopItemInfo(R.drawable.pic_nailong_shopitem,"奶龙尸块","","¥499"
                ,"299","4000+人已购",""));
        list.add(new ShopItemInfo(R.drawable.pic_nailong_shopitem1,"奶龙尸块(久经沙场)","","¥299"
                ,"99","200+人已购",""));
        list.add(new ShopItemInfo(R.drawable.pic_nailong_shopitem2,"奶龙(崭新)","","¥79"
                ,"49","1400+人已购",""));
        list.add(new ShopItemInfo(R.drawable.pic_nailong_shopitem3,"奶龙(Dance)","","¥99"
                ,"79","400+人已购",""));

        list.add(new ShopItemInfo(R.drawable.pic_nailong_shopitem,"奶龙尸块","","¥499"
                ,"999","4000+人已购",""));
        list.add(new ShopItemInfo(R.drawable.pic_nailong_shopitem1,"奶龙尸块(久经沙场)","","¥299"
                ,"99","200+人已购",""));
        list.add(new ShopItemInfo(R.drawable.pic_nailong_shopitem2,"奶龙(崭新)","","¥79"
                ,"49","1400+人已购",""));
        list.add(new ShopItemInfo(R.drawable.pic_nailong_shopitem3,"奶龙(Dance)","","¥99"
                ,"79","400+人已购",""));

        callBack.onSuccess(list);

        callBack.onFinish();

        if (false) {
            callBack.onFailed();
        }
    }
}
