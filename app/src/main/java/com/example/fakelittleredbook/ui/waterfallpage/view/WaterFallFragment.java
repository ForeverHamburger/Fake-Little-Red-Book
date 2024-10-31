package com.example.fakelittleredbook.ui.waterfallpage.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fakelittleredbook.R;
import com.example.fakelittleredbook.databinding.FragmentWaterFallBinding;
import com.example.fakelittleredbook.ui.mypage.contract.IMyPageContract;
import com.example.fakelittleredbook.ui.mypage.model.MyInfo;
import com.example.fakelittleredbook.ui.waterfallpage.contract.IWaterFallContract;
import com.example.fakelittleredbook.ui.waterfallpage.model.WaterFallInfo;
import com.example.fakelittleredbook.ui.waterfallpage.model.WaterFallModel;
import com.example.fakelittleredbook.ui.waterfallpage.presenter.WaterFallPagePresenter;
import com.example.fakelittleredbook.ui.waterfallpage.view.adapters.WaterFallAdapter;

import java.util.List;

public class WaterFallFragment extends Fragment implements IWaterFallContract.IWaterFallPageView {
    private FragmentWaterFallBinding binding;
    private IWaterFallContract.IWaterFallPagePresenter mPresenter;
    private String requestType = "default";
    public WaterFallFragment() {
    }

    public WaterFallFragment(String requestType) {
        this.requestType = requestType;
    }

    public static WaterFallFragment newInstance() {
        WaterFallFragment fragment = new WaterFallFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentWaterFallBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter.getWaterFallInfo(requestType);
    }

    @Override
    public void showWaterFallInfomation(List<WaterFallInfo> waterFallInfo) {
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        binding.rvWaterFall.setLayoutManager(layoutManager);
        WaterFallAdapter waterFallAdapter = new WaterFallAdapter(waterFallInfo);
        binding.rvWaterFall.setAdapter(waterFallAdapter);
    }

    @Override
    public void showError() {

    }

    @Override
    public boolean isActive() {
        return true;
    }

    @Override
    public void setPresenter(IWaterFallContract.IWaterFallPagePresenter presenter) {
        mPresenter = presenter;
    }
}