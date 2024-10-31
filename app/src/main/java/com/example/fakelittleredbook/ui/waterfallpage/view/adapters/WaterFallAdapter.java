package com.example.fakelittleredbook.ui.waterfallpage.view.adapters;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fakelittleredbook.R;
import com.example.fakelittleredbook.ui.waterfallpage.model.WaterFallInfo;

import java.util.List;

public class WaterFallAdapter extends RecyclerView.Adapter<WaterFallAdapter.ViewHolder> {
    private static final String TAG = "WaterFallAdapter";
    private List<WaterFallInfo> mWaterFallInfoList;
    public WaterFallAdapter(List<WaterFallInfo> mWaterFallInfoList) {
        this.mWaterFallInfoList = mWaterFallInfoList;
    }
    @NonNull
    @Override
    public WaterFallAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(), R.layout.recycler_waterfall_item, null);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull WaterFallAdapter.ViewHolder holder, int position) {
        WaterFallInfo info = mWaterFallInfoList.get(position);
        holder.picture.setImageResource(info.getImageResource());
        holder.title.setText(info.getTitle());
        holder.userIcon.setImageResource(info.getHeadImage());
        holder.userName.setText(info.getUserName());
        holder.loveCount.setText(info.getLoveCount());
        holder.loveIcon.setImageResource(R.drawable.icon_love);
    }

    @Override
    public int getItemCount() {
        return mWaterFallInfoList == null ? 0 : mWaterFallInfoList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView picture;
        TextView title;
        ImageView userIcon;
        TextView userName;
        ImageView loveIcon;
        TextView loveCount;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            picture = itemView.findViewById(R.id.iv_waterfall_icon);
            title = itemView.findViewById(R.id.tv_waterfall_title);

            userIcon = itemView.findViewById(R.id.iv_waterfall_user_icon);
            userName = itemView.findViewById(R.id.tv_waterfall_user_name);

            loveIcon = itemView.findViewById(R.id.iv_wf_love_icon);
            loveCount = itemView.findViewById(R.id.tv_wf_love_count);
        }
    }
}
