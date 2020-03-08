package com.manank.gymapp;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Environment;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;

public class ViewWorkout extends AppCompatActivity {
    DatabaseHelper db;
    TextView title,desc;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_workout);
        db = new DatabaseHelper(this);
        int id;
        title = findViewById(R.id.vwt);
        desc = findViewById(R.id.vwd);
        imageView = findViewById(R.id.vwimg);

        Cursor data;
        data = db.getWorkout();
        id = (int)getIntent().getLongExtra("id",0);

        data.move(id);
        title.setText(data.getString(1));
        desc.setText(data.getString(2));

        String img = data.getString(3);

        File path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES+ "/FillYourFitness/Workouts");
        File imageFile = new File(path, String.valueOf(img));
        imageView.setImageDrawable(Drawable.createFromPath(imageFile.toString()));
    }
}
