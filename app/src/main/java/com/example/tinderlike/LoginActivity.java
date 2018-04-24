package com.example.tinderlike;

import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    EditText e1, e2;
    FirebaseAuth auth;
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        e1 = findViewById(R.id.editText2);
        e2 = findViewById(R.id.editText3);
        dialog = new ProgressDialog(this);
        auth = FirebaseAuth.getInstance();
    }


    public void login_User(View v)
    {
        dialog.setMessage("Logging in. please wait");
        dialog.show();

        auth.signInWithEmailAndPassword(e1.getText().toString(), e2.getText().toString())
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful())
                        {
                            Toast.makeText(getApplicationContext(), "You have successfully logged in", Toast.LENGTH_LONG).show();
                            dialog.dismiss();
                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(),"Sorry, you could not be registered", Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }
}
