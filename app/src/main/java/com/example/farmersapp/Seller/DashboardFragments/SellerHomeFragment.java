package com.example.farmersapp.Seller.DashboardFragments;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.farmersapp.R;
import com.example.farmersapp.Seller.EditProfile.EditProductsFragment;
import com.example.farmersapp.Utilities.FragmentHelper;
import com.example.farmersapp.databinding.ActivitySellerDashboardBinding;
import com.example.farmersapp.databinding.FragmentSellerHomeBinding;
import com.google.android.material.navigation.NavigationBarView;

public class SellerHomeFragment extends Fragment {

    FragmentSellerHomeBinding binding;
    private FragmentHelper fragmentHelper;
    public static SellerHomeFragment newInstance() {
        SellerHomeFragment fragment = new SellerHomeFragment();
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding= FragmentSellerHomeBinding.inflate(inflater, container, false);
        binding.labelEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentHelper.replaceFragment(EditProductsFragment.newInstance() , R.id.frame_layout);
            }
        });

        return binding.getRoot();


    }
}