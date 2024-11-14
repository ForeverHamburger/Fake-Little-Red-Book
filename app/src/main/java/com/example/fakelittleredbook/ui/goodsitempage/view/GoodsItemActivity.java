package com.example.fakelittleredbook.ui.goodsitempage.view;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.widget.NestedScrollView;

import com.example.fakelittleredbook.R;
import com.example.fakelittleredbook.databinding.ActivityGoodsItemBinding;
import com.example.fakelittleredbook.ui.goodsitempage.contract.IGoodsItemPageContract;
import com.example.fakelittleredbook.ui.goodsitempage.model.GoodsItemInfo;
import com.example.fakelittleredbook.ui.goodsitempage.model.GoodsItemModel;
import com.example.fakelittleredbook.ui.goodsitempage.presenter.GoodsItemPresenter;
import com.example.fakelittleredbook.ui.notepage.model.PicBean;
import com.example.fakelittleredbook.ui.notepage.view.adapters.BannerAdapter;
import com.google.android.material.tabs.TabLayout;
import com.youth.banner.indicator.CircleIndicator;

import java.util.ArrayList;
import java.util.List;

public class GoodsItemActivity extends AppCompatActivity implements IGoodsItemPageContract.IGoodsItemPageView {

    private ActivityGoodsItemBinding binding;
    private IGoodsItemPageContract.IGoodsItemPagePresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityGoodsItemBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mPresenter = new GoodsItemPresenter(new GoodsItemModel(), this);
        mPresenter.getGoodsItemPageInfo("商品");

        initBanner();

        binding.scrollGoodItem.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                int i = binding.viewGoodTop.getMeasuredHeight() - binding.tabGoodItem.getMeasuredHeight()
                        - binding.llGoodItemTab.getMeasuredHeight() - binding.viewGoodTop1.getMeasuredHeight() - 10;
                Log.d("adsawa", "onScrollChange: " + scrollY);
                if (scrollY >= i) {
                    int color = Color.argb(255, 255, 255, 255);
                    binding.llGoodItemTab.setAlpha(1);
                    binding.viewGoodTop1.setAlpha(1);
                    binding.tabGoodItem.setAlpha(1);
                } else {
                    int alpha = (int) (255 * ((float) scrollY / i));
                    int color = Color.argb(alpha, 255, 255, 255);
                    binding.llGoodItemTab.setAlpha(alpha / 255f);
                    binding.viewGoodTop1.setAlpha(alpha / 255f);
                    binding.tabGoodItem.setAlpha(alpha / 255f);
                }
            }
        });

        binding.tabGoodItem.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0: // 假设Int_ZERO对应0
                        binding.scrollGoodItem.smoothScrollTo(0, 0);
                        break;
                    case 1: // 假设Int_ONE对应1
                        binding.scrollGoodItem.smoothScrollTo(0, 1480);
                        break;
                    case 2: // 假设Int_TWO对应2
                        binding.scrollGoodItem.smoothScrollTo(0, 2450);
                        break;
                    case 3:
                        binding.scrollGoodItem.smoothScrollTo(0, 4644);
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        binding.scrollGoodItem.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                if (scrollY > 0 && scrollY < 1400) {
                    binding.tabGoodItem.setScrollPosition(0, 0f, true);
                } else if (scrollY >= 1480 && scrollY < 2400) {
                    binding.tabGoodItem.setScrollPosition(1, 0f, true);
                } else if (scrollY >= 2450 && scrollY < 4600) {
                    binding.tabGoodItem.setScrollPosition(2, 0f, true);
                } else if (scrollY > 4644) {
                    binding.tabGoodItem.setScrollPosition(3, 0f, true);
                }
            }
        });
    }

    private void initBanner() {
        List<PicBean> list = new ArrayList<>();
        list.add(new PicBean(R.drawable.nailong_gooditem1));
        list.add(new PicBean(R.drawable.nailong_goodsitem2));
        list.add(new PicBean(R.drawable.nailong_goodsitem3));
        list.add(new PicBean(R.drawable.nailong_goodsitem4));

        binding.bannerGoodItem.setAdapter(new BannerAdapter(list))
                .addBannerLifecycleObserver(this)
                .setIndicator(new CircleIndicator(this));
    }

    @Override
    public void setPresenter(IGoodsItemPageContract.IGoodsItemPagePresenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showGoodsItemPageInfomation(GoodsItemInfo GoodsItemInfo) {

    }

    @Override
    public void showError() {

    }

    @Override
    public boolean isActive() {
        return false;
    }
}