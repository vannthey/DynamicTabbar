package com.example.dynamictapbar;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dynamictapbar.databinding.ActivityMainBinding;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        assert getSupportActionBar()!=null;
        getSupportActionBar().hide();
        setContentView(binding.getRoot());

        binding.btnAddTabBar.setOnClickListener(v->{
            binding.tabLayout.addTab(binding.tabLayout.newTab().setText(binding.textItem.getText().toString()));
            binding.textItem.setText("");
        });

        binding.tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                binding.tapSection.setText(String.valueOf(tab.getPosition()+1));

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}