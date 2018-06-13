package com.example.tinderlike.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.tinderlike.R;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void click_sign_in(View v)
    {
        Intent i = new Intent(MainActivity.this,LoginActivity.class);
        startActivity(i);

    }

    public void click_sign_up(View v)
    {
        Intent i = new Intent(MainActivity.this,SignUpActivity.class);
        startActivity(i);

    }
}