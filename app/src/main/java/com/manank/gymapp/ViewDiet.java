package com.manank.gymapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ViewDiet extends AppCompatActivity {
    DatabaseHelper db;
    TextView title,desc,time,cal,crb,prt;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_diet);
        db = new DatabaseHelper(this);
        title = findViewById(R.id.vdt);
        desc = findViewById(R.id.vdd);
        imageView = findViewById(R.id.vdimg);
        time = findViewById(R.id.vdtime);
        cal = findViewById(R.id.vdcal);
        crb = findViewById(R.id.calcar);
        prt = findViewById(R.id.calprt);

        int i = ((int)getIntent().getLongExtra("id",0))-1;
        String time;
        if(i<5)
            time="Breakfast";
        else if(i<10)
            time="Brunch";
        else if(i<15)
            time="Lunch";
        else if(i<20)
            time="PreWorkout";
        else if(i<25)
            time="PostWorkout";
        else
            time="Dinner";

        title.setText(DietData.name[i]);
        desc.setText(DietData.desc[i]);
        this.time.setText(this.time.getText().toString()+time);
        cal.setText(cal.getText().toString()+String.valueOf(DietData.calories[i])+"kcal");

        Double dcrb = (DietData.calories[i]*4.4);
        Double dprt = (DietData.calories[i]*2.3);
        crb.setText(crb.getText().toString()+dcrb.toString().subSequence(0,2)+"gm");
        prt.setText(prt.getText().toString()+dprt.toString().subSequence(0,2)+"gm");

        imageView.setImageResource(DietData.image[i]);
    }
}
