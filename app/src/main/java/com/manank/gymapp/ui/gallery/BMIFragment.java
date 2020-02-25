package com.manank.gymapp.ui.gallery;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/*
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
*/

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;


import com.manank.gymapp.R;

public class BMIFragment extends Fragment /*implements AdapterView.OnItemSelectedListener */{

    /*
    EditText height,weight,age;
    Spinner gender;
    Button btnbmi;
    String[] users = { "Male", "Female" };
    String genderstr;
    float bmi;
    */

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_bmi, container, false);

/*
        //MAIN CODE
        final LayoutInflater factory = getLayoutInflater();
        final View fragRef = factory.inflate(R.layout.fragment_bmi,null);
        height = fragRef.findViewById(R.id.height);
        weight = fragRef.findViewById(R.id.weight);
        age = fragRef.findViewById(R.id.age);
        btnbmi = fragRef.findViewById(R.id.btnbmi);

        gender = fragRef.findViewById(R.id.gender);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity().getApplicationContext(), android.R.layout.simple_spinner_item, users);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        gender.setAdapter(adapter);
        gender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        Log.d("DEBUG","CLICKED");
        btnbmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("DEBUG","CLICKED");
                if(height==null || weight==null || age==null || genderstr==null){
                    Toast.makeText(getActivity().getApplicationContext(), "All fields must be filled", Toast.LENGTH_LONG).show();
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
                        Toast.makeText(getActivity().getApplicationContext(), "All fields must be filled", Toast.LENGTH_LONG).show();
                    }else{
                        hei = Integer.parseInt(prheight);
                        wei = Integer.parseInt(prweight);
                        ag = Integer.parseInt(prage);

                        bmi = (wei / ((hei * hei) / 10000));
                        Toast.makeText(getActivity().getApplicationContext(), "Height - "+hei+" Weight- "+wei+" Gender- "+genderstr+"\nBMI is " + bmi, Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
        */

    return root;
    }
    /*
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }*/
}