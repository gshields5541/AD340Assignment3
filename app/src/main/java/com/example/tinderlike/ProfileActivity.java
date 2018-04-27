package com.example.tinderlike;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    private TextView nameTextView;
    private TextView ageTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        nameTextView = findViewById(R.id.textView2);
        ageTextView = findViewById(R.id.age);

        Bundle Extra = getIntent().getExtras();
        if(Extra != null) {
            String name = Extra.getString(Constants.NAME);
            int age = Extra.getInt(Constants.AGE);

            nameTextView.setText(name);
            ageTextView.setText(""+age);
        }

    }
}
