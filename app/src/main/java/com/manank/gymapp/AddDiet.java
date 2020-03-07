package com.manank.gymapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.ByteArrayOutputStream;
public class AddDiet extends AppCompatActivity {
    EditText title,desc;
    String img;
    Button b;
    //byte[] image;
    DatabaseHelper db;
    @SuppressLint("WrongThread")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adddiet);
        db = new DatabaseHelper(getApplicationContext());
        //Drawable d;
        //d = getDrawable(R.mipmap.icon);
        //Bitmap bitmap = ((BitmapDrawable)d).getBitmap();
        //ByteArrayOutputStream stream = new ByteArrayOutputStream();
        //bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        //image = stream.toByteArray();

        title = findViewById(R.id.dtitle);
        desc = findViewById(R.id.ddesc);
        b = findViewById(R.id.dadd);
        img = "https://yourfitnessapp.000webhostapp.com/test/icon.png"; //STATIC FOR NOW

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.setDiet(title.getText().toString(),desc.getText().toString(),img);
                finish();
            }
        });
    }
}
