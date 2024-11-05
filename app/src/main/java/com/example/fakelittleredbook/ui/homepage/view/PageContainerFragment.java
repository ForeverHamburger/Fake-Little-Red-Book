package com.example.fakelittleredbook.ui.homepage.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fakelittleredbook.R;
import com.example.fakelittleredbook.databinding.FragmentPageContainerBinding;
import com.example.fakelittleredbook.ui.mypage.view.adapters.ViewPagerAdapter;
import com.example.fakelittleredbook.ui.waterfallpage.model.WaterFallModel;
import com.example.fakelittleredbook.ui.waterfallpage.presenter.WaterFallPagePresenter;
import com.example.fakelittleredbook.ui.waterfallpage.view.WaterFallFragment;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

public class PageContainerFragment extends Fragment {
    private FragmentPageContainerBinding binding;

    public PageContainerFragment() {
        // Required empty public constructor
    }
    public static PageContainerFragment newInstance(String param1, String param2) {
        PageContainerFragment fragment = new PageContainerFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentPageContainerBinding.inflate(inflater);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(getActivity(), binding.dlHomePage, binding.tbHomePage
                , R.string.drawer_open, R.string.drawer_close);
        binding.dlHomePage.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        initView();
    }

    private void initView() {

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
        binding.vpHome.setAdapter(viewPagerAdapter);

        new TabLayoutMediator(binding.tabHomeHide, binding.vpHome, new TabLayoutMediator.TabConfigurationStrategy() {
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

        new TabLayoutMediator(binding.tabHomeHide, binding.vpHome, new TabLayoutMediator.TabConfigurationStrategy() {
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
}