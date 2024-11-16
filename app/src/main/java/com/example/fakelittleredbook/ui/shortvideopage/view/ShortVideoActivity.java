package com.example.fakelittleredbook.ui.shortvideopage.view;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.media3.ui.PlayerView;
import androidx.viewpager2.widget.ViewPager2;

import com.example.fakelittleredbook.R;
import com.example.fakelittleredbook.databinding.ActivityShortVideoBinding;
import com.example.fakelittleredbook.ui.shortvideopage.contract.IShortVideoPageContract;
import com.example.fakelittleredbook.ui.shortvideopage.model.ShortVideoInfo;
import com.example.fakelittleredbook.ui.shortvideopage.model.ShortVideoModel;
import com.example.fakelittleredbook.ui.shortvideopage.presenter.ShortVideoPresenter;
import com.example.fakelittleredbook.ui.shortvideopage.view.adapters.VideoPagerAdapter;
import com.example.fakelittleredbook.utils.VideoPlayManager;
import com.example.fakelittleredbook.utils.VideoPlayTask;

import java.util.List;

public class ShortVideoActivity extends AppCompatActivity implements IShortVideoPageContract.IShortVideoPageView {

    private ActivityShortVideoBinding binding;
    private IShortVideoPageContract.IShortVideoPagePresenter mPresenter;
    private VideoPagerAdapter videoPagerAdapter;
    private MyDialogFragment myDialogFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityShortVideoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ShortVideoModel shortVideoModel = new ShortVideoModel();
        ShortVideoPresenter shortVideoPresenter = new ShortVideoPresenter(shortVideoModel, this);
        this.setPresenter(shortVideoPresenter);

        mPresenter.getShortVideoPageInfo("小红书视频");
        myDialogFragment = new MyDialogFragment(this);
    }


    @Override
    public void setPresenter(IShortVideoPageContract.IShortVideoPagePresenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showShortVideoPageInfomation(List<ShortVideoInfo> ShortVedioInfo) {
        videoPagerAdapter = new VideoPagerAdapter(this);
        videoPagerAdapter.setDataList(VideoPlayManager.buildTestVideoUrls());
        binding.vpShortVideo.setOrientation(ViewPager2.ORIENTATION_VERTICAL);

        binding.vpShortVideo.setAdapter(videoPagerAdapter);

        binding.vpShortVideo.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);

                View itemView = binding.vpShortVideo.findViewWithTag(position);
                PlayerView simpleExoPlayerView = itemView.findViewById(R.id.play_view);
                Log.d("Video_Play_TAG", "onPageSelected: 获取到" + position + "位置的播放器");
                VideoPlayManager.getInstance(getApplicationContext())
                        .setCurVideoPlayTask(new VideoPlayTask(simpleExoPlayerView, videoPagerAdapter.getUrlByPos(position)));
                Log.d("Video_Play_TAG", "onPageSelected: " +  videoPagerAdapter.getUrlByPos(position));

                if(true) {
                    VideoPlayManager.getInstance(getApplicationContext()).startPlay();
                    Log.d("Video_Play_TAG", "onPageSelected: 开始播放");
                }

                ImageButton imageButton = itemView.findViewById(R.id.ibtn_comments);
                imageButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        myDialogFragment.show(getSupportFragmentManager(), "dialog");
                    }
                });
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });
    }

    @Override
    public void showError() {
    }

    @Override
    public boolean isActive() {
        return true;
    }
}