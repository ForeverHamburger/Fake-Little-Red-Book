package com.example.fakelittleredbook.ui.shoppage.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fakelittleredbook.R;
import com.example.fakelittleredbook.databinding.FragmentShoppingBinding;
import com.example.fakelittleredbook.ui.myviews.MyBottomSheetDialog;
import com.example.fakelittleredbook.ui.shoppage.contract.IShopPageContract;
import com.example.fakelittleredbook.ui.shoppage.model.ShopItemInfo;
import com.example.fakelittleredbook.ui.shoppage.view.adapters.ShopItemFallAdapter;
import com.example.fakelittleredbook.ui.shoppage.view.adapters.ShoppingFunctionAdapter;

import java.util.ArrayList;
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
        mPresenter.getShopPageInfo("123");
        binding.button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyBottomSheetDialog bottomSheetDialog = new MyBottomSheetDialog(getActivity());
                bottomSheetDialog.setContentView(R.layout.bottom_dialog_layout);
                bottomSheetDialog.show();
            }
        });

        // functions部分的逻辑
        List<String> myFunctions = new ArrayList<>();
        List<Integer> myDiscriptions = new ArrayList<>();
        myFunctions.add("我的订单");
        myFunctions.add("购物车");
        myFunctions.add("客服消息");
        myFunctions.add("卡券");
        myFunctions.add("浏览记录");
        myFunctions.add("关注店铺");
        myFunctions.add("心愿单");

        myDiscriptions.add(R.drawable.icon_dingdan);
        myDiscriptions.add(R.drawable.icon_shoppingcar);
        myDiscriptions.add(R.drawable.icon_kefu);
        myDiscriptions.add(R.drawable.icon_kaquan);
        myDiscriptions.add(R.drawable.icon_liulanjilu);
        myDiscriptions.add(R.drawable.icon_guanzhu);
        myDiscriptions.add(R.drawable.icon_xinyuan);

        ShoppingFunctionAdapter shoppingFunctionAdapter = new ShoppingFunctionAdapter(myDiscriptions, myFunctions);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        binding.rvShoppingFunctions.setLayoutManager(layoutManager);
        binding.rvShoppingFunctions.setAdapter(shoppingFunctionAdapter);
    }

    @Override
    public void setPresenter(IShopPageContract.IShopPagePresenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showShopPageInfomation(List<ShopItemInfo> shopItemInfos) {
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        binding.rvShoppingFalls.setLayoutManager(layoutManager);
        ShopItemFallAdapter shopItemFallAdapter = new ShopItemFallAdapter(shopItemInfos,getActivity());
        binding.rvShoppingFalls.setAdapter(shopItemFallAdapter);
    }

    @Override
    public void showError() {
    }

    @Override
    public boolean isActive() {
        return true;
    }
}