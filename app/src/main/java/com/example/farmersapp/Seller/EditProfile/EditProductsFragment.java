package com.example.farmersapp.Seller.EditProfile;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.farmersapp.R;
import com.example.farmersapp.Seller.DashboardFragments.SellerHomeFragment;

public class EditProductsFragment extends Fragment {
    public static EditProductsFragment newInstance() {
        EditProductsFragment fragment = new EditProductsFragment();
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_edit_products, container, false);
    }
}