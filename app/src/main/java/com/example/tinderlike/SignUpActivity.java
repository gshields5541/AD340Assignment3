package com.example.tinderlike;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;



public class SignUpActivity extends AppCompatActivity {


    ProgressDialog dialog;
    EditText e1_mail, e2_name, e3_password, e4_age, e5_occupation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        dialog = new ProgressDialog(this);
        e1_mail = findViewById(R.id.email);
        e2_name = findViewById(R.id.name);
        e3_password = findViewById(R.id.password);
        e4_age = findViewById(R.id.age);
        e5_occupation = findViewById(R.id.occupation);


        EditText editEmail = findViewById(R.id.email);
        String strEmail = editEmail.getText().toString();

        if(TextUtils.isEmpty(strEmail)) {
            editEmail.setError("Please Enter a Email Address");
        }


        EditText editName = findViewById(R.id.name);
        String strName = editName.getText().toString();

        if(TextUtils.isEmpty(strName)) {
            editEmail.setError("Please Enter Your Name");
        }


        EditText editPass = findViewById(R.id.password);
        String strPass = editPass.getText().toString();

        if(TextUtils.isEmpty(strPass)) {
            editPass.setError("Please Enter a Password");
        }


        EditText editAge = findViewById(R.id.age);
        String strAge = editAge.getText().toString();

        if(TextUtils.isEmpty(strAge)) {
            editAge.setError("Please Enter your full Age");
        }


        EditText editOccup = findViewById(R.id.occupation);
        String strOccup = editOccup.getText().toString();

        if(TextUtils.isEmpty(strOccup)) {
            editOccup.setError("Please Enter your Occupation");
        }
    }

    public void register (View v)
    {
        dialog.setMessage("Registering. . . please wait!!!");
        dialog.show();
        dialog.dismiss();
        Toast.makeText(getApplicationContext(), "You have registered successfully", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(SignUpActivity.this, MultiTabActivity.class);
        int age = Integer.valueOf(e4_age.getText().toString());
        String name = e2_name.getText().toString();
        intent.putExtra(Constants.AGE, age);
        intent.putExtra(Constants.NAME, name);
        startActivity(intent);
    }
}
