package com.example.tinderlike;

import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

public class MultiTabActivity extends AppCompatActivity {


    private TabLayout tabLayout;
    private AppBarLayout appBarLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_tab);
        tabLayout = findViewById(R.id.tabLayout_id);
        appBarLayout = findViewById(R.id.appbarid);
        viewPager = findViewById(R.id.viewpager_id);
        ViewerPagerAdapter adapter = new ViewerPagerAdapter(getSupportFragmentManager());

        //Adding Fragments
        adapter.AddFragment(new Fragment(), "Profile");
        adapter.AddFragment(new Fragment(), "Matches");
        adapter.AddFragment(new Fragment(), "Settings");

        //adapter Setup
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
