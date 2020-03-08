package com.manank.gymapp;

import android.content.Context;
import android.database.Cursor;

import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;


public class CustomDietAdapter extends CursorAdapter {

    public CustomDietAdapter(Context context, Cursor cursor, int flag) {
        super(context, cursor, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return LayoutInflater.from(context).inflate(R.layout.diet_list, viewGroup, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView txtTitle = view.findViewById(R.id.dltitle);
        TextView txtTime = view.findViewById(R.id.dltime);
        ImageView imageView = view.findViewById(R.id.dlimg);

        String title = cursor.getString(cursor.getColumnIndex("title"));
        String time = cursor.getString(cursor.getColumnIndex("time"));
        String img = cursor.getString(cursor.getColumnIndex("images"));

        txtTitle.setText(title);
        txtTime.setText(time);

        File path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES+ "/FillYourFitness/.Diets");
        File imageFile = new File(path, String.valueOf(img));
        imageView.setImageDrawable(Drawable.createFromPath(imageFile.toString()));
    }
}