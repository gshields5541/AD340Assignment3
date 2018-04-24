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

public class SignUpActivity extends AppCompatActivity {

    FirebaseAuth auth;
    ProgressDialog dialog;
    EditText e1_mail, e2_name, e3_password, e4_age;

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
    }

    public void register (View v)
    {
        dialog.setMessage("Registering. . . please wait!!!");
        dialog.show();

        auth.createUserWithEmailAndPassword(e1_mail.getText().toString(), e3_password.getText().toString())
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful())
                        {
                            dialog.dismiss();
                            Toast.makeText(getApplicationContext(), "You have registered successfully", Toast.LENGTH_LONG).show();
                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(), "You could not be registered", Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }
}
