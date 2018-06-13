package com.example.tinderlike.Activities;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;


import com.example.tinderlike.Fragments.MatchesFragment;
import com.example.tinderlike.Fragments.ProfileFragment;
import com.example.tinderlike.Fragments.SettingsFragment;
import com.example.tinderlike.R;
import com.example.tinderlike.ViewPagerAdapter;


public class MultiTabActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private AppBarLayout appBarLayout;
    private ViewPager viewPager;
    private int[] tabIcons = {
            R.drawable.ic_action_profile,
            R.drawable.ic_action_match,
            R.drawable.ic_action_settings
    };

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_tab);
        tabLayout = findViewById(R.id.tabs);
        appBarLayout = findViewById(R.id.appbar);
        viewPager = findViewById(R.id.viewpager);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        //Adding The Fragments
        adapter.AddFragment(new ProfileFragment(),"Profile");
        adapter.AddFragment(new MatchesFragment(),"Matches");
        adapter.AddFragment(new SettingsFragment(),"Settings");

        //Adapter Setup
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();

    }

    private void setupTabIcons() {
        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
        tabLayout.getTabAt(2).setIcon(tabIcons[2]);
    }

}