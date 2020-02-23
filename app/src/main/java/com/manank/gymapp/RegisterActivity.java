package com.manank.gymapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisterActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    EditText eml,pwd,cpwd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mAuth = FirebaseAuth.getInstance();
        Button reg;
        reg = findViewById(R.id.btnregister);
        eml = findViewById(R.id.email);
        pwd = findViewById(R.id.password);
        cpwd = findViewById(R.id.cpassword);

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkRegister();
            }
        });
    }
    private void checkRegister()
    {
        String e,p,cp;
        e = eml.getText().toString();
        p = pwd.getText().toString();
        cp = cpwd.getText().toString();
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        if(e.isEmpty() || p.isEmpty() || cp.isEmpty())
            Toast.makeText(getApplicationContext(),"All fields must be filled",Toast.LENGTH_LONG).show();
        else if(!p.equals(cp))
        {
            Toast.makeText(getApplicationContext(),"Password not matching",Toast.LENGTH_LONG).show();
        }
        else if(p.length()<8)
        {
            Toast.makeText(getApplicationContext(),"Password Must be Atleast 8 Characters Long",Toast.LENGTH_LONG).show();
        }
        else if(!e.matches(emailPattern))
        {
            Toast.makeText(getApplicationContext(),"Enter a Valid Email",Toast.LENGTH_LONG).show();
        }
        else
        {
            mAuth.createUserWithEmailAndPassword(e, p)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Log.d("SignUp", "createUserWithEmail:success");
                                FirebaseUser user = mAuth.getCurrentUser();
                                Toast.makeText(getApplicationContext(),"Account Created Successfully",Toast.LENGTH_LONG).show();
                                RegisterActivity.this.finish();
                            } else {
                                Log.w("SignUp", "createUserWithEmail:failure", task.getException());
                                Toast.makeText(getApplicationContext(), "Sign up Failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
    }
}
