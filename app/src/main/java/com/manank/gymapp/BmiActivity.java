package com.manank.gymapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class BmiActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    EditText height,weight,age;
    Spinner gender;
    Button btnbmi;

    String[] users = { "Male", "Female" };
    String genderstr;

    float bmi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);


        height = findViewById(R.id.height);
        weight = findViewById(R.id.weight);
        age = findViewById(R.id.age);
        btnbmi = findViewById(R.id.btnbmi);

        gender = findViewById(R.id.gender);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, users);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        gender.setAdapter(adapter);
        gender.setOnItemSelectedListener(this);

        btnbmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(height==null || weight==null || age==null || genderstr==null){
                    Toast.makeText(getApplicationContext(), "All fields must be filled", Toast.LENGTH_LONG).show();
                }else {
                    int hei, wei, ag, gen;


                    if (genderstr.equals("Male")) {
                        gen = 1;
                    } else if (genderstr.equals("Female")) {
                        gen = 2;
                    }
                    String prheight = height.getText().toString();
                    String prweight = weight.getText().toString();
                    String prage = age.getText().toString();
                    if(prheight.equals("")||prweight.equals("")||prage.equals("")){
                        Toast.makeText(getApplicationContext(), "All fields must be filled", Toast.LENGTH_LONG).show();
                    }else{
                        hei = Integer.parseInt(prheight);
                        wei = Integer.parseInt(prweight);
                        ag = Integer.parseInt(prage);

                        bmi = (wei / ((hei * hei) / 10000));
                        Toast.makeText(getApplicationContext(), "Height - "+hei+" Weight- "+wei+" Gender- "+genderstr+"\nBMI is " + bmi, Toast.LENGTH_LONG).show();
                    }
                }
            }
        });





    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        genderstr = users[i];
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
