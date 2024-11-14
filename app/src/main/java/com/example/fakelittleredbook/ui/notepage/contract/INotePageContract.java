package com.example.fakelittleredbook.ui.notepage.contract;

import com.example.fakelittleredbook.base.BaseView;
import com.example.fakelittleredbook.ui.notepage.model.LoadNotePageInfoCallBack;
import com.example.fakelittleredbook.ui.notepage.model.NoteInfo;
import com.example.fakelittleredbook.ui.shortvideopage.model.LoadShortVideoPageInfoCallBack;
import com.example.fakelittleredbook.ui.shortvideopage.model.ShortVideoInfo;

import java.util.List;

public interface INotePageContract {
    interface INotePageModel<T> {
        // data是请求数据用的头
        // callBack为回调方法
        void execute(T data, LoadNotePageInfoCallBack callBack);
    }
    interface INotePagePresenter{
        void getNotePageInfo(String data);
    }
    interface INotePageView extends BaseView<INotePagePresenter> {
        void showNotePageInfomation(NoteInfo noteInfos);
        void showError();
        // 用于判断Fragment是否添加到了Activity中
        boolean isActive();
    }
}
