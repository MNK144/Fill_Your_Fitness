package com.manank.gymapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class LoginActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();
        db = new DatabaseHelper(this);
        Button login,reg;
        TextView forgot;
        login = findViewById(R.id.login);
        reg = findViewById(R.id.register);
        forgot = findViewById(R.id.btnForgot);
        final EditText email = findViewById(R.id.username);
        final EditText password = findViewById(R.id.password);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String em = email.getText().toString();
                String ps = password.getText().toString();
                if(em.equals("") || ps.equals("")){
                    Toast.makeText(getApplicationContext(), "All fields must be filled",Toast.LENGTH_LONG).show();
                }else{
                    checkLogin(em,ps);
                }
            }
        });
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),RegisterActivity.class);
                startActivity(i);
            }
        });
        forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),ForgotActivity.class);
                startActivity(i);
            }
        });
    }
    private void checkLogin(String e,String p)
    {
        mAuth.signInWithEmailAndPassword(e, p)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseUser user = mAuth.getCurrentUser();
                            db.setSession(user.getUid(),user.getEmail());
                            Toast.makeText(getApplicationContext(), "Login Successful",Toast.LENGTH_LONG).show();
                            Intent i = new Intent(getApplicationContext(),MainActivity.class);
                            startActivity(i);
                            finish();
                        } else {
                            Toast.makeText(getApplicationContext(), "Login Failed",Toast.LENGTH_LONG).show();
                        }
                    }
                });

    }
}
