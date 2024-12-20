package com.example.fakelittleredbook.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.fakelittleredbook.R;
import com.example.fakelittleredbook.databinding.ActivityPageContainerBinding;
import com.example.fakelittleredbook.ui.homepage.view.PageContainerFragment;
import com.example.fakelittleredbook.ui.messagepage.model.MessagePageModel;
import com.example.fakelittleredbook.ui.messagepage.presenter.MessagePagePresenter;
import com.example.fakelittleredbook.ui.messagepage.view.MessageFragment;
import com.example.fakelittleredbook.ui.mypage.view.MyPageFragment;
import com.example.fakelittleredbook.ui.shoppage.model.ShopPageModel;
import com.example.fakelittleredbook.ui.shoppage.presenter.ShopPagePresenter;
import com.example.fakelittleredbook.ui.shoppage.view.ShoppingFragment;
import com.example.fakelittleredbook.ui.shortvideopage.model.ShortVideoModel;
import com.example.fakelittleredbook.ui.shortvideopage.presenter.ShortVideoPresenter;
import com.example.fakelittleredbook.ui.shortvideopage.view.ShortVideoActivity;
import com.example.fakelittleredbook.utils.ActivityUtils;
import com.google.android.material.tabs.TabLayout;

public class PageContainerActivity extends AppCompatActivity {

    private static final String TAG = "HomePageActivity";
    private ActivityPageContainerBinding binding;
    private PageContainerFragment pageContainerFragment;
    private MessageFragment messageFragment;
    private MyPageFragment myPageFragment;
    private ShoppingFragment shoppingFragment;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityPageContainerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // 首页界面依赖注入
        pageContainerFragment = new PageContainerFragment();

        // 消息页面依赖注入
        messageFragment = new MessageFragment();
        MessagePageModel messagePageModel = new MessagePageModel();
        MessagePagePresenter messagePagePresenter = new MessagePagePresenter(messageFragment, messagePageModel);
        messageFragment.setPresenter(messagePagePresenter);

        // 我的页面依赖注入
        myPageFragment = new MyPageFragment();

        // 购物界面依赖注入
        shoppingFragment = new ShoppingFragment();
        ShopPageModel shopPageModel = new ShopPageModel();
        ShopPagePresenter shopPagePresenter = new ShopPagePresenter(shopPageModel, shoppingFragment);
        shoppingFragment.setPresenter(shopPagePresenter);

        //初次进入界面，默认展示首页
        ActivityUtils.replaceFragmentToActivity(getSupportFragmentManager(), pageContainerFragment, R.id.fragment_container_view_tag);

        String fragment = "";
        fragment = getIntent().getStringExtra("fragment");
        if (fragment != null && fragment.equals(MyPageFragment.class.getName())) {
            ActivityUtils.replaceFragmentToActivity(getSupportFragmentManager(), myPageFragment, R.id.fragment_container_view_tag);
        }

        binding.bottomTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                CharSequence text = tab.getText();
                if (text.equals("首页")) {
                    Toast.makeText(PageContainerActivity.this, "首页", Toast.LENGTH_SHORT).show();
                    ActivityUtils.replaceFragmentToActivity(getSupportFragmentManager(), pageContainerFragment, R.id.fragment_container_view_tag);
                } else if (text.equals("购物")) {
                    Toast.makeText(PageContainerActivity.this, "购物", Toast.LENGTH_SHORT).show();
                    ActivityUtils.replaceFragmentToActivity(getSupportFragmentManager(), shoppingFragment, R.id.fragment_container_view_tag);
                } else if (text.equals("消息")) {
                    Toast.makeText(PageContainerActivity.this, "消息", Toast.LENGTH_SHORT).show();
                    ActivityUtils.replaceFragmentToActivity(getSupportFragmentManager(), messageFragment, R.id.fragment_container_view_tag);
                } else {
                    Toast.makeText(PageContainerActivity.this, "我", Toast.LENGTH_SHORT).show();
                    ActivityUtils.replaceFragmentToActivity(getSupportFragmentManager(), myPageFragment, R.id.fragment_container_view_tag);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });

        binding.ibtnPublish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PageContainerActivity.this, ShortVideoActivity.class);
                startActivity(intent);
            }
        });
    }
}