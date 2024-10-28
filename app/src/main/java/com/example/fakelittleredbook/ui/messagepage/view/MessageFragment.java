package com.example.fakelittleredbook.ui.messagepage.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import com.example.fakelittleredbook.R;
import com.example.fakelittleredbook.databinding.FragmentMessageBinding;
import com.example.fakelittleredbook.ui.messagepage.contract.IMessagePageContract;
import com.example.fakelittleredbook.ui.messagepage.model.MessageInfo;
import com.example.fakelittleredbook.ui.messagepage.view.adapters.FindMoreFriendsRecyclerAdapter;
import com.example.fakelittleredbook.ui.messagepage.view.adapters.MessageRecyclerAdapter;

import java.util.List;

public class MessageFragment extends Fragment implements IMessagePageContract.IMessagePageView {
    private IMessagePageContract.IMessagePagePresenter mPresenter;
    private FragmentMessageBinding binding;

    public MessageFragment() {

    }

    public static MessageFragment newInstance() {
        return new MessageFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMessageBinding.inflate(inflater);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter.getMessageInfo("把数据给我");


        binding.messageScroll.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                int i = binding.messageScroll.getChildAt(0).getMeasuredHeight()
                        - binding.llFindMoreFriends.getHeight()
                        - binding.llFindMoreFriends.getHeight()
                        - binding.rvFindMoreFriends.getHeight()
                        - binding.llFmfBottom.getHeight();
                if (scrollY >= i) {
                    binding.hideLlFindMoreFriends.setVisibility(View.VISIBLE);
                } else {
                    binding.hideLlFindMoreFriends.setVisibility(View.GONE);
                }
            }
        });
    }

    @Override
    public void setPresenter(IMessagePageContract.IMessagePagePresenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showMessage(List<MessageInfo> messageList,List<MessageInfo> fmfList) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
                MessageRecyclerAdapter adapter = new MessageRecyclerAdapter(messageList);
                binding.rvMessage.setLayoutManager(layoutManager);
                binding.rvMessage.setAdapter(adapter);

                LinearLayoutManager layoutManager1 = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
                FindMoreFriendsRecyclerAdapter adapter1 = new FindMoreFriendsRecyclerAdapter(fmfList);
                binding.rvFindMoreFriends.setLayoutManager(layoutManager1);
                binding.rvFindMoreFriends.setAdapter(adapter1);
            }
        });
    }

    @Override
    public void showError() {

    }

    @Override
    public boolean isActive() {
        return true;
    }
}