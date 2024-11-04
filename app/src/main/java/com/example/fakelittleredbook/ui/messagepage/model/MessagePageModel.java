package com.example.fakelittleredbook.ui.messagepage.model;

import com.example.fakelittleredbook.R;
import com.example.fakelittleredbook.ui.messagepage.contract.IMessagePageContract;

import java.util.ArrayList;
import java.util.List;

public class MessagePageModel implements IMessagePageContract.IMessagePageModel<String> {

    private static MessagePageModel INSTANCE = null;
    private LoadTasksCallBack loadTasksCallBack;

    public MessagePageModel() {
    }

    public static MessagePageModel getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new MessagePageModel();
        }
        return INSTANCE;
    }

    @Override
    public void execute(String data, LoadTasksCallBack callBack) {
        callBack.onStart();

        // 造一点数据
        List<MessageInfo> messageInfos = new ArrayList<>();
        messageInfos.add(new MessageInfo(R.drawable.icon_example,"系统消息"
                ,"你的八折优惠券马上到期啦~","星期三"));
        messageInfos.add(new MessageInfo(R.drawable.icon_nailong,"奶龙"
                ,"我是奶龙~~","星期四"));
        messageInfos.add(new MessageInfo(R.drawable.icon_nailong1,"芒果杀手"
                ,"喜欢发奶龙的小朋友你们好啊~","10月10日"));
        for (int i = 0; i < 10; i++) {
            messageInfos.add(new MessageInfo(R.drawable.icon_nailong1,"芒果杀手"
                    ,"喜欢发奶龙的小朋友你们好啊~","10月10日"));
        }
        messageInfos.add(new MessageInfo(R.drawable.icon_example,"系统消息"
                ,"你的八折优惠券马上到期啦~","星期三"));

        // 再造一点数据
        List<MessageInfo> fmfInfos = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            fmfInfos.add(new MessageInfo(R.drawable.icon_nailong1,"芒果杀手"
                    ,"喜欢发奶龙的小朋友你们好啊~","10月10日"));
        }

        callBack.onSuccess(messageInfos,fmfInfos);

        callBack.onFinish();

        if (false) {
            callBack.onFailed();
        }
    }
}
