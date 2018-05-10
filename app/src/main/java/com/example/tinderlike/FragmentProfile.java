package com.example.tinderlike;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class FragmentProfile extends Fragment {
    View view;
    private TextView nameTextView;
    private TextView ageTextView;

    public FragmentProfile() {

    }

    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.profile_fragment,container,false);
        nameTextView = view.findViewById(R.id.name);
        ageTextView = view.findViewById(R.id.age);


        Bundle Extra = getActivity().getIntent().getExtras();
        if(Extra != null) {
            String name = Extra.getString(Constants.NAME);
            int age = Extra.getInt(Constants.AGE);

            nameTextView.setText(name);
            ageTextView.setText(""+age);
        }
        return view;
    }
}