package com.example.tinderlike.Fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.tinderlike.Constants;
import com.example.tinderlike.R;


public class ProfileFragment extends Fragment {
    View v;

    private TextView nameTextView;
    private TextView ageTextView;
    private TextView occupationTextView;
    private TextView educationTextView;
    private TextView summaryTextView;

    public ProfileFragment() {
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_profile, container, false);
        nameTextView = v.findViewById(R.id.name);
        ageTextView = v.findViewById(R.id.age);
        occupationTextView = v.findViewById(R.id.occupation);
        educationTextView = v.findViewById(R.id.education);
        summaryTextView = v.findViewById(R.id.summary);

        Bundle Extra = getActivity().getIntent().getExtras();
        if(Extra != null){
            String name = Extra.getString(Constants.KEY_NAME);
            int age = Extra.getInt(Constants.KEY_AGE);
            String occupation = Extra.getString(Constants.KEY_OCCUPATION);
            String education = Extra.getString(Constants.KEY_EDUCATION);
            String summary = Extra.getString(Constants.KEY_SUMMARY);

            nameTextView.setText(name);
            ageTextView.setText(""+ age);
            occupationTextView.setText(""+ occupation);
            educationTextView.setText(""+ education);
            summaryTextView.setText("" + summary);

        }

        return v;
    }
}
