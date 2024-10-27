package com.example.fakelittleredbook.utils;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class ActivityUtils {
    public static void replaceFragmentToActivity(FragmentManager fragmentManager,
                                             Fragment fragment,int frameId) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(frameId,fragment);
        fragmentTransaction.commit();
    }
}
