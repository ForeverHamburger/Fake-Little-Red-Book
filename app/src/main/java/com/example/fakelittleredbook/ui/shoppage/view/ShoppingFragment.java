package com.example.fakelittleredbook.ui.shoppage.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fakelittleredbook.R;
import com.example.fakelittleredbook.databinding.FragmentShoppingBinding;
import com.example.fakelittleredbook.ui.shoppage.contract.IShopPageContract;
import com.example.fakelittleredbook.ui.shoppage.model.ShopItemInfo;

import java.util.List;

public class ShoppingFragment extends Fragment implements IShopPageContract.IShopPageView {
    private FragmentShoppingBinding binding;
    private IShopPageContract.IShopPagePresenter mPresenter;

    public ShoppingFragment() {

    }

    public static ShoppingFragment newInstance() {
        ShoppingFragment fragment = new ShoppingFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentShoppingBinding.inflate(inflater);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void setPresenter(IShopPageContract.IShopPagePresenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showShopPageInfomation(List<ShopItemInfo> shopItemInfos) {

    }

    @Override
    public void showError() {
    }

    @Override
    public boolean isActive() {
        return true;
    }
}