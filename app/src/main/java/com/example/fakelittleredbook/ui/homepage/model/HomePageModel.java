package com.example.fakelittleredbook.ui.homepage.model;

import com.example.fakelittleredbook.R;
import com.example.fakelittleredbook.ui.homepage.contract.IHomePageContract;
import com.example.fakelittleredbook.ui.waterfallpage.model.WaterFallInfo;

import java.util.ArrayList;
import java.util.List;

public class HomePageModel implements IHomePageContract.IHomePageModel<String> {
    @Override
    public void execute(String data, LoadHomePageInfoCallBack callBack) {
        callBack.onStart();

        callBack.onStart();

        // 造一点数据
        List<String> list = new ArrayList<>();
        list.add("aaa");

        callBack.onSuccess(list);

        callBack.onFinish();

        if (false) {
            callBack.onFailed();
        }
    }
}
