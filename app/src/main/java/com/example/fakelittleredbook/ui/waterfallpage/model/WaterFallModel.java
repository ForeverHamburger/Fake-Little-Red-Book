package com.example.fakelittleredbook.ui.waterfallpage.model;

import com.example.fakelittleredbook.R;
import com.example.fakelittleredbook.ui.waterfallpage.contract.IWaterFallContract;

import java.util.ArrayList;
import java.util.List;

public class WaterFallModel implements IWaterFallContract.IWaterFallPageModel<String> {
    @Override
    public void execute(String data, LoadWaterFallInfoCallBack callBack) {
        callBack.onStart();

        callBack.onStart();

        // 造一点数据
        List<WaterFallInfo> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            list.add(new WaterFallInfo(WaterFallInfo.NOTE, R.drawable.pic_nailong1,"☀奶龙大王入侵地球☀"
                    ,R.drawable.icon_nailong1,"奶龙大王","15.1k"));
            list.add(new WaterFallInfo(WaterFallInfo.NOTE, R.drawable.icon_nailong1,"☀奶龙入侵西邮☀"
                    ,R.drawable.icon_nailong1,"奶龙小王","20.1k"));
            list.add(new WaterFallInfo(WaterFallInfo.NOTE, R.drawable.nailong_long,"☀奶龙入侵东邮☀"
                    ,R.drawable.icon_nailong1,"奶龙long王","1.1k"));
            list.add(new WaterFallInfo(WaterFallInfo.NOTE, R.drawable.nailong3,"☀奶龙入侵美广☀"
                    ,R.drawable.icon_nailong1,"奶龙美王","12.1k"));
            list.add(new WaterFallInfo(WaterFallInfo.NOTE, R.drawable.nailong_dance,"☀奶龙入侵广场☀"
                    ,R.drawable.icon_nailong1,"奶龙舞王","23.1k"));
        }
        callBack.onSuccess(list);

        callBack.onFinish();

        if (false) {
            callBack.onFailed();
        }
    }
}
