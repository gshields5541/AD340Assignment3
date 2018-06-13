package com.example.tinderlike.Activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tinderlike.R;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    EditText e1_email, e3_password;
    private FirebaseAuth auth;
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        e1_email = findViewById(R.id.email);
        e3_password = findViewById(R.id.password);
        dialog = new ProgressDialog(this);
        auth = FirebaseAuth.getInstance();
    }


    public void login_User(View v)
    {
        dialog.setMessage("Logging in. . . please wait!!!");
        dialog.show();
        auth.signInWithEmailAndPassword(e1_email.getText().toString(), e3_password.getText().toString())
                .addOnCompleteListener(task -> {
                    if(task.isSuccessful())
                    {
                        dialog.dismiss();
                        Toast.makeText(getApplicationContext(), "You have registered successfully", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(LoginActivity.this, MultiTabActivity.class);
                        startActivity(intent);
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(), "You could not be registered", Toast.LENGTH_LONG).show();
                    }
                });

    }
}
