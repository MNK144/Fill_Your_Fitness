package com.manank.gymapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ViewWorkout extends AppCompatActivity {
    DatabaseHelper db;
    TextView title,desc;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_workout);
        db = new DatabaseHelper(this);
        title = findViewById(R.id.vwt);
        desc = findViewById(R.id.vwd);
        imageView = findViewById(R.id.vwimg);

        int i = (int)getIntent().getLongExtra("id",0)-1;
        title.setText(WorkoutData.name[i]);
        desc.setText(WorkoutData.desc[i]);
        imageView.setImageResource(WorkoutData.image[i]);

    }
}
