package com.example.fakelittleredbook.ui.messagepage.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fakelittleredbook.R;
import com.example.fakelittleredbook.ui.messagepage.contract.IMessagePageContract;
import com.example.fakelittleredbook.ui.messagepage.model.MessageInfo;

import java.util.List;

public class MessageFragment extends Fragment implements IMessagePageContract.IMessagePageView {
    private IMessagePageContract.IMessagePagePresenter mPresenter;

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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_message, container, false);
    }

    @Override
    public void setPresenter(IMessagePageContract.IMessagePagePresenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showMessage(List<MessageInfo> messageList) {

    }

    @Override
    public void showError() {

    }

    @Override
    public boolean isActive() {
        return false;
    }
}