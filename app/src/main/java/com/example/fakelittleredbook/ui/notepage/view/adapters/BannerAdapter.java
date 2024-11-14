package com.example.fakelittleredbook.ui.notepage.view.adapters;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fakelittleredbook.ui.notepage.model.PicBean;

import java.util.List;

public class BannerAdapter extends com.youth.banner.adapter.BannerAdapter<PicBean, BannerAdapter.BannerViewHolder> {
    public BannerAdapter(List<PicBean> datas) {
        super(datas);
    }

    @Override
    public BannerAdapter.BannerViewHolder onCreateHolder(ViewGroup parent, int viewType) {
        ImageView imageView = new ImageView(parent.getContext());
        imageView.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return new BannerViewHolder(imageView);
    }

    @Override
    public void onBindView(BannerAdapter.BannerViewHolder holder, PicBean data, int position, int size) {
        ImageView imageView = holder.imageView;
        imageView.setImageResource(data.getPicture());
    }

    public class BannerViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        public BannerViewHolder(@NonNull View itemView) {
            super(itemView);
            this.imageView = (ImageView) itemView;
        }
    }
}
