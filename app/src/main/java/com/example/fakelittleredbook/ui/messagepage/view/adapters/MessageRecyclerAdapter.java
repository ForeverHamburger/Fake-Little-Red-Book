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

public class MessageRecyclerAdapter extends RecyclerView.Adapter<MessageRecyclerAdapter.MessageViewHolder> {

    private MessageViewHolder viewHolder;
    private List<MessageInfo> messageInfoList;

    public MessageRecyclerAdapter(List<MessageInfo> messageInfoList) {
        this.messageInfoList = messageInfoList;
    }

    public class MessageViewHolder extends RecyclerView.ViewHolder {
        ImageView ivIcon;
        TextView tvTitle;
        TextView tvSimpleMessage;
        TextView tvDate;
        public MessageViewHolder(@NonNull View itemView) {
            super(itemView);
            ivIcon = itemView.findViewById(R.id.iv_message_icon);
            tvTitle = itemView.findViewById(R.id.tv_message_title);
            tvSimpleMessage = itemView.findViewById(R.id.tv_message_simple);
            tvDate = itemView.findViewById(R.id.tv_message_date);
        }
    }
    @NonNull
    @Override
    public MessageRecyclerAdapter.MessageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_message_item, parent, false);
        viewHolder = new MessageViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MessageRecyclerAdapter.MessageViewHolder holder, int position) {
        holder.ivIcon.setImageResource(messageInfoList.get(position).getIcon());
        holder.tvTitle.setText(messageInfoList.get(position).getTitle());
        holder.tvSimpleMessage.setText(messageInfoList.get(position).getSimpleMessage());
        holder.tvDate.setText(messageInfoList.get(position).getDate());
    }

    @Override
    public int getItemCount() {
        return messageInfoList == null ? 0 : messageInfoList.size();
    }
}
