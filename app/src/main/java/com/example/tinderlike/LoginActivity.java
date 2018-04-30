package com.example.tinderlike;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText e1_email, e3_password;
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        e1_email = findViewById(R.id.email);
        e3_password = findViewById(R.id.password);
        dialog = new ProgressDialog(this);
    }


    public void login_User(View v)
    {
        dialog.setMessage("Registering. . . please wait!!!");
        dialog.show();
        dialog.dismiss();
        Toast.makeText(getApplicationContext(), "You have registered successfully", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(LoginActivity.this, MultiTabActivity.class);
        startActivity(intent);

    }
}
