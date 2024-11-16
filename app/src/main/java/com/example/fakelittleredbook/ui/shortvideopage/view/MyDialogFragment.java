package com.example.fakelittleredbook.ui.shortvideopage.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fakelittleredbook.R;
import com.example.fakelittleredbook.ui.shortvideopage.model.CommentsInfo;
import com.example.fakelittleredbook.ui.shortvideopage.view.adapters.CommentsAdapter;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.ArrayList;
import java.util.List;

public class MyDialogFragment extends BottomSheetDialogFragment {
    private Context mContext;
    public MyDialogFragment(Context context) {
        this.mContext = context;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(STYLE_NORMAL, R.style.MyBottomSheetDialog);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dialog_bottom, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getDialog().getWindow().setBackgroundDrawableResource(R.color.color_black_0);

        getDialog().getWindow().setDimAmount(0f);
        getDialog().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE | WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        initRecyclerView(view);

        EditText comments = view.findViewById(R.id.et_comments);
    }

    private void initRecyclerView(View view) {
        RecyclerView recyclerView = view.findViewById(R.id.rv_comments);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
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

        CommentsAdapter commentsAdapter = new CommentsAdapter(commentsInfoList,getActivity());
        recyclerView.setAdapter(commentsAdapter);
    }
}
