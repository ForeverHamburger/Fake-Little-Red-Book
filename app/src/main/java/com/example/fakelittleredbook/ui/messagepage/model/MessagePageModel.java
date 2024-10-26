package com.example.fakelittleredbook.ui.messagepage.model;

import com.example.fakelittleredbook.ui.messagepage.contract.IMessagePageContract;

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
        loadTasksCallBack.onStart();

        // 造一点数据
        MessageInfo messageInfo = null;
        loadTasksCallBack.onSuccess(messageInfo);

        loadTasksCallBack.onFinish();

        if (false) {
            loadTasksCallBack.onFailed();
        }
    }
}
