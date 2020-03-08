package com.manank.gymapp;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Environment;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;

public class ViewDiet extends AppCompatActivity {
    DatabaseHelper db;
    TextView title,desc,time,cal;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_diet);
        db = new DatabaseHelper(this);
        int id;
        title = findViewById(R.id.vdt);
        desc = findViewById(R.id.vdd);
        imageView = findViewById(R.id.vdimg);
        time = findViewById(R.id.vdtime);
        cal = findViewById(R.id.vdcal);

        Cursor data;
        data=db.getDiet();
        id = (int)getIntent().getLongExtra("id",0);

        data.move(id);
        title.setText(data.getString(1));
        desc.setText(data.getString(2));
        time.setText(time.getText().toString()+data.getString(4));
        cal.setText(cal.getText().toString()+data.getString(5)+"kcal");

        String img = data.getString(3);

        File path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES+ "/FillYourFitness/.Diets");
        File imageFile = new File(path, String.valueOf(img));
        imageView.setImageDrawable(Drawable.createFromPath(imageFile.toString()));
    }
}
