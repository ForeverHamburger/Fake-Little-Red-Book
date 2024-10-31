package com.example.fakelittleredbook.ui.mypage.view.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.fakelittleredbook.ui.waterfallpage.view.WaterFallFragment;

import java.util.List;

public class ViewPagerAdapter extends FragmentStateAdapter {

    private List<WaterFallFragment> fragmentList;
    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity
            , List<WaterFallFragment> fragmentList) {
        super(fragmentActivity);
        this.fragmentList = fragmentList;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return fragmentList == null ? null : fragmentList.get(position);
    }

    @Override
    public int getItemCount() {
        return fragmentList == null ? 0:fragmentList.size();
    }
}
