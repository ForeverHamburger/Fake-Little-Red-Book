package com.example.fakelittleredbook.ui.mypage.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fakelittleredbook.R;
import com.example.fakelittleredbook.databinding.FragmentMyPageBinding;
import com.example.fakelittleredbook.ui.messagepage.model.MessageInfo;
import com.example.fakelittleredbook.ui.mypage.contract.IMyPageContract;
import com.example.fakelittleredbook.ui.mypage.model.MyInfo;

import java.util.List;


public class MyPageFragment extends Fragment implements IMyPageContract.IMyPageView {

    private FragmentMyPageBinding binding;
    private IMyPageContract.IMyPagePresenter mPresenter;
    public MyPageFragment() {
        // Required empty public constructor
    }

    public static MyPageFragment newInstance() {
        MyPageFragment fragment = new MyPageFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMyPageBinding.inflate(inflater);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(getActivity(), binding.dlMyPage, binding.tbMyPage, R.string.drawer_open, R.string.drawer_close);
        binding.dlMyPage.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.setHomeAsUpIndicator(R.drawable.icon_menu);
        actionBarDrawerToggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.white));
        actionBarDrawerToggle.syncState();
    }

    @Override
    public void setPresenter(IMyPageContract.IMyPagePresenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showMyInfomation(MyInfo myInfo) {

    }

    @Override
    public void showError() {

    }

    @Override
    public boolean isActive() {
        return true;
    }
}