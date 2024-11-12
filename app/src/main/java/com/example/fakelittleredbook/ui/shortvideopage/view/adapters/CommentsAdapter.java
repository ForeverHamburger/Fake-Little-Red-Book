package com.example.fakelittleredbook.ui.shortvideopage.view.adapters;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fakelittleredbook.R;
import com.example.fakelittleredbook.ui.PageContainerActivity;
import com.example.fakelittleredbook.ui.mypage.view.MyPageFragment;
import com.example.fakelittleredbook.ui.shortvideopage.model.CommentsInfo;

import java.util.List;

public class CommentsAdapter extends RecyclerView.Adapter<CommentsAdapter.ViewHolder> {
    private List<CommentsInfo> commentsInfoList;
    private Context mContext;

    public CommentsAdapter(List<CommentsInfo> commentsInfoList, Context context) {
        this.commentsInfoList = commentsInfoList;
        this.mContext = context;
    }

    @NonNull
    @Override
    public CommentsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_comment_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CommentsAdapter.ViewHolder holder, int position) {
        final boolean[] statusLove = {true};

        holder.tvCommentLikeCount.setText(commentsInfoList.get(position).getCommentLikeCount());
        holder.ivCommentIcon.setImageResource(commentsInfoList.get(position).getCommentIcon());
        holder.tvCommentsName.setText(commentsInfoList.get(position).getCommentName());
        holder.tvCommentsContent.setText(commentsInfoList.get(position).getCommentContext());

        holder.ivCommentLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (statusLove[0]) {
                    statusLove[0] = false;
                    holder.ivCommentLike.setImageResource(R.drawable.icon_love_empty);
                } else {
                    statusLove[0] = true;
                    holder.ivCommentLike.setImageResource(R.drawable.icon_love);
                }
            }
        });

        holder.ivCommentIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, PageContainerActivity.class);
                intent.putExtra("fragment", MyPageFragment.class.getName());
                mContext.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return commentsInfoList == null ? 0 : commentsInfoList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvCommentLikeCount;
        ImageView ivCommentIcon;
        ImageView ivCommentLike;
        TextView tvCommentsName;
        TextView tvCommentsContent;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvCommentLikeCount = itemView.findViewById(R.id.tv_comment_like_count);
            ivCommentIcon = itemView.findViewById(R.id.iv_comment_icon);
            ivCommentLike = itemView.findViewById(R.id.iv_comment_like);
            tvCommentsName = itemView.findViewById(R.id.tv_comments_name);
            tvCommentsContent = itemView.findViewById(R.id.tv_comments_content);
        }
    }
}
