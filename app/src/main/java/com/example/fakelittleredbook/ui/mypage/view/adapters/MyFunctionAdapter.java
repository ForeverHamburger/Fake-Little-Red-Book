package com.example.fakelittleredbook.ui.mypage.view.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fakelittleredbook.R;

import java.util.List;

public class MyFunctionAdapter extends RecyclerView.Adapter<MyFunctionAdapter.MyFunctionViewHolder> {
    private static final String TAG = "MyFunctionAdapter";
    private List<String> mFunctions;
    private List<String> mDiscriptions;
    public MyFunctionAdapter(List<String> functions,List<String> discriptions) {
        mFunctions = functions;
        mDiscriptions = discriptions;
    }

    @NonNull
    @Override
    public MyFunctionAdapter.MyFunctionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_my_functions_item, parent, false);
        MyFunctionViewHolder myFunctionViewHolder = new MyFunctionViewHolder(view);
        return myFunctionViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyFunctionAdapter.MyFunctionViewHolder holder, int position) {
        holder.functionTitle.setText(mFunctions.get(position));
        holder.functionDiscription.setText(mDiscriptions.get(position));
    }

    @Override
    public int getItemCount() {
        return mFunctions == null ? 0 : mFunctions.size();
    }

    public class MyFunctionViewHolder extends RecyclerView.ViewHolder{
        TextView functionTitle;
        TextView functionDiscription;

        public MyFunctionViewHolder(@NonNull View itemView) {
            super(itemView);
            functionTitle = itemView.findViewById(R.id.tv_function_title);
            functionDiscription = itemView.findViewById(R.id.tv_function_simple);
        }
    }
}
