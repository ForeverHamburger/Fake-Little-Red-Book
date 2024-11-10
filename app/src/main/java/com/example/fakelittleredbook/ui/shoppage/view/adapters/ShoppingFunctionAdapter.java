package com.example.fakelittleredbook.ui.shoppage.view.adapters;

import android.health.connect.datatypes.StepsRecord;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fakelittleredbook.R;

import java.util.List;

public class ShoppingFunctionAdapter extends RecyclerView.Adapter<ShoppingFunctionAdapter.ViewHolder> {
    private List<Integer> imageList;
    private List<String> functionList;

    public ShoppingFunctionAdapter(List<Integer> imageList, List<String> functionList) {
        this.imageList = imageList;
        this.functionList = functionList;
    }

    @NonNull
    @Override
    public ShoppingFunctionAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_shopping_functions_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ShoppingFunctionAdapter.ViewHolder holder, int position) {
        holder.imageView.setImageResource(imageList.get(position));
        holder.textView.setText(functionList.get(position));
    }

    @Override
    public int getItemCount() {
        return functionList == null ? 0 : functionList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_shopping_function_title);
            imageView = itemView.findViewById(R.id.iv_shopping_function_icon);
        }
    }
}
