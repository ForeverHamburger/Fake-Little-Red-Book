package com.example.fakelittleredbook.ui.notepage.model;

import com.example.fakelittleredbook.ui.notepage.contract.INotePageContract;
import com.example.fakelittleredbook.ui.shortvideopage.model.ShortVideoInfo;

import java.util.List;

public class NotePageModel implements INotePageContract.INotePageModel<String> {
    @Override
    public void execute(String data, LoadNotePageInfoCallBack callBack) {
        callBack.onStart();


        NoteInfo noteInfo = new NoteInfo();
        callBack.onSuccess(noteInfo);

        callBack.onFinish();

        if (false) {
            callBack.onFailed();
        }
    }
}
