package com.example.farmersapp.Seller.DashboardFragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.farmersapp.R;

public class SellerMoneyFragment extends Fragment {
    public static SellerMoneyFragment newInstance() {
        SellerMoneyFragment fragment = new SellerMoneyFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_seller_money, container, false);
    }
}