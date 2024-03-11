package com.example.farmersapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class FragmentHelper {
    private FragmentManager fragmentManager;

    public FragmentHelper(AppCompatActivity activity) {
        fragmentManager = activity.getSupportFragmentManager();
    }

    public void replaceFragment(Fragment fragment, int containerId) {

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(containerId, fragment);
        transaction.commit();
    }
}
