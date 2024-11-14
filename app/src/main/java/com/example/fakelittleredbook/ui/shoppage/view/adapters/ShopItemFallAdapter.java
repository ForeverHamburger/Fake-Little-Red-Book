package com.example.fakelittleredbook.ui.shoppage.view.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fakelittleredbook.R;
import com.example.fakelittleredbook.ui.goodsitempage.view.GoodsItemActivity;
import com.example.fakelittleredbook.ui.shoppage.model.ShopItemInfo;

import java.util.List;

public class ShopItemFallAdapter extends RecyclerView.Adapter<ShopItemFallAdapter.ShopItemViewHolder> {
    private List<ShopItemInfo> shopItemInfoList;
    private Context mContext;

    public ShopItemFallAdapter(List<ShopItemInfo> shopItemInfoList, Context context) {
        this.shopItemInfoList = shopItemInfoList;
        this.mContext = context;
    }

    @NonNull
    @Override
    public ShopItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_shopping_item, parent, false);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, GoodsItemActivity.class);
                mContext.startActivity(intent);
            }
        });

        return new ShopItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ShopItemViewHolder holder, int position) {
        holder.shopItemIcon.setImageResource(shopItemInfoList.get(position).getItemPicture());
        holder.shopItemName.setText(shopItemInfoList.get(position).getItemName());
        holder.discountedPrice.setText(shopItemInfoList.get(position).getDiscountedPrice());
        holder.shoppingPrice.setText(shopItemInfoList.get(position).getPrice());
        holder.salesVolume.setText(shopItemInfoList.get(position).getSalesVolume());

        holder.shoppingPrice.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
    }

    @Override
    public int getItemCount() {
        return shopItemInfoList == null ? 0 : shopItemInfoList.size();
    }

    public class ShopItemViewHolder extends RecyclerView.ViewHolder {
        ImageView shopItemIcon;
        TextView shopItemName;
        TextView discountedPrice;
        TextView shoppingPrice;
        TextView salesVolume;

        public ShopItemViewHolder(@NonNull View itemView) {
            super(itemView);
            shopItemIcon = itemView.findViewById(R.id.iv_shopping_item_icon);
            shopItemName = itemView.findViewById(R.id.tv_shopping_item_name);
            discountedPrice = itemView.findViewById(R.id.tv_shopping_discounted_price);
            shoppingPrice = itemView.findViewById(R.id.tv_shopping_price);
            salesVolume = itemView.findViewById(R.id.tv_sales_volume);
        }
    }
}
