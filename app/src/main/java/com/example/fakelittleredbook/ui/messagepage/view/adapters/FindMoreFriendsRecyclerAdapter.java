package com.example.fakelittleredbook.ui.messagepage.view.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fakelittleredbook.R;
import com.example.fakelittleredbook.ui.messagepage.model.MessageInfo;

import java.util.List;

public class FindMoreFriendsRecyclerAdapter extends RecyclerView.Adapter<FindMoreFriendsRecyclerAdapter.FindMoreFriendsViewHolder> {

    private FindMoreFriendsViewHolder viewHolder;
    private List<MessageInfo> messageInfoList;

    public FindMoreFriendsRecyclerAdapter(List<MessageInfo> messageInfoList) {
        this.messageInfoList = messageInfoList;
    }

    public class FindMoreFriendsViewHolder extends RecyclerView.ViewHolder {
        ImageView ivIcon;
        TextView tvTitle;
        TextView tvSimpleMessage;
        public FindMoreFriendsViewHolder(@NonNull View itemView) {
            super(itemView);
            ivIcon = itemView.findViewById(R.id.iv_fmf_icon);
            tvTitle = itemView.findViewById(R.id.tv_fmf_title);
            tvSimpleMessage = itemView.findViewById(R.id.tv_fmf_simple);
        }
    }
    @NonNull
    @Override
    public FindMoreFriendsRecyclerAdapter.FindMoreFriendsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_find_more_friends_item, parent, false);
        viewHolder = new FindMoreFriendsViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FindMoreFriendsRecyclerAdapter.FindMoreFriendsViewHolder holder, int position) {
        holder.ivIcon.setImageResource(messageInfoList.get(position).getIcon());
        holder.tvTitle.setText(messageInfoList.get(position).getTitle());
        holder.tvSimpleMessage.setText(messageInfoList.get(position).getSimpleMessage());
    }

    @Override
    public int getItemCount() {
        return messageInfoList == null ? 0 : messageInfoList.size();
    }


}
