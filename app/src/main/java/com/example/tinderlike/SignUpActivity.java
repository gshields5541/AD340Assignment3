package com.example.tinderlike;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUpActivity extends AppCompatActivity {

    FirebaseAuth auth;
    ProgressDialog dialog;
    EditText e1_mail, e2_name, e3_password, e4_age, e5_occupation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        auth = FirebaseAuth.getInstance();
        dialog = new ProgressDialog(this);
        e1_mail = findViewById(R.id.editText2);
        e2_name = findViewById(R.id.editText3);
        e3_password = findViewById(R.id.editText4);
        e4_age = findViewById(R.id.editText5);
        e5_occupation = findViewById(R.id.editText6);


        EditText editEmail = findViewById(R.id.editText2);
        String strEmail = editEmail.getText().toString();

        if(TextUtils.isEmpty(strEmail)) {
            editEmail.setError("Please Enter a Email Address");
        }


        EditText editName = findViewById(R.id.editText3);
        String strName = editName.getText().toString();

        if(TextUtils.isEmpty(strName)) {
            editEmail.setError("Please Enter Your Name");
        }


        EditText editPass = findViewById(R.id.editText4);
        String strPass = editPass.getText().toString();

        if(TextUtils.isEmpty(strPass)) {
            editPass.setError("Please Enter a Password");
        }


        EditText editAge = findViewById(R.id.editText5);
        String strAge = editAge.getText().toString();

        if(TextUtils.isEmpty(strAge)) {
            editAge.setError("Please Enter your full Age");
        }


        EditText editOccup = findViewById(R.id.editText6);
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
        Intent intent = new Intent(SignUpActivity.this, ProfileActivity.class);
        int age = Integer.valueOf(e4_age.getText().toString());
        String name = e2_name.getText().toString();
        intent.putExtra(Constants.AGE, age);
        intent.putExtra(Constants.NAME, name);
        startActivity(intent);
    }
}
