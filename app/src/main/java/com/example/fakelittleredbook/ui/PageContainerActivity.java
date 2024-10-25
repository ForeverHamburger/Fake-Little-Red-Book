package com.example.fakelittleredbook.ui;

import android.os.Bundle;
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
import com.example.fakelittleredbook.ui.messagepage.view.MessageFragment;
import com.example.fakelittleredbook.ui.mypage.view.MyPageFragment;
import com.example.fakelittleredbook.ui.shoppage.view.ShoppingFragment;
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

        pageContainerFragment = new PageContainerFragment();
        messageFragment = new MessageFragment();
        myPageFragment = new MyPageFragment();
        shoppingFragment = new ShoppingFragment();

        //初次进入界面，默认展示首页
        loadFragment(pageContainerFragment);

        binding.bottomTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                CharSequence text = tab.getText();
                if (text.equals("首页")) {
                    Toast.makeText(PageContainerActivity.this, "首页", Toast.LENGTH_SHORT).show();
                    loadFragment(pageContainerFragment);
                } else if (text.equals("购物")) {
                    Toast.makeText(PageContainerActivity.this, "购物", Toast.LENGTH_SHORT).show();
                    loadFragment(shoppingFragment);
                } else if (text.equals("消息")) {
                    Toast.makeText(PageContainerActivity.this, "消息", Toast.LENGTH_SHORT).show();
                    loadFragment(messageFragment);
                } else {
                    Toast.makeText(PageContainerActivity.this, "我", Toast.LENGTH_SHORT).show();
                    loadFragment(myPageFragment);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
    }

    private void loadFragment(Fragment fragment) {
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container_view_tag, fragment)
                .addToBackStack(null)
                .commit();
    }
}