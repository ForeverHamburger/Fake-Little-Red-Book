package com.example.fakelittleredbook.ui.notepage.view;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fakelittleredbook.R;
import com.example.fakelittleredbook.databinding.ActivityNotePageBinding;
import com.example.fakelittleredbook.ui.notepage.contract.INotePageContract;
import com.example.fakelittleredbook.ui.notepage.model.NoteInfo;
import com.example.fakelittleredbook.ui.notepage.model.NotePageModel;
import com.example.fakelittleredbook.ui.notepage.model.PicBean;
import com.example.fakelittleredbook.ui.notepage.presenter.NotePagePresenter;
import com.example.fakelittleredbook.ui.notepage.view.adapters.BannerAdapter;
import com.example.fakelittleredbook.ui.shortvideopage.contract.IShortVideoPageContract;
import com.example.fakelittleredbook.ui.shortvideopage.model.CommentsInfo;
import com.example.fakelittleredbook.ui.shortvideopage.view.adapters.CommentsAdapter;
import com.youth.banner.indicator.CircleIndicator;

import java.util.ArrayList;
import java.util.List;

public class NotePageActivity extends AppCompatActivity implements INotePageContract.INotePageView {

    private ActivityNotePageBinding binding;
    private INotePageContract.INotePagePresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityNotePageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        mPresenter = new NotePagePresenter(new NotePageModel(),this);
        mPresenter.getNotePageInfo("笔记");


    }

    @Override
    public void setPresenter(INotePageContract.INotePagePresenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showNotePageInfomation(NoteInfo noteInfos) {
        List<PicBean> list = new ArrayList<>();
        list.add(new PicBean(R.drawable.nailong3));
        list.add(new PicBean(R.drawable.nailong_dance));
        list.add(new PicBean(R.drawable.pic_nailong1));
        list.add(new PicBean(R.drawable.pic_nailong_shopitem2));

        binding.bannerNotePage.setAdapter(new BannerAdapter(list))
                .addBannerLifecycleObserver(this)
                .setIndicator(new CircleIndicator(this));

        initRecyclerView(binding.getRoot());
    }

    private void initRecyclerView(View view) {
        RecyclerView recyclerView = view.findViewById(R.id.rv_note_comments);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        List<CommentsInfo> commentsInfoList = new ArrayList<>();

        commentsInfoList.add(new CommentsInfo("奶龙", "你们奶龙真的，我哭死","24",R.drawable.nailong3));
        commentsInfoList.add(new CommentsInfo("奶龙老师", "哪个班的奶龙还在说话,从现在开始，说话的奶龙一律站到外面去","23",R.drawable.nailong_dance));
        commentsInfoList.add(new CommentsInfo("奶龙大王", "我才是奶龙","241",R.drawable.icon_nailong1));
        commentsInfoList.add(new CommentsInfo("奶龙小王", "哥谭市的大BOSSSSSSSS","14",R.drawable.pic_nailong1));
        commentsInfoList.add(new CommentsInfo("奶龙小兵", "今天也要加油鸭！", "35", R.drawable.nailong3));
        commentsInfoList.add(new CommentsInfo("奶龙勇士", "冲鸭！向着胜利前进！", "47", R.drawable.nailong_dance));
        commentsInfoList.add(new CommentsInfo("奶龙学者", "知识就是力量！", "56", R.drawable.icon_nailong1));
        commentsInfoList.add(new CommentsInfo("奶龙探险家", "世界那么大，我想去看看", "68", R.drawable.pic_nailong1));
        commentsInfoList.add(new CommentsInfo("奶龙音乐家", "音符是最美的语言", "78", R.drawable.pic_nailong_shopitem1));

        CommentsAdapter commentsAdapter = new CommentsAdapter(commentsInfoList,this);
        recyclerView.setAdapter(commentsAdapter);
    }

    @Override
    public void showError() {

    }

    @Override
    public boolean isActive() {
        return true;
    }
}