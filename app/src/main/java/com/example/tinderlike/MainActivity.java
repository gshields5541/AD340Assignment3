package com.example.tinderlike;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.support.v4.app.Fragment;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void click_signin(View v)
    {
        Intent i = new Intent(MainActivity.this,LoginActivity.class);
        startActivity(i);

    }

    public void click_signup(View v)
    {
        Intent i = new Intent(MainActivity.this,SignUpActivity.class);
        startActivity(i);

    }
}