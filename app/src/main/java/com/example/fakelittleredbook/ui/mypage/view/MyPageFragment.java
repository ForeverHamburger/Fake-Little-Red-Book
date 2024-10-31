package com.example.fakelittleredbook.ui.mypage.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fakelittleredbook.R;
import com.example.fakelittleredbook.databinding.FragmentMyPageBinding;
import com.example.fakelittleredbook.ui.messagepage.model.MessageInfo;
import com.example.fakelittleredbook.ui.mypage.contract.IMyPageContract;
import com.example.fakelittleredbook.ui.mypage.model.MyInfo;
import com.example.fakelittleredbook.ui.mypage.view.adapters.MyFunctionAdapter;
import com.example.fakelittleredbook.ui.mypage.view.adapters.ViewPagerAdapter;
import com.example.fakelittleredbook.ui.waterfallpage.model.WaterFallModel;
import com.example.fakelittleredbook.ui.waterfallpage.presenter.WaterFallPagePresenter;
import com.example.fakelittleredbook.ui.waterfallpage.view.WaterFallFragment;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
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

        // 初始化RecyclerView
        initView();
    }

    private void initView() {
        // 初始化并且编造RecyclerView的数据
        List<String> myFunctions = new ArrayList<>();
        List<String> myDiscriptions = new ArrayList<>();
        myFunctions.add("购物");
        myFunctions.add("订单");
        myFunctions.add("购物车");
        myFunctions.add("创作灵感");
        myFunctions.add("浏览记录");

        myDiscriptions.add("1年1度购物狂欢");
        myDiscriptions.add("查看我的订单");
        myDiscriptions.add("查看推荐好物");
        myDiscriptions.add("学创作找灵感");
        myDiscriptions.add("看过的笔记");

        MyFunctionAdapter myFunctionAdapter = new MyFunctionAdapter(myFunctions,myDiscriptions);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        binding.rvMyFunctions.setLayoutManager(layoutManager);
        binding.rvMyFunctions.setAdapter(myFunctionAdapter);

        // ViewPager2与TabLayout绑定 与 数据初始化
        List<WaterFallFragment> fragmentList = new ArrayList<>();

        WaterFallFragment waterFallFragment = new WaterFallFragment();
        WaterFallModel waterFallModel = new WaterFallModel();
        WaterFallPagePresenter waterFallPagePresenter = new WaterFallPagePresenter(waterFallFragment, waterFallModel);
        waterFallFragment.setPresenter(waterFallPagePresenter);

        WaterFallFragment waterFallFragment1 = new WaterFallFragment();
        WaterFallModel waterFallModel1 = new WaterFallModel();
        WaterFallPagePresenter waterFallPagePresenter1 = new WaterFallPagePresenter(waterFallFragment1, waterFallModel1);
        waterFallFragment1.setPresenter(waterFallPagePresenter1);

        WaterFallFragment waterFallFragment2 = new WaterFallFragment();
        WaterFallModel waterFallModel2 = new WaterFallModel();
        WaterFallPagePresenter waterFallPagePresenter2 = new WaterFallPagePresenter(waterFallFragment2, waterFallModel2);
        waterFallFragment2.setPresenter(waterFallPagePresenter2);

        fragmentList.add(waterFallFragment);
        fragmentList.add(waterFallFragment1);
        fragmentList.add(waterFallFragment2);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getActivity(), fragmentList);
        binding.vpMy.setAdapter(viewPagerAdapter);
        new TabLayoutMediator(binding.tabMy, binding.vpMy, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int i) {
                if (i == 0) {
                    tab.setText("笔记");
                } else if (i == 1) {
                    tab.setText("收藏");
                } else {
                    tab.setText("赞过");
                }
            }
        }).attach();
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