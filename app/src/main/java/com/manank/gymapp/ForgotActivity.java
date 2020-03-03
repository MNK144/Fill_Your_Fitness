package com.manank.gymapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot);
        mAuth = FirebaseAuth.getInstance();
        final EditText resetemail = findViewById(R.id.resetemail);
        Button btnreset = findViewById(R.id.btnreset);
        btnreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String remail = resetemail.getText().toString();
                if(remail.equals("")){
                    Toast.makeText(getApplicationContext(), "Field must be filled",Toast.LENGTH_LONG).show();
                }else{
                    sendReset(remail);
                }
            }
        });
    }

    public void sendReset(String remail){
        mAuth.sendPasswordResetEmail(remail).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    Toast.makeText(getApplicationContext(),"Link Sent",Toast.LENGTH_LONG).show();
                    finish();
                }else{
                    Toast.makeText(getApplicationContext(),"Email does not exist",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
