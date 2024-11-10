package com.example.fakelittleredbook.ui.shortvideopage.view;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.fakelittleredbook.R;
import com.example.fakelittleredbook.databinding.ActivityShortVideoBinding;
import com.example.fakelittleredbook.ui.shortvideopage.contract.IShortVideoPageContract;
import com.example.fakelittleredbook.ui.shortvideopage.model.ShortVideoInfo;

import java.util.List;

public class ShortVideoActivity extends AppCompatActivity implements IShortVideoPageContract.IShortVideoPageView {

    private ActivityShortVideoBinding binding;
    private IShortVideoPageContract.IShortVideoPagePresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityShortVideoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


    }

    @Override
    public void setPresenter(IShortVideoPageContract.IShortVideoPagePresenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showShortVideoPageInfomation(List<ShortVideoInfo> ShortVedioInfo) {

    }

    @Override
    public void showError() {
    }

    @Override
    public boolean isActive() {
        return true;
    }
}