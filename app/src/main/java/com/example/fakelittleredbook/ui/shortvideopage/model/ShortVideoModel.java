package com.example.fakelittleredbook.ui.shortvideopage.model;

import com.example.fakelittleredbook.ui.shortvideopage.contract.IShortVideoPageContract;

public class ShortVideoModel implements IShortVideoPageContract.IShortVideoPageModel<String> {
    @Override
    public void execute(String data, LoadShortVideoPageInfoCallBack callBack) {
        callBack.onStart();

        callBack.onSuccess(data);

        callBack.onFinish();

        if (false) {
            callBack.onFailed();
        }
    }
}
