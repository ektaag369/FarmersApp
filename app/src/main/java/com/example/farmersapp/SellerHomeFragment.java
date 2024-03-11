package com.example.farmersapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class SellerHomeFragment extends Fragment {
    public static SellerHomeFragment newInstance() {
        SellerHomeFragment fragment = new SellerHomeFragment();
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_seller_home, container, false);
    }
}