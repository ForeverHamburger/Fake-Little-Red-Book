package com.example.fakelittleredbook.ui.mypage.model;

import com.example.fakelittleredbook.ui.messagepage.model.LoadTasksCallBack;
import com.example.fakelittleredbook.ui.mypage.contract.IMyPageContract;

public class MyPageModel implements IMyPageContract.IMyPageModel<MyInfo> {

    @Override
    public void execute(MyInfo data, LoadMyInfoCallBack callBack) {
        callBack.onStart();

        // 造一点数据


        callBack.onSuccess();

        callBack.onFinish();

        if (false) {
            callBack.onFailed();
        }
    }
}
