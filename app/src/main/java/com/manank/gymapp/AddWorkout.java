package com.manank.gymapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;

public class AddWorkout extends AppCompatActivity {
    EditText title,desc;
    Button b;
    byte[] image;
    DatabaseHelper db;
    @SuppressLint("WrongThread")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addworkout);
        db = new DatabaseHelper(getApplicationContext());
        Drawable d;
        d = getDrawable(R.mipmap.icon);
        Bitmap bitmap = ((BitmapDrawable)d).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
        image = stream.toByteArray();

        title = findViewById(R.id.wtitle);
        desc = findViewById(R.id.wdesc);
        b = findViewById(R.id.wadd);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.setWorkout(title.getText().toString(),desc.getText().toString(),image);
                finish();
            }
        });
    }
}
