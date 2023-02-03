package com.example.dynamictapbar;

import android.os.Bundle;
import android.widget.Toast;

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
            if (binding.textItem.getText().toString().equals("")){
                Toast.makeText(this, "Please Write Some Text", Toast.LENGTH_SHORT).show();
            }else {
                binding.tabLayout.addTab(binding.tabLayout.newTab().setText(binding.textItem.getText().toString()));
                binding.textItem.setText("");
            }
        });

        binding.tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                binding.tapSection.setText(tab.getText().toString());

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