package com.example.tinderlike.Activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import android.widget.EditText;
import android.widget.Toast;

import com.example.tinderlike.Constants;
import com.example.tinderlike.R;
import com.google.firebase.auth.FirebaseAuth;



public class SignUpActivity extends AppCompatActivity {

    FirebaseAuth auth;
    ProgressDialog dialog;
    EditText e1_mail, e2_name, e3_password, e4_age, e5_occupation, e6_education, e7_summary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        auth = FirebaseAuth.getInstance();
        dialog = new ProgressDialog(this);


        e1_mail = findViewById(R.id.email);
        e2_name = findViewById(R.id.name);
        e3_password = findViewById(R.id.password);
        e4_age = findViewById(R.id.age);
        e5_occupation = findViewById(R.id.occupation);
        e6_education = findViewById(R.id.education);
        e7_summary = findViewById(R.id.Summary);



        EditText edit_Email = e1_mail;
        String str_Email = edit_Email.getText().toString();

        if(TextUtils.isEmpty(str_Email)) {
            edit_Email.setError("Please Enter a Email Address");
        }


        EditText edit_Name = e2_name;
        String str_Name = edit_Name.getText().toString();

        if(TextUtils.isEmpty(str_Name)) {
            edit_Name.setError("Please Enter Your Name");
        }


        EditText edit_Pass = e3_password;
        String strPass = edit_Pass.getText().toString();

        if(TextUtils.isEmpty(strPass)) {
            edit_Pass.setError("Please Enter a Password");
        }


        EditText edit_Age = e4_age;
        String str_Age = edit_Age.getText().toString();

        if(TextUtils.isEmpty(str_Age)) {
            edit_Age.setError("Please Enter your full Age");
        }


        EditText edit_Occup = e5_occupation;
        String str_Occup = edit_Occup.getText().toString();

        if(TextUtils.isEmpty(str_Occup)) {
            edit_Occup.setError("Please Enter your Occupation");
        }

        EditText edit_Educ = e6_education;
        String str_Educ = edit_Educ.getText().toString();

        if(TextUtils.isEmpty(str_Educ)) {
            edit_Occup.setError("Please Enter your Education");
        }

        EditText edit_Sum = e7_summary;
        String str_Sum = edit_Sum.getText().toString();

        if(TextUtils.isEmpty(str_Sum)) {
            edit_Sum.setError("Please tell us about Yourself");
        }


    }

    public void register (View v)
    {
        dialog.setMessage("Registering. . . please wait!!!");
        dialog.show();
        dialog.dismiss();
        Toast.makeText(getApplicationContext(), "You have registered successfully", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(SignUpActivity.this, MultiTabActivity.class);
        String name = e2_name.getText().toString();
        int age = Integer.valueOf(e4_age.getText().toString());
        String occupation = e5_occupation.getText().toString();
        String education = e6_education.getText().toString();
        String summary = e7_summary.getText().toString();


        intent.putExtra(Constants.KEY_AGE, age);
        intent.putExtra(Constants.KEY_NAME, name);
        intent.putExtra(Constants.KEY_OCCUPATION, occupation);
        intent.putExtra(Constants.KEY_EDUCATION, education);
        intent.putExtra(Constants.KEY_SUMMARY, summary);
        startActivity(intent);
    }
}



