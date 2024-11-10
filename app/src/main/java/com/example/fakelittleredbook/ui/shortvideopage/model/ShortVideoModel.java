package com.example.fakelittleredbook.ui.shortvideopage.model;

import com.example.fakelittleredbook.ui.shortvideopage.contract.IShortVideoPageContract;

import java.util.List;

public class ShortVideoModel implements IShortVideoPageContract.IShortVideoPageModel<String> {
    @Override
    public void execute(String data, LoadShortVideoPageInfoCallBack callBack) {
        callBack.onStart();
        List<ShortVideoInfo> shortVideoInfos = null;
        callBack.onSuccess(shortVideoInfos);

        callBack.onFinish();

        if (false) {
            callBack.onFailed();
        }
    }
}
