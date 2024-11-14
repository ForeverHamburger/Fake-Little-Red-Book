package com.example.fakelittleredbook.ui.notepage.presenter;

import com.example.fakelittleredbook.ui.notepage.contract.INotePageContract;
import com.example.fakelittleredbook.ui.notepage.model.LoadNotePageInfoCallBack;
import com.example.fakelittleredbook.ui.notepage.model.NoteInfo;

import java.util.List;

public class NotePagePresenter implements INotePageContract.INotePagePresenter
        , LoadNotePageInfoCallBack<NoteInfo> {
    private INotePageContract.INotePageModel model;
    private INotePageContract.INotePageView view;

    public NotePagePresenter(INotePageContract.INotePageModel model, INotePageContract.INotePageView view) {
        this.model = model;
        this.view = view;
    }


    @Override
    public void getNotePageInfo(String data) {
        model.execute(data,this);
    }

    @Override
    public void onSuccess(NoteInfo noteInfo) {
        if (view.isActive()) {
            view.showNotePageInfomation(noteInfo);
        }
    }

    @Override
    public void onStart() {
        if (view.isActive()) {

        }
    }

    @Override
    public void onFailed() {
        if (view.isActive()) {
            view.showError();
        }
    }

    @Override
    public void onFinish() {
        if (view.isActive()) {

        }
    }
}