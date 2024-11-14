package com.example.fakelittleredbook.ui.notepage.view;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.fakelittleredbook.R;
import com.example.fakelittleredbook.databinding.ActivityNotePageBinding;
import com.example.fakelittleredbook.ui.notepage.contract.INotePageContract;
import com.example.fakelittleredbook.ui.notepage.model.NoteInfo;
import com.example.fakelittleredbook.ui.notepage.model.NotePageModel;
import com.example.fakelittleredbook.ui.notepage.presenter.NotePagePresenter;
import com.example.fakelittleredbook.ui.shortvideopage.contract.IShortVideoPageContract;

public class NotePageActivity extends AppCompatActivity implements INotePageContract.INotePageView {

    private ActivityNotePageBinding binding;
    private INotePageContract.INotePagePresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityNotePageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        mPresenter = new NotePagePresenter(new NotePageModel(),this);
        mPresenter.getNotePageInfo("笔记");
    }

    @Override
    public void setPresenter(INotePageContract.INotePagePresenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showNotePageInfomation(NoteInfo noteInfos) {

    }

    @Override
    public void showError() {

    }

    @Override
    public boolean isActive() {
        return true;
    }
}