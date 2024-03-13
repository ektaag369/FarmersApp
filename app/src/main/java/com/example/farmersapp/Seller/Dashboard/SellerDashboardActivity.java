package com.example.farmersapp.Seller.Dashboard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.farmersapp.R;
import com.example.farmersapp.Seller.DashboardFragments.SellerHomeFragment;
import com.example.farmersapp.Seller.DashboardFragments.SellerLogoutFragment;
import com.example.farmersapp.Seller.DashboardFragments.SellerMoneyFragment;
import com.example.farmersapp.Seller.DashboardFragments.SellerStatisticsFragment;
import com.example.farmersapp.Utilities.FragmentHelper;
import com.example.farmersapp.databinding.ActivitySellerDashboardBinding;
import com.google.android.material.navigation.NavigationBarView;

public class SellerDashboardActivity extends AppCompatActivity {

    ActivitySellerDashboardBinding binding;
    private FragmentHelper fragmentHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding= DataBindingUtil.setContentView(this, R.layout.activity_seller_dashboard);

        fragmentHelper = new FragmentHelper(this);

        binding.bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                handleFragmentSelection(item);
                return true;
            }
        });
        fragmentHelper.replaceFragment(SellerHomeFragment.newInstance() , R.id.frame_layout);
        setItemColors(binding.bottomNavigationView.getMenu().getItem(0));
    }

    private void handleFragmentSelection(MenuItem item) {
        if (item.getItemId() == R.id.home) {
            fragmentHelper.replaceFragment(SellerHomeFragment.newInstance(), R.id.frame_layout);
        } else if (item.getItemId() == R.id.insights) {
            fragmentHelper.replaceFragment(SellerStatisticsFragment.newInstance(), R.id.frame_layout);
        } else if (item.getItemId() == R.id.money) {
            fragmentHelper.replaceFragment(SellerMoneyFragment.newInstance(), R.id.frame_layout);
        } else if (item.getItemId() == R.id.logout) {
            fragmentHelper.replaceFragment(SellerLogoutFragment.newInstance(), R.id.frame_layout);
        }
        setItemColors(item);
    }

    private void setItemColors(MenuItem selectedItem) {
        int selectedColor = getResources().getColor(R.color.orange);
        int defaultColor = getResources().getColor(R.color.white);

        // Set text color
       // bottomNavigationView.setItemTextColor(createColorStateList(selectedItem, selectedColor, defaultColor));

        // Set icon color
        binding.bottomNavigationView.setItemIconTintList(createColorStateList(selectedItem, selectedColor, defaultColor));
    }

    private ColorStateList createColorStateList(MenuItem selectedItem, int selectedColor, int defaultColor) {
        int[][] states = new int[][]{
                new int[]{android.R.attr.state_checked},  // checked
                new int[]{-android.R.attr.state_checked}  // unchecked
        };
        int[] colors = new int[]{
                selectedColor,
                defaultColor
        };
        return new ColorStateList(states, colors);
    }
}